package cn.microvideo.framework3.component.weixin.token.prop;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

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
@ConfigurationProperties(value = "weixin.token")
public class WeixinTokenConfigurationProperties implements Serializable {

    private static final long serialVersionUID = -121545323555L;

    private String commToken;

    private String mpToken;

    private String tokenKey;

    private String getTicketUrl;

    private String ticketKey;

    private List<WeixinTokenNodeProperties> appNodes;

}
