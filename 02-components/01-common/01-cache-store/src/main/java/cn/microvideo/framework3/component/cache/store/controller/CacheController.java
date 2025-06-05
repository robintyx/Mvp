package cn.microvideo.framework3.component.cache.store.controller;

import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import cn.microvideo.framework3.core.scauser.handler.ScgUserHandlers;
import cn.microvideo.framework3.support.cache.repository.MicrovideoSupportCacheRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CacheController extends ScgUserHandlers {

    @Override
    public Logger getChaeLog() {
        return log;
    }

    @Autowired
    private MicrovideoSupportCacheRepository repository;

    @GetMapping("/test")
    public MicroviceoHttpRsp test( ) {
        String key="2024-05-30";
        repository.getRepository().set(key,"重货平台");
        log.info("添加完成");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return success("成功");
    }

}

