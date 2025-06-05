package cn.microvideo.framework3.mvpd.mybatis.business.enterprise;

import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import cn.microvideo.framework3.core.initialization.time.MicrovideoTime;
import cn.microvideo.framework3.core.initialization.uuid.MicrovideoUUID;
import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import cn.microvideo.framework3.db.ags.services.bus.dbm.service.AbstractGntInfoService;
import cn.microvideo.framework3.core.scauser.handler.ScgUserHandlers;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 感动科技.
 * 企业信息表-通用服务.
 * @author microvideo
 * @since Sat Apr 13 18:12:32 CST 2024
 */
@Schema(name = "企业")
@Tag(name = "企业")
@RestController
@Slf4j
@RequestMapping("/test")
public class EnterpriseController extends ScgUserHandlers {
    @Override
    public Logger getChaeLog() {
        return log;
    }

    @Resource
    private AbstractGntInfoService service;


    @RequestMapping(value="addList", method={RequestMethod.GET})
    public MicroviceoHttpRsp addList() {
        List<GntInfo> list=new ArrayList<>();
        GntInfo obj=new GntInfo();
        obj.setVersion(1);
        obj.setId(MicrovideoUUID.get());
        obj.setRoadName("京沪");
        obj.setRoadCode("1");
        obj.setDataCreateTime(MicrovideoTime.getCurrDate());
        obj.setDataUpdateTime(MicrovideoTime.getCurrDate());
        obj.setDataDelFlag(0);
        list.add(obj);
        obj.setVersion(2);
        obj.setId(MicrovideoUUID.get());
        obj.setRoadName("京沪");
        obj.setDataCreateTime(MicrovideoTime.getCurrDate());
        obj.setDataUpdateTime(MicrovideoTime.getCurrDate());
        obj.setDataDelFlag(0);
        list.add(obj);
        service.addList(list);
        return success("测试完成");
    }

    @RequestMapping(value="api", method={RequestMethod.GET})
    public MicroviceoHttpRsp test() {
        return success("测试完成");
    }
}

