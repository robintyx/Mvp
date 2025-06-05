package cn.microvideo.framework3.component.flink.ksmysql;

import cn.microvideo.framework3.support.tomcat.util.MicrovideoSupportEmbeddedContainerUtil;
import cn.microvideo.framework3.webapp.cloud.tomcat.MicrovideoWebappCloudTomcatApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 感动科技.
 * 启动类.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
public class MicrovideoFlinkKsmysqlApplication extends MicrovideoWebappCloudTomcatApplication {
    public static void main(String[] args) {
        Banner banner = MicrovideoSupportEmbeddedContainerUtil.getMicrovideoBannerInstance();
        (new SpringApplicationBuilder(new Class[]{MicrovideoWebappCloudTomcatApplication.class})).banner(banner).run(args);
    }
}
