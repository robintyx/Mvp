package cn.microvideo.framework3.component.web.websocket.push.business;

import cn.microvideo.framework3.core.basic.websocket.message.WebsocketBusMessage;
import cn.microvideo.framework3.core.basic.websocket.repository.MicrovideoWebsocketRepository;
import cn.microvideo.framework3.core.initialization.handler.MicrovideoAbstractHandlers;
import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import cn.microvideo.framework3.core.initialization.type.MicrovideoWebsocketType;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ningcw
 * @description webssocket消息推送测试
 * @date 2020/11/26 9:44
 */
@Controller
@Slf4j
public class WebsocketPushTestController extends MicrovideoAbstractHandlers {

    @Resource
    private MicrovideoWebsocketRepository repository;

    @RequestMapping("/test/send")
    public MicroviceoHttpRsp test() {
        WebsocketBusMessage message=new WebsocketBusMessage();
        message.setBusType("aaaaa");
        message.setToType(MicrovideoWebsocketType.ALL.getCode());
        message.setToId("aaaaaaaaaaaaaaa");
        message.setData("aaaa");
        repository.send(message);
        return success("推送websocket消息至kafka成功");
    }

    @Override
    public Logger getLog() {
        return log;
    }
}
