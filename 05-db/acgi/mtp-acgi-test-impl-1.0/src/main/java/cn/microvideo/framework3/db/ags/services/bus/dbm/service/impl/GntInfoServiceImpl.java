package cn.microvideo.framework3.db.ags.services.bus.dbm.service.impl;

import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfoExample;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoQueryParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoUpdateParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.service.AbstractGntInfoService;
import cn.microvideo.framework3.core.initialization.type.MicrovideoServiceOperationType;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.microvideo.framework3.db.ags.services.bus.dbm.mapper.IGntInfoMapper;
import lombok.extern.slf4j.Slf4j;

/**    
 * 南京感动科技有限公司.
 * @title: IGntInfoServiceImpl.java
 * @description: 企业信息表
 * @author microvideo
 * @version V3.0.0-RELEASES
 */
@Slf4j
@Service("GntInfoLocalService")
public class GntInfoServiceImpl extends AbstractGntInfoService {

    @Autowired
    private IGntInfoMapper mapper;

    @Override
    public IGntInfoMapper getMapper() {
        return mapper;
    }

    @Override
    public Logger getLog() {
        return log;
    }

    /**
     *封装查询条件.
     * @param  cond 查询条件 不能为空
     * @param  criteria 数据库操作对象 不能为空
     * @param  operation 操作类型 不能为空
     * @return DbmBaseEnterpriseExample.Criteria
     **/
    @Override
    protected GntInfoExample.Criteria encodeQueryCriteria(GntInfoQueryParam cond, GntInfoExample example, GntInfoExample.Criteria criteria, MicrovideoServiceOperationType operation) {
        switch (operation){
            case METHOD_TYPE_QUERY_PAGE:
                break;
            case METHOD_TYPE_QUERY_LIST:
                break;
            default:
                break;
        }
        return criteria;
    }

    /**
     *封装更新条件.
     * @param  cond 查询条件 不能为空
     * @param  criteria 数据库操作对象 不能为空
     * @param  operation 操作类型 不能为空
     * @return GntInfoExample.Criteria
     **/
    @Override
    protected GntInfoExample.Criteria encodeUpdateCriteria(GntInfoUpdateParam cond, GntInfoExample example, GntInfoExample.Criteria criteria, MicrovideoServiceOperationType operation) {
        switch (operation){
            case METHOD_TYPE_UPDATE_SELECTIVE:
                break;
            case METHOD_TYPE_UPDATE_ALL:
                break;
            default:
                break;
        }
        return criteria;
    }

    /**
     *封装删除条件.
     * @param  cond 查询条件 不能为空
     * @param  criteria 数据库操作对象 不能为空
     * @param  operation 操作类型 不能为空
     * @return GntInfoExample.Criteria
     **/
    @Override
    protected GntInfoExample.Criteria encodeDelCriteria(GntInfoUpdateParam cond, GntInfoExample example, GntInfoExample.Criteria criteria, MicrovideoServiceOperationType operation) {
        switch (operation){
            case METHOD_TYPE_DELETE_COND:
                break;
            default:
                break;
        }
        return criteria;
    }
}
