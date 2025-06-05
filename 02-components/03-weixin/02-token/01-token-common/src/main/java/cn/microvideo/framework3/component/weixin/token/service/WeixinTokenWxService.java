package cn.microvideo.framework3.component.weixin.token.service;

import cn.hutool.core.date.DateUtil;
import cn.microvideo.framework3.component.weixin.token.prop.WeixinTokenConfigurationProperties;
import cn.microvideo.framework3.component.weixin.token.prop.WeixinTokenNodeProperties;
import cn.microvideo.framework3.component.weixin.token.message.WeixinTokenKafkaMessage;
import cn.microvideo.framework3.component.weixin.token.util.WeixinTokenBeanUtil;
import cn.microvideo.framework3.core.util.hutool.MicrovideoHutoolHttpUtil;
import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhangh
 * @Description:
 * @Date: create in 10:26 2022/10/18 0018
 */
@Service
@Slf4j
public class WeixinTokenWxService {

    @Autowired
    private WeixinTokenConfigurationProperties wxTokenConfigurationProperties;

    /**
     * 获取token存入redis
     *
     * @param
     * @param
     */
    public void addTokenToRedis() {
        List<WeixinTokenNodeProperties> nodes = wxTokenConfigurationProperties.getAppNodes();
        String commTokenUrl = wxTokenConfigurationProperties.getCommToken();
        String mpTokenUrl = wxTokenConfigurationProperties.getMpToken();
        String tokenKey = wxTokenConfigurationProperties.getTokenKey();
        if (!CollectionUtils.isEmpty(nodes)) {
            nodes.forEach(node -> {
                String appId = node.getAppId();
                String secret = node.getSecert();
                String tokenUrl = String.format(commTokenUrl, appId, secret);
                if(node.getType().equals("MP")){
                    tokenUrl = String.format(mpTokenUrl, appId, secret);
                }
                log.info("请求的url为：" + tokenUrl);
                String result = MicrovideoHutoolHttpUtil.get(tokenUrl);
                log.info("获取token响应为：" + result);
                if (null != result && result.contains("access_token")) {
                    JSONObject res = MicrovideoJsonUtil.parseObject(result);
                    if (null != res) {
                        String access_token = res.getString("access_token");
                        log.info("获取到access_token为：" + access_token);
                        String key = tokenKey + appId + "-" + secret;
                        WeixinTokenBeanUtil.getRedisRepository().getRedisTemplate().opsForValue().set(key, access_token);
                        log.info("access_token成功存入redis");
                        boolean isGetTicket = node.isGetTicket();
                        if (isGetTicket) {
                            addTicketToRedis(access_token, appId, secret, node);
                        } else {
                            if (node.isSendKafka()) {
                                sendKafka(appId, secret, access_token, null, node.getTokenTopic());
                            }
                        }
                    }
                }
            });
        }
    }

    /**
     * 获取ticket存入redis
     *
     * @param token
     * @param appId
     * @param secret
     */
    public void addTicketToRedis(String token, String appId, String secret, WeixinTokenNodeProperties node) {
        String getTicketUrl = wxTokenConfigurationProperties.getGetTicketUrl();
        String ticketKey = wxTokenConfigurationProperties.getTicketKey();
        String ticketUrl = String.format(getTicketUrl, token);
        String ticketResult = MicrovideoHutoolHttpUtil.get(ticketUrl);
        if (null != ticketResult && ticketResult.contains("ticket")) {
            JSONObject ticres = MicrovideoJsonUtil.parseObject(ticketResult);
            String ticket = ticres.getString("ticket");
            log.info("获取到ticket为：" + ticket);
            String key = ticketKey + appId + "-" + secret;
            WeixinTokenBeanUtil.getRedisRepository().set(key, ticket);
            log.info("ticket成功存入redis");
            if (node.isSendKafka()) {
                sendKafka(appId, secret, token, ticket, node.getTokenTopic());
            }
        }
    }

    /**
     * 获取全部Token
     *
     * @return
     */
    public Map<String, String> getWxTokenRedis() {
        Map<String, String> res = new HashMap<>();
        List<WeixinTokenNodeProperties> nodes = wxTokenConfigurationProperties.getAppNodes();
        String tokenKey = wxTokenConfigurationProperties.getTokenKey();
        if (!CollectionUtils.isEmpty(nodes)) {
            nodes.forEach(node -> {
                String appId = node.getAppId();
                String secret = node.getSecert();
                String value = WeixinTokenBeanUtil.getRedisRepository().get(tokenKey + appId + "-" + secret).toString();
                if (StringUtils.isNotBlank(value)) {
                    res.put(appId, value);
                }
            });
        }
        return res;
    }

    /**
     * 推送kafka
     * @param appid
     * @param secret
     * @param baseToken
     * @param ticketToken
     * @param topic
     */
    private void sendKafka(String appid, String secret, String baseToken, String ticketToken, String topic) {
        WeixinTokenKafkaMessage result = new WeixinTokenKafkaMessage();
        result.setType("测试");
        result.setAgentid("000");
        result.setAppid(appid);
        result.setSecert(secret);
        result.setBaseToken(baseToken);
        result.setTicketToken(ticketToken);
        result.setProvider("0000");
        result.setCreateTime(DateUtil.now());
        log.info("token数据推送kafka成功！！！！！");
    }

}
