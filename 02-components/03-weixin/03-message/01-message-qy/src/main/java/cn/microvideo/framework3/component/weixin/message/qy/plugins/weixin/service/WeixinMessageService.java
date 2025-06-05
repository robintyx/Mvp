package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.service;

import cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.cache.WeixinMessageCache;
import cn.microvideo.framework3.core.initialization.weixin.message.MicrovideoWeixinMessage;
import cn.microvideo.framework3.core.util.hutool.MicrovideoHutoolHttpUtil;
import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import cn.microvideo.framework3.core.util.string.MicrovideoStringUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.common.message.News;
import com.riversoft.weixin.common.message.Text;
import com.riversoft.weixin.common.message.Textcard;
import com.riversoft.weixin.common.util.JsonMapper;
import com.riversoft.weixin.qy.base.AgentSetting;
import com.riversoft.weixin.qy.base.WxEndpoint;
import com.riversoft.weixin.qy.message.Messages;
import com.riversoft.weixin.qy.message.json.NewsMessage;
import com.riversoft.weixin.qy.message.json.TextCardMessage;
import com.riversoft.weixin.qy.message.json.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业微信-推送消息.
 * @author ningcw@microvideo.cn
 * @since 2022-07-08 12:26:48
 */
@Slf4j
public abstract class WeixinMessageService {
    private static final int DUPLICATE_CHECK_INTERVAL = 1800;
    /**
     * 获取应用配置.
     * @return 应用配置
     */
    public abstract AgentSetting getSettings(Integer agentId);

    public abstract Messages getMessages(Integer agentId);

    /**
     * 推送文本消息.
     * @param agentId 应用id
     * @param data 消息
     */
    protected void sendTextMessage(Integer agentId, MicrovideoWeixinMessage data) {
        try{
            TextMessage text = new TextMessage();
            text.setAgentId(agentId);
            text.setSafe(true);
            text.setToUser(getUser(agentId,data));
            Text content = new Text(data.getContent());
            text.setText(content);
            getMessages(agentId).send(text);
            log.info("推送文本消息成功 应用 [{}] 接收方[{}]",agentId,data.getUser());
        }catch (Exception e){
            log.error("推送文本消息异常 [{}]",e);
        }
    }

    /**
     * 推送文本卡片消息.
     * @param agentId 应用id
     * @param data 消息
     */
    protected void sendTextCardMessage(Integer agentId, MicrovideoWeixinMessage data) {
        try{
            final TextCardMessage textcardMessage = new TextCardMessage();
            textcardMessage.setTextcard(MicrovideoJsonUtil.parseObject(data.getTextcard().toJSONString(), Textcard.class));
            textcardMessage.setToUser(getUser(agentId,data));
            textcardMessage.setAgentId(agentId);
            getMessages(agentId).send(textcardMessage);
            log.info("推送文本卡片成功 应用 [{}] 接收方[{}]",agentId,data.getUser());
        }catch (Exception e){
            log.error("推文本卡片消息异常 [{}]",e);
        }
    }

    /**
     * 推送新闻消息.
     * @param agentId 应用id
     * @param data 消息
     */
    protected void sendNewsMessage(Integer agentId, MicrovideoWeixinMessage data) {
        try{
            final NewsMessage newsMessage = new NewsMessage();
            newsMessage.setNews(MicrovideoJsonUtil.parseObject(data.getNews().toJSONString(), News.class));
            newsMessage.setToUser(getUser(agentId,data));
            newsMessage.setAgentId(agentId);
            getMessages(agentId).send(newsMessage);
            log.info("推送新闻消息成功 应用 [{}] 接收方[{}]",agentId,data.getUser());
        }catch (Exception e){
            log.error("推送新闻消息异常 [{}]",e);
        }
    }

    /**
     * 推送小程序消息.
     * @param agentId 应用id
     * @param data 消息
     */
    protected void sendMiniprogramMessage(Integer agentId, MicrovideoWeixinMessage data) {
        try{
            final JSONObject message = new JSONObject();
            message.put("touser", getUser(agentId,data));
            message.put("toparty", MicrovideoStringUtil.EMPTY);
            message.put("totag", MicrovideoStringUtil.EMPTY);
            message.put("msgtype", "miniprogram_notice");
            message.put("enable_id_trans", 0);
            message.put("enable_duplicate_check", 0);
            message.put("duplicate_check_interval", DUPLICATE_CHECK_INTERVAL);

            data.getMpNotice().put("content_item", data.getMpContent());
            message.put("miniprogram_notice", data.getMpNotice());

            final String url = WxEndpoint.get("url.message.send");
            final String json = JsonMapper.nonEmptyMapper().toJson(message);
            getClient(agentId).post(url, json);
            log.info("推送小程序消息成功 应用 [{}] 接收方[{}]",agentId,data.getUser());
        }catch (Exception e){
            log.error("推送小程序消息异常 [{}]",e);
        }

    }

    private String getUser(Integer agentId, MicrovideoWeixinMessage data){
        //验证是否需要加密
        if(data.isUserEncry()){
            return userIdToOpenUserId(agentId,data.getUser());
        }else{
            return data.getUser();
        }
    }

    //获取客户端
    protected WxClient getClient(Integer agentId) {
        try {
            return getMessages(agentId).getWxClient();
        } catch (Exception e) {
            log.error("获取微信客户端异常 {}", e.toString());
        }
        return null;
    }

    private String userIdToOpenUserId(Integer agentId,String userid){
        StringBuilder result=new StringBuilder();
        try{
            List<String> userIds=new ArrayList<>();
            String url=String.format("https://qyapi.weixin.qq.com/cgi-bin/batch/userid_to_openuserid?access_token=%s",getClient(agentId).getAccessToken().getAccessToken());
            JSONObject bodyJson=new JSONObject();
            JSONArray userJsonArr=new JSONArray();
            if(userid.contains("|")){
                String[] userArr=userid.split("\\|");
                for(String user:userArr){
                    String openUserId= WeixinMessageCache.getUser(user);
                    if(MicrovideoStringUtil.isBlank(openUserId)){
                        userJsonArr.add(user);
                    }else{
                        if(!userIds.contains(openUserId)){
                            userIds.add(openUserId);
                        }
                    }
                }
            }else{
                String openUserId= WeixinMessageCache.getUser(userid);
                if(MicrovideoStringUtil.isBlank(openUserId)){
                    userJsonArr.add(userid);
                }else{
                    if(!userIds.contains(openUserId)){
                        userIds.add(openUserId);
                    }
                }
            }
            if(!CollectionUtils.isEmpty(userJsonArr)){
                bodyJson.put("userid_list",userJsonArr);
                String retData= MicrovideoHutoolHttpUtil.post(url,bodyJson.toJSONString());
                if(retData.contains("userid")){
                    JSONObject retJson= MicrovideoJsonUtil.parseObject(retData);
                    JSONArray userIdArr=retJson.getJSONArray("open_userid_list");
                    for(int i=0;i<userIdArr.size();i++){
                        WeixinMessageCache.setUser(userIdArr.getJSONObject(i).getString("userid"),userIdArr.getJSONObject(i).getString("open_userid"));
                        userIds.add(userIdArr.getJSONObject(i).getString("open_userid"));
                    }
                }
            }
            if(!CollectionUtils.isEmpty(userIds)){
                for(int i=0;i<userIds.size();i++){
                    result.append(userIds.get(i));
                    if(userIds.size()-1!=i){
                        result.append("|");
                    }
                }
            }
        }catch (Exception e){
            result.append(userid);
            log.error("企业微信用户id转换异常 {}", e.toString());
        }
        return result.toString().trim();
    }
}
