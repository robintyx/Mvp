package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.config;

import cn.microvideo.framework3.core.configuration.MicrovideoConfigurationProperties;
import com.riversoft.weixin.qy.base.AgentSetting;
import com.riversoft.weixin.qy.base.CorpSetting;
import com.riversoft.weixin.qy.oauth2.QyOAuth2s;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ningchuanwei
 * @description
 * @com 感动科技
 * @date 2021/11/05 14:16
 **/
@Slf4j
@Configuration("microvideoSupportWeixinMessageQiyeConfiguration")
@EnableConfigurationProperties(MicrovideoConfigurationProperties.class)
public class WeixinMessageConfiguration {

    //企业微信配置
    @Bean
    public CorpSetting corpSetting() {
        log.info("感动科技-初始化-企业微信");
        return CorpSetting.defaultSettings();
    }

    //企业微信Agents配置
    @Bean
    public Map<Integer, AgentSetting> agentMap() {
        Map<Integer, AgentSetting> agentMap = new HashMap<Integer, AgentSetting>();
        CorpSetting settings = CorpSetting.defaultSettings();
        if (settings != null && !CollectionUtils.isEmpty(settings.getAgents())) {
            for (AgentSetting item : settings.getAgents()) {
                agentMap.put(item.getAgentId(), item);
            }
        }
        return agentMap;
    }

    //企业微信配置
    @Bean
    public QyOAuth2s qyOAuth2s() {
        return QyOAuth2s.with(CorpSetting.defaultSettings());
    }
}
