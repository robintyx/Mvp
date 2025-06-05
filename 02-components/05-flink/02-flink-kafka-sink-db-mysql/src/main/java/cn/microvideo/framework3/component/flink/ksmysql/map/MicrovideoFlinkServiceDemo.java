package cn.microvideo.framework3.component.flink.ksmysql.map;

import cn.microvideo.framework3.core.flink.context.MicrovideoFlinkContext;
import cn.microvideo.framework3.core.flink.service.MicrovideoFlinkService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ningchuanwei
 * @description Service 注入的名称 要与报文中的 busType 一致
 * @date 2023/11/24 9:50
 */
@Slf4j
@Service("Flink_Map_Demo")
public class MicrovideoFlinkServiceDemo extends MicrovideoFlinkService {

    //日志
    @Override
    public Logger getFlinkLog() {
        return log;
    }

    //前缀处理
    @Override
    public MicrovideoFlinkContext before(MicrovideoFlinkContext context) {
        return context;
    }

    //业务处理
    @Override
    public MicrovideoFlinkContext process(MicrovideoFlinkContext context) {
        return context;
    }

    //后置处理
    @Override
    public MicrovideoFlinkContext after(MicrovideoFlinkContext context) {
        return context;
    }

    //返回处理
    @Override
    public String result(MicrovideoFlinkContext context) {
        //返回的数据将会sink到kafka中 正常应该返回json格式的数据
        Map map= JSON.parseObject(context.getMessage().getData().toJSONString(),Map.class);
        return context.getMessage().getData().toJSONString();
    }

}
