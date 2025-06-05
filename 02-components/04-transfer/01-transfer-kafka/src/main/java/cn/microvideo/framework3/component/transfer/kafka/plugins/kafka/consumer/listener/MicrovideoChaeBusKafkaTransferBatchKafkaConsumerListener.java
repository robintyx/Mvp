package cn.microvideo.framework3.component.transfer.kafka.plugins.kafka.consumer.listener;

import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import cn.microvideo.framework3.support.kafka.transfer.services.MicrovideoSupportKafkaTransferRepository;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 感动科技.
 * kafka批量消费.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@Slf4j
@Service
public class MicrovideoChaeBusKafkaTransferBatchKafkaConsumerListener {
    @Resource
    private MicrovideoSupportKafkaTransferRepository repository;

    /**
     * 多线程批量消费
     * @param records 消息内容 不能为空
     * @param ack kafka应答 不能为空
     */
    @KafkaListener(containerFactory = "kafkaBatchListenerDefFactory", topics = "#{'${microvideo.message.batch-topic}'.split(',')}")
    public void batchListener(final List<ConsumerRecord<?, ?>> records, final Acknowledgment ack) {
        try {
            int i = 0;
            int total = records.size();
            for (ConsumerRecord<?, ?> record : records) {
                i++;
                JSONObject jsonObject = MicrovideoJsonUtil.parseObject(record.value().toString());
                log.info("消费到数据 topic:{}  partition:{}  offset:{} value:{}",record.topic(),record.partition(),record.offset(),jsonObject);
                repository.send(record.topic(),jsonObject.toJSONString());
            }
            ack.acknowledge();
        } catch (final Exception e) {
            log.error("Kafka监听异常:[{}]", e.getMessage());
        } finally {
        }
    }
}


