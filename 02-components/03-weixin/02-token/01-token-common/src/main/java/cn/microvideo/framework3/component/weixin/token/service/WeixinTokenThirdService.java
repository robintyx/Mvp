package cn.microvideo.framework3.component.weixin.token.service;

import cn.microvideo.framework3.component.weixin.token.prop.WeixinTokenThirdTokenProperties;
import cn.microvideo.framework3.component.weixin.token.util.WeixinTokenAesUtil;
import cn.microvideo.framework3.component.weixin.token.util.WeixinTokenBeanUtil;
import cn.microvideo.framework3.component.weixin.token.util.WeixinTokenHttpUtil;
import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhangh
 * @Description:
 * @Date: create in 10:26 2022/10/18 0018
 */
@Service
@Slf4j
public class WeixinTokenThirdService {

    @Autowired
    private WeixinTokenThirdTokenProperties thirdTokenProperties;

    /**
     * 获取token和ticket存入redis
     * @param
     * @param
     */
    public void addTokenToRedis() {
        log.info("获取token的url为：" + thirdTokenProperties.getTokenUrl());
        String tokenresult = WeixinTokenHttpUtil.sendHttpGet(thirdTokenProperties.getTokenUrl());
        log.info("获取token响应为：" + tokenresult);
        if (null != tokenresult && tokenresult.contains("true")) {
            JSONObject res = MicrovideoJsonUtil.parseObject(tokenresult);
            if (null != res) {
                String data = res.getString("data");
                JSONObject tokenres = MicrovideoJsonUtil.parseObject(data);
                String tokenRes = tokenres.getString("data");
                String access_token = WeixinTokenAesUtil.aesDecrypt(tokenRes, thirdTokenProperties.getAesKey(), thirdTokenProperties.getAesKey().substring(0, 16));
                log.info("解密后的access_token为：" + access_token);
                JSONObject tk = MicrovideoJsonUtil.parseObject(access_token);
                String key = thirdTokenProperties.getTokenKey() + thirdTokenProperties.getAppId() + "-" + thirdTokenProperties.getSecert();
                WeixinTokenBeanUtil.getRedisRepository().set(key, tk.getString("access_token"));
                log.info("access_token成功存入redis");
            }
        }

        log.info("获取jsticket的url为：" + thirdTokenProperties.getTicketUrl());
        String ticketresult = WeixinTokenHttpUtil.sendHttpGet(thirdTokenProperties.getTicketUrl());
        log.info("获取ticket响应为：" + ticketresult);
        if (null != ticketresult && ticketresult.contains("true")) {
            JSONObject res = MicrovideoJsonUtil.parseObject(ticketresult);
            if (null != res) {
                String data = res.getString("data");
                JSONObject ticketres = MicrovideoJsonUtil.parseObject(data);
                String jsticketres = ticketres.getString("data");
                String jsticket = WeixinTokenAesUtil.aesDecrypt(jsticketres, thirdTokenProperties.getAesKey(), thirdTokenProperties.getAesKey().substring(0, 16));
                log.info("解密后的jsticket为：" + jsticket);
                JSONObject js = MicrovideoJsonUtil.parseObject(jsticket);
                String key = thirdTokenProperties.getTicketKey() + thirdTokenProperties.getAppId() + "-" + thirdTokenProperties.getSecert();
                WeixinTokenBeanUtil.getRedisRepository().set(key, js.getString("jsapi_ticket"));
                log.info("jsticket成功存入redis");
            }
        }
    }
}
