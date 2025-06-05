package cn.microvideo.framework3.component.gateway.openapi;

import cn.microvideo.framework3.core.alibaba.gateway.banner.GatewayEmbeddedContainerUtil;
import cn.microvideo.framework3.core.alibaba.gateway.handler.GatewayBlockRequestHandler;
import cn.microvideo.framework3.core.configuration.MicrovideoConfigurationProperties;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * 感动科技.
 * 启动类.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(MicrovideoConfigurationProperties.class)
@EnableFeignClients(basePackages ={"cn.microvideo"})
@ComponentScan(basePackages = {"cn.microvideo"})
public class MicrovideoGatewayOpenApiApplication implements ApplicationRunner {

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        val banner = GatewayEmbeddedContainerUtil.getMicrovideoBannerInstance();
        new SpringApplicationBuilder(MicrovideoGatewayOpenApiApplication.class).banner(banner).run(args);
        GatewayCallbackManager.setBlockHandler(new GatewayBlockRequestHandler());
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("网关启动完成");
    }
}
