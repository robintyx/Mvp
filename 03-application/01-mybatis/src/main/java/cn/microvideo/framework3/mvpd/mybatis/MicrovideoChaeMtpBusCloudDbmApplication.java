package cn.microvideo.framework3.mvpd.mybatis;

import cn.microvideo.framework3.support.tomcat.util.MicrovideoSupportEmbeddedContainerUtil;
import cn.microvideo.framework3.webapp.cloud.tomcat.MicrovideoSupportCloudMybatisTomcatApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 感动科技.
 * 启动类.
 *
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@EnableDiscoveryClient
@EnableFeignClients
public class MicrovideoChaeMtpBusCloudDbmApplication extends MicrovideoSupportCloudMybatisTomcatApplication {
    public static void main(String[] args) {
        Banner banner = MicrovideoSupportEmbeddedContainerUtil.getMicrovideoBannerInstance();
        (new SpringApplicationBuilder(new Class[]{MicrovideoSupportCloudMybatisTomcatApplication.class})).banner(banner).run(args);
    }
}
