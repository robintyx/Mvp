package cn.microvideo.framework3.component.transfer.kafka.plugins.kafka.consumer.listener;

import cn.microvideo.framework3.core.util.json.MicrovideoJsonUtil;
import cn.microvideo.framework3.support.kafka.transfer.services.MicrovideoSupportKafkaTransferRepository;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


/**
 * 感动科技.
 * kafka 单个消费.
 * @author microvideo
 * @since Mon Nov 22 16:51:46 CST 2021
 */
@Slf4j
@Service
public class MicrovideoChaeBusKafkaTransferOneKafkaConsumerListener {
    @Resource
    private MicrovideoSupportKafkaTransferRepository repository;

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic1}'.split(',')}")
    public void container(final ConsumerRecord<?, ?> record , final Acknowledgment ack) {
        send("container1",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic2}'.split(',')}")
    public void container2(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container2",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic3}'.split(',')}")
    public void container3(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container3",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic4}'.split(',')}")
    public void container4(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container4",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic5}'.split(',')}")
    public void container5(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container5",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic6}'.split(',')}")
    public void container6(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container6",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic7}'.split(',')}")
    public void container7(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container7",record,ack);
    }

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{'${microvideo.message.one-topic8}'.split(',')}")
    public void container8(final ConsumerRecord<?, ?> record, final Acknowledgment ack) {
        send("container8",record,ack);
    }

    private void send(String tag,ConsumerRecord<?, ?> record,  Acknowledgment ack){
        log.info("{} 消费到数据  topic:{}  partition:{}  offset:{} value:{}",tag,record.topic(),record.partition(),record.offset(),record.value().toString());
        boolean isSend=true;
        JSONObject jsonObject =null;
        try{
            jsonObject = MicrovideoJsonUtil.parseObject(record.value().toString());
        }catch (JSONException e){
            log.error("{} 费到数据 格式错误 topic:{}  partition:{}  offset:{} value:{}",tag,record.topic(),record.partition(),record.offset(),record.value().toString());
            isSend=false;
        }
        if(!isSend || jsonObject == null){
            ack.acknowledge();
            return;
        }
        log.info("{} 费到数据 topic:{}  partition:{}  offset:{} value:{}",tag,record.topic(),record.partition(),record.offset(),jsonObject);
        if(repository.send(record.topic(),jsonObject.toJSONString())){
            log.info("{} 费到数据 topic:{}  partition:{}  offset:{} value:{} 手动提交完成",tag,record.topic(),record.partition(),record.offset(),jsonObject);
            ack.acknowledge();
        }
    }

}

