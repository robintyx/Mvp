package cn.microvideo.framework3.component.cache.store.listener;

import cn.microvideo.framework3.support.cache.caffeine.listener.MicrovideoCaffeineRemovalListener;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.stereotype.Component;

/**
 *缓存清除监听器名称
 */
@Slf4j
@Component("ExampleRemovalListener")
public class ExampleRemovalListener implements MicrovideoCaffeineRemovalListener {

    @Override
    public void onRemoval(@Nullable String s, @Nullable Object o, RemovalCause removalCause) {
        try {
            log.info("清除了数据【{}】【{}】", s, o.toString());
        }catch (Exception e){
            log.error("清除了数据异常【{}】【{}】", s, e);
        }

    }
}
