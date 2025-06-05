package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.util;

import cn.microvideo.framework3.core.initialization.spring.SpringUtil;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.qy.base.CorpSetting;
import com.riversoft.weixin.qy.base.WxEndpoint;
import com.riversoft.weixin.qy.message.Messages;
import com.riversoft.weixin.qy.oauth2.QyOAuth2s;

/**
 * 企业微信工具类
 */
public class WeixinMessageUtil {
    //获取企业微信-token请求地址
    public static String getToken() {
        return WxEndpoint.get("url.token.get");
    }

    //获取企业微信-获取message
    public static WxClient getWxClient() {
        return new WxClient(getToken(), getCorpSetting().getCorpId(), getCorpSetting().getCorpSecret());
    }

    //获取企业微信-获取message
    public static Messages getMessages() {
        Messages message = Messages.defaultMessages();
        message.setWxClient(getWxClient());
        return message;
    }

    //获取企业微信-获取message
    public static Messages getMessages(WxClient client) {
        Messages message = Messages.defaultMessages();
        message.setWxClient(client);
        return message;
    }

    /***获取企业微信配置*/
    public static CorpSetting getCorpSetting() {
        return (CorpSetting) SpringUtil.getBean(CorpSetting.class);
    }

    /***获取企业微信oauth2*/
    public static QyOAuth2s getQiyeWeixinOAuth2() {
        return (QyOAuth2s) SpringUtil.getBean(QyOAuth2s.class);
    }
}
