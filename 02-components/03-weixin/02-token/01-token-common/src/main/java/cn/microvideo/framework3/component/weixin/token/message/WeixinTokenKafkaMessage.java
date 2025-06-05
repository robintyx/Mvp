package cn.microvideo.framework3.component.weixin.token.message;


import lombok.Data;

/**
 * @Auther: zhangh
 * @Description: 推送kafka的token报文
 * @Date: create in 9:48 2022/10/21 0021
 */
@Data
public class WeixinTokenKafkaMessage {
    /** 类型  */
    private String type;
    /** 应用id  */
    private String agentid;
    /** 微信公众平台appid  */
    private String appid;
    /** 微信公众平台secret  */
    private String secert;
    /** 微信公众平台用户基础信息token  */
    private String baseToken;
    /** 微信公众平台js票据token */
    private String ticketToken;
    /** 提供方  */
    private String provider;
    /** 生成时间  */
    private String createTime;
    /** 备用字段1  */
    private String rsv1;
    /** 备用字段2  */
    private String rsv2;
    /** 备用字段3  */
    private String rsv3;
    /** 备用字段4  */
    private String rsv4;
    /** 备用字段5  */
    private String rsv5;

}
