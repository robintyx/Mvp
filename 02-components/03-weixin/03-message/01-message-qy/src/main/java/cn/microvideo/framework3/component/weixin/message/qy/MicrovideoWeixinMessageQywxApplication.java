package cn.microvideo.framework3.component.weixin.message.qy;

import cn.microvideo.framework3.support.tomcat.util.MicrovideoSupportEmbeddedContainerUtil;
import cn.microvideo.framework3.webapp.cloud.tomcat.MicrovideoWebappCloudTomcatApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class MicrovideoWeixinMessageQywxApplication extends MicrovideoWebappCloudTomcatApplication {
    public static void main(String[] args) {
        Banner banner = MicrovideoSupportEmbeddedContainerUtil.getMicrovideoBannerInstance();
        (new SpringApplicationBuilder(new Class[]{MicrovideoWebappCloudTomcatApplication.class})).banner(banner).run(args);
    }
}
