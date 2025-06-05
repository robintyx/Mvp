package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.agent;

import cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.util.WeixinMessageUtil;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.qy.base.AgentSetting;
import org.slf4j.Logger;

/***企业微信应用开发抽象类*/
public abstract class WeixinMessageAgent {
    public abstract Logger getLog();

    //配置
    public abstract AgentSetting getSettings();

    //获取客户端
    protected WxClient getClient() {
        try {
            return new WxClient(WeixinMessageUtil.getToken(), WeixinMessageUtil.getCorpSetting().getCorpId(), getSettings().getSecret());
        } catch (Exception e) {
            getLog().error("获取微信客户端异常 {}", e.toString());
        }
        return null;
    }
}
