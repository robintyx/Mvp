package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.util;

import cn.microvideo.framework3.core.initialization.spring.SpringUtil;
import com.riversoft.weixin.qy.base.AgentSetting;

import java.util.Map;

/**
 * 感动科技.
 * spring工具.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
public class WeixinMessageBeanUtil {
    /**
     * 企业微信.
     * @return MicrovideoChaeSupportLogKafkaRepository
     */
    public static Map<Integer, AgentSetting> getWeixinAgentMap() {
        return (Map<Integer, AgentSetting>) SpringUtil.getBean("agentMap");
    }
}
