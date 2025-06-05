package cn.microvideo.framework3.component.web.websocket.app.plugins.executor;

import cn.microvideo.framework3.component.web.websocket.app.plugins.executor.runnable.WebsocketMessageRunnable;
import cn.microvideo.framework3.core.basic.websocket.message.WebsocketBusMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.concurrent.*;

/**
 * 感动科技.
 * 线程池
 * @author microvideo
 * @since Fri Nov 19 19:39:08 CST 2021
 */
public class WebsocketMessageExecutor {
    private static ExecutorService EXECUTOR = new ThreadPoolExecutor(
            20,
            50,
            10,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void sendMessage(final SimpMessagingTemplate messagingTemplate, final WebsocketBusMessage message){
        EXECUTOR.submit(new WebsocketMessageRunnable(messagingTemplate, message));
    }
}
