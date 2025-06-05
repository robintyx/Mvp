package cn.microvideo.framework3.component.web.websocket.app.plugins.executor.runnable;

import cn.microvideo.framework3.core.basic.websocket.message.WebsocketBusMessage;
import cn.microvideo.framework3.core.initialization.type.MicrovideoWebsocketType;
import cn.microvideo.framework3.support.websocket.data.WebsocketSessionData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * 感动科技.
 * 实时推送救援消息
 *
 * @author microvideo
 * @since Fri Nov 19 19:39:08 CST 2021
 */
@Slf4j
public class WebsocketMessageRunnable implements Runnable {
    private SimpMessagingTemplate template;
    private WebsocketBusMessage message;

    public WebsocketMessageRunnable(final SimpMessagingTemplate template, final WebsocketBusMessage message) {
        this.template = template;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            ConcurrentMap<String, Set<String>> userSessionIds = WebsocketSessionData.users;
            Set<String> sets = userSessionIds.keySet();

            ConcurrentMap<String, Set<String>> groupUserSessionIds = WebsocketSessionData.group_users;
            Set<String> groupSets = groupUserSessionIds.keySet();

            String toType = message.getToType();
            if (sets.size() > 0) {
                //所有
                if (MicrovideoWebsocketType.ALL.getCode().equals(toType)) {
                    template.convertAndSend("/queue/message", message.getData());
                }
                //组
                if (MicrovideoWebsocketType.GROUP.getCode().equals(toType)) {
                    if (groupSets.size() > 0) {
                        Set<String> set = (Set) WebsocketSessionData.group_users.get(message.getToId());
                        if (null != set && set.size() > 0) {
                            for (String toId : set) {
                                template.convertAndSendToUser(toId, "/queue/message", message.getData());
                            }
                        }
                    }
                }
                //个人
                if (MicrovideoWebsocketType.PERSONAL.getCode().equals(toType)) {
                    template.convertAndSendToUser(message.getToId(), "/queue/message", message.getData());
                }
            }
            log.info("websocket实时推送救援数据，异步推送完成");
        } catch (final Exception e) {
            log.error("websocket实时推送救援数据异常:[{}]", e.getMessage());
        }
    }

}

