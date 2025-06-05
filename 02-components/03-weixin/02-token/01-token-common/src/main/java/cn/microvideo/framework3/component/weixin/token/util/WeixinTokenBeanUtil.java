package cn.microvideo.framework3.component.weixin.token.util;

import cn.microvideo.framework3.core.initialization.spring.SpringUtil;
import cn.microvideo.framework3.support.common.redis.repository.MicrovideoSupportCommonRedisRepository;
import cn.microvideo.framework3.support.kafka.producers.repository.MicrovideoSupportKafkaProducersRepository;
import org.springframework.stereotype.Component;


/**
 * spring工具
 */
@Component
public class WeixinTokenBeanUtil {

    public static MicrovideoSupportCommonRedisRepository getRedisRepository() {
        return SpringUtil.getBean(MicrovideoSupportCommonRedisRepository.class);
    }

    public static MicrovideoSupportKafkaProducersRepository getKafkaProducersRepository() {
        return SpringUtil.getBean(MicrovideoSupportKafkaProducersRepository.class);
    }

}
