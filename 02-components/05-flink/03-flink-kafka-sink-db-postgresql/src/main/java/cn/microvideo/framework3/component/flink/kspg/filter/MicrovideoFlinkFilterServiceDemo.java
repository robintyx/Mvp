package cn.microvideo.framework3.component.flink.kspg.filter;

import cn.microvideo.framework3.core.configuration.model.support.FlinkProperties;
import cn.microvideo.framework3.core.flink.message.MicrovideoFlinkMessage;
import cn.microvideo.framework3.core.flink.service.MicrovideoFlinkFilterService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author ningchuanwei
 * @description Service 注入的名称 要与报文中的 busType 一致
 * @date 2023/11/24 9:50
 */
@Slf4j
@Service("Flink_Filter_Demo")
public class MicrovideoFlinkFilterServiceDemo extends MicrovideoFlinkFilterService {

    //日志
    @Override
    public Logger getFlinkLog() {
        return log;
    }

    @Override
    public boolean process(FlinkProperties config, MicrovideoFlinkMessage message) {
        return true;
    }

}
