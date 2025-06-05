package cn.microvideo.framework3.component.weixin.token.prop;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: zhangh
 * @Description: 微信token appid secert配置
 * @Date: create in 9:48 2022/10/21 0021
 */
@Getter
@Setter
@Accessors(chain = true)
public class WeixinTokenNodeProperties implements Serializable {

    private static final long serialVersionUID = -2600996981339638782L;

    private String appId;

    private String secert;

    private boolean getTicket;

    private boolean sendKafka;

    private String tokenTopic;

    private String type="COMM";

}
