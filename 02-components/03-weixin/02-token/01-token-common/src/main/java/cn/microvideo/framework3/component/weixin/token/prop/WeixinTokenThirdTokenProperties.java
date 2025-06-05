package cn.microvideo.framework3.component.weixin.token.prop;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 微信token配置
 *
 * @author zhangh
 * 2022/10/21 09:44:34
 **/
@Getter
@Setter
@Accessors(chain = true)
@Component
@ConfigurationProperties(value = "third.token")
public class WeixinTokenThirdTokenProperties implements Serializable {

    private static final long serialVersionUID = 6118801897464414359L;

    private String appId;

    private String secert;

    private String tokenUrl;

    private String tokenKey;

    private String ticketUrl;

    private String ticketKey;

    private String aesKey;

}
