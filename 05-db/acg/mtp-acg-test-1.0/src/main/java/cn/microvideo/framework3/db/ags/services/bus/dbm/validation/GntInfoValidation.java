package cn.microvideo.framework3.db.ags.services.bus.dbm.validation;

import cn.microvideo.framework3.core.initialization.asserts.MicrovideoAssert;
import cn.microvideo.framework3.core.initialization.code.MicrovideoCode;
import cn.microvideo.framework3.core.initialization.exception.MicrovideoBizException;
import cn.microvideo.framework3.core.initialization.mybatis.MicrovideoMybatisValidation;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import cn.microvideo.framework3.db.ags.services.bus.dbm.mapper.IGntInfoMapper;

/**
 * 南京感动科技有限公司.
 * (t_gnt_info校验Mybatis Xml字段与实际表字段是否一致
 * @author microvideo
  * @since Thu Aug 08 14:46:23 CST 2024
 */
@Slf4j
@Configuration("GntInfoValidation")
public class GntInfoValidation extends MicrovideoMybatisValidation {
    @Autowired
     private IGntInfoMapper mapper;

    @Override
    public void validation() {
        try {
            mapper.checkTable();
            log.info("感动科技-校验Mybatis Xml字段与实际表(t_gnt_info)字段是否一致，校验成功");
        } catch (final MicrovideoBizException e) {
            log.error("感动科技-校验Mybatis Xml字段与实际表(t_gnt_info)字段是否一致，校验失败请检查表(t_gnt_info)");
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        } catch (final Exception e) {
            log.error("感动科技-校验Mybatis Xml字段与实际表(t_gnt_info)字段是否一致，校验失败请检查表(t_gnt_info)");
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
    }

    @PostConstruct
    public void init() {
        this.validation();
    }
}
