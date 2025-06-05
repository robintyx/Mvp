package cn.microvideo.framework3.component.web.websocket.app.plugins.kafka.consumer.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 感动科技.
 * kafka配置.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@Configuration("MicrovideoChaeBusWebsocketKafkaConsumerConfiguration")
@EnableKafka
@Slf4j
@Getter
public class MicrovideoWebsocketKafkaConsumerConfiguration {

    @Value("${microvideo.kafka.consumer.servers}")
    private String servers;
    @Value("${microvideo.kafka.consumer.enable-auto-commit}")
    private boolean enableAutoCommit;
    @Value("${microvideo.kafka.consumer.session-timeout}")
    private String sessionTimeout;
    @Value("${microvideo.kafka.consumer.auto-commit-interval}")
    private int autoCommitInterval;
    @Value("${microvideo.kafka.consumer.group-id}")
    private String groupId;
    @Value("${microvideo.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;
    @Value("${microvideo.kafka.consumer.concurrency}")
    private int concurrency;
    @Value("${microvideo.kafka.consumer.max-poll-records}")
    private int maxPollRecords;
    @Value("${microvideo.kafka.consumer.key-deserializer}")
    private String keyDeserializer;
    @Value("${microvideo.kafka.consumer.value-deserializer}")
    private String valueDeserializer;

    private static final int POLL_TIME_OUT=1500;


    /**默认单线程消费.*/
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(getConfig(false, 0, false));
    }

    /**多线程线程消费.*/
    @Bean
    public ConsumerFactory<String, String> consumerBatchFactoryDef() {
        return new DefaultKafkaConsumerFactory<>(getConfig(true, 0, false));
    }

    /**单线程factory.*/
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        log.info("感动科技-初始化Kafka-单线程factory");
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        factory.setAutoStartup(true);
        factory.setConcurrency(1);
        return factory;
    }


    /**多线程factory.*/
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaBatchListenerDefFactory() {
        log.info("感动科技-初始化Kafka-多线程factory");
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerBatchFactoryDef());
        factory.setConcurrency(concurrency);
        factory.setBatchListener(true);
        factory.setAutoStartup(true);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.getContainerProperties().setPollTimeout(POLL_TIME_OUT);
        return factory;
    }


    /**公共参数 isSetMaxPollRecord=是否设置每批最大条数  maxPollNum=每批拉取最大数量.*/
    private Map<String, Object> getConfig(final boolean isSetMaxPollRecords, final int maxPollNum, final boolean isJsonDeserializer) {
        Map<String, Object> config = new HashMap<>(10);
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        if (isJsonDeserializer) {
            config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        } else {
            config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        }

        config.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        if (isSetMaxPollRecords) {
            if (maxPollNum > 0) {
                config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollNum);
            } else {
                config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
            }
            config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        } else {
            config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
            config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        }
        return config;
    }
}

