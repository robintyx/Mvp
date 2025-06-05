package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.service;

import cn.microvideo.framework3.core.initialization.weixin.MicrovideoWeixinQyMessageType;
import cn.microvideo.framework3.core.initialization.weixin.message.MicrovideoWeixinMessage;
import cn.microvideo.framework3.core.util.string.MicrovideoStringUtil;
import com.riversoft.weixin.qy.base.AgentSetting;
import com.riversoft.weixin.qy.message.Messages;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 企业微信-推送消息.
 * @author ningcw@microvideo.cn
 * @since 2022-07-08 12:26:48
 */
@Slf4j
@Service
public class WeixinMessageMessageService extends WeixinMessageService {
    @Resource
    private Map<Integer, AgentSetting> agentMap;
    @Resource
    private Map<Integer, Messages> mesageMap;

    @Override
    public AgentSetting getSettings(Integer agentId) {
        return agentMap.get(agentId);
    }
    @Override
    public Messages getMessages(Integer agentId) {
        return mesageMap.get(agentId);
    }

    public void sendMessage(MicrovideoWeixinMessage message) {
        if(message.getAppid()==null){
            log.error("推送消息异常appid is null ");
            return;
        }
        if(MicrovideoStringUtil.isBlank(message.getMessageType())){
            log.error("推送消息异常messageType is null ");
            return;
        }
        if(MicrovideoStringUtil.isBlank(message.getUser())){
            log.error("推送消息异常 user is null");
            return;
        }
        AgentSetting agentSetting=getSettings(message.getAppid());
        if(agentSetting==null){
            log.error("推送消息异常 没有应用[{}]配置 请进行配置 ",message.getAppid());
            return;
        }
        if(message.getMessageType().trim().equals(MicrovideoWeixinQyMessageType.TEXT.getCode())){
            sendTextMessage(message.getAppid(),message);
        } else if(message.getMessageType().trim().equals(MicrovideoWeixinQyMessageType.MINIPROGRAM.getCode())){
            sendMiniprogramMessage(message.getAppid(),message);
        }else if(message.getMessageType().trim().equals(MicrovideoWeixinQyMessageType.NEWS.getCode())){
            sendNewsMessage(message.getAppid(),message);
        } else if(message.getMessageType().trim().equals(MicrovideoWeixinQyMessageType.TEXTCARD.getCode())){
            sendTextCardMessage(message.getAppid(),message);
        } else{
            log.error("推送消息异常 没有消息类型[{}] ",message.getMessageType());
        }
    }
}


