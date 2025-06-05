package cn.microvideo.framework3.component.web.websocket.app.plugins.kafka.consumer.listener;

import cn.microvideo.framework3.component.web.websocket.app.plugins.executor.MicrovideoWebsocketMessageExecutor;
import cn.microvideo.framework3.core.basic.websocket.message.WebsocketBusMessage;
import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


/**
 * 感动科技.
 * kafka 单个消费.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@Slf4j
@Service
public class MicrovideoWebsocketOneKafkaConsumerListener {
    @Resource
    private SimpMessagingTemplate messagingTemplate;

    /**
     * description : gps推送服务消费者
     * version : 1.0 
     * date : 2022/8/27 15:31 
     * @author : zhaoc 
     * [record]
     * @return void 
     */ 
    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "${microvideo.message.one-topic}")
    public void container(final ConsumerRecord<?, ?> record) {
        WebsocketBusMessage message = MicrovideoJsonUtil.parseObject(record.value().toString(), WebsocketBusMessage.class);
        MicrovideoWebsocketMessageExecutor.sendMessage(messagingTemplate, message);
    }
}
