package cn.microvideo.framework3.component.weixin.message.qy.plugins.kafka.consumer.listener;

import cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.service.WeixinMessageMessageService;
import cn.microvideo.framework3.core.initialization.weixin.message.MicrovideoWeixinMessage;
import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import cn.microvideo.framework3.core.util.string.MicrovideoStringUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


/**
 * 感动科技.
 * kafka 单个消费.
 * @author ningcw@microvideo.cn
 */
@Slf4j
@Service
public class WeixinMessageKafkaConsumerListener {

    @Resource
    private WeixinMessageMessageService messageService;

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.wxmessage.topic}'.split(',')}")
    public void container(final ConsumerRecord<?, ?> record) {
        log.info("topic [{}]  消费企业微信推送消息 topic:[{}]  partition:[{}] offset:[{}] value:[{}]", MicrovideoStringUtil.EMPTY, record.topic(), record.partition(), record.offset(), record.value());
        try{
            messageService.sendMessage(MicrovideoJsonUtil.parseObject(record.value().toString(), MicrovideoWeixinMessage.class));
        }catch (Exception e){
            log.error("消费企业微信推送消息报文异常 [{}]",e);
        }
    }
}
