package cn.microvideo.framework3.db.ags.services.bus.dbm.service;

import java.util.Arrays;
import java.util.List;

import cn.microvideo.framework3.core.initialization.asserts.MicrovideoAssert;
import cn.microvideo.framework3.core.initialization.code.MicrovideoCode;
import cn.microvideo.framework3.core.initialization.constant.MicrovideoConstant;
import cn.microvideo.framework3.core.initialization.exception.MicrovideoBizException;
import cn.microvideo.framework3.core.initialization.page.MicrovideoPage;
import cn.microvideo.framework3.core.initialization.service.MicrovideoService;
import cn.microvideo.framework3.core.initialization.time.MicrovideoTime;
import cn.microvideo.framework3.core.initialization.type.MicrovideoServiceOperationType;
import cn.microvideo.framework3.core.initialization.uuid.MicrovideoUUID;
import cn.microvideo.framework3.core.util.string.MicrovideoStringUtil;
import org.springframework.beans.BeanUtils;

import cn.microvideo.framework3.db.ags.services.bus.dbm.mapper.IGntInfoMapper;
import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfoExample;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoQueryParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoUpdateParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoFormParam;
import org.springframework.util.CollectionUtils;

/**
 * 南京感动科技有限公司.
 * 企业信息表服务
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
public abstract class AbstractGntInfoService extends MicrovideoService<IGntInfoMapper, GntInfoExample, GntInfoExample.Criteria, GntInfoQueryParam, GntInfoUpdateParam> {

    /**
     * 批量添加记录.
     * @param list 含有GntInfo对象的列表，不能为空
     * @return 执行结果，目前固定返回1，表示执行成功
     */
    public int addList(final List<GntInfo> list) {
        try {
            getMapper().batchInsert(list);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     *根据id查询.
     * @param  id 不能为空
     * @return GntInfo
     **/
    public GntInfo findById(final String id) {
        GntInfo result = null;
        try {
            if (MicrovideoStringUtil.isBlank(id)) {
                getLog().error("方法:[findById] 参数:[id] 异常信息:[id为空]", GntInfo.class);
                return null;
            }
            result = getMapper().selectByPrimaryKey(id);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return result;
    }

    /**
     *根据id和版本号查询.
     * @param  id 主键id不能为空
     * @param  version  版本号不能为空
     * @return GntInfo
     **/
    public GntInfo findByIdAndVersion(final String id, final Integer version) {
        GntInfo result = null;
        try {
            if (MicrovideoStringUtil.isBlank(id)) {
                getLog().error("方法:[findByIdAndVersion] 参数:[id] 异常信息:[id为空]", GntInfo.class);
                return null;
            }
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            criteria.andVersionEqualTo(version);
            List<GntInfo> list = getMapper().selectByExample(example);
            if (CollectionUtils.isEmpty(list)){
                return null;
            }
            return list.get(0);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return result;
    }

    /**
     * 添加.
     * @param obj  业务数据  不能为空
     * @return int 1为成功
     */
    public int add(final GntInfo obj) {
        try {
            MicrovideoAssert.IsObjNull(obj, MicrovideoCode.OBJ_IS_NULL);
            String id = obj.getId();
            if (MicrovideoStringUtil.isBlank(id)) {
                id = MicrovideoUUID.get();
                obj.setId(id);
            }
            if (obj.getDataCreateTime() == null) {
                obj.setDataCreateTime(MicrovideoTime.getCurrDate());
            }
            if (obj.getDataUpdateTime() == null) {
                obj.setDataUpdateTime(MicrovideoTime.getCurrDate());
            }
            obj.setDataDelFlag(MicrovideoConstant.LOGICAL_DELETE_NOMAL);
            obj.setVersion(1);
            return getMapper().insert(obj);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 添加.
     * @param obj  业务数据  不能为空
     * @return int 1为成功
     */
    public int addForm(final GntInfoFormParam obj) {
        try {
            MicrovideoAssert.IsObjNull(obj, MicrovideoCode.OBJ_IS_NULL);
            GntInfo data = new GntInfo();
            BeanUtils.copyProperties(obj, data);
            return add(data);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据主键更新数据.
     * @param obj 更新的数据必须要有主键ID  不能为空
     * @return int (0:修改失败数据库中数据不存在,1:修改成功 )
     */
    public int updateForm(final GntInfoFormParam obj) {
        try {
            if (obj == null) {
                getLog().error("方法:[updateById] 参数:[obj] 异常信息:[obj为空]");
                return 0;
            }
            GntInfo data = new GntInfo();
            BeanUtils.copyProperties(obj, data);
            return updateById(data);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }
    /**
     * 根据主键更新数据.
     * @param obj 更新的数据必须要有主键ID  不能为空
     * @return int (0:修改失败数据库中数据不存在,1:修改成功 )
     */
    public int updateById(final GntInfo obj) {
        try {
            if (obj == null) {
                getLog().error("方法:[updateById] 参数:[obj] 异常信息:[obj为空]");
                return 0;
            }
            if (MicrovideoStringUtil.isBlank(obj.getId())) {
                getLog().error("方法:[updateById] 参数:[obj] 异常信息:[obj id 为空]");
                return 0;
            }
            GntInfo srcObj = this.findByIdAndVersion(obj.getId(), obj.getVersion());
            if (srcObj == null) {
                getLog().error("修改失败 数据库中数据不存在");
                return 0;
            }
            obj.setDataCreateTime(srcObj.getDataCreateTime());
            obj.setVersion(srcObj.getVersion()+1);
            return getMapper().updateByPrimaryKey(obj);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据条件更新所有字段数据.
     * @param obj 需要更新的业务数据  不能为空
     * @param cond 更新条件  不能为空
     * @return int (0:修改失败数据库中数据不存在,大于0:修改成功 )
     */
    public int updateAll(final GntInfo obj, final GntInfoUpdateParam cond) {
        try {
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            encodeUpdateCriteria(cond, example, criteria, MicrovideoServiceOperationType.METHOD_TYPE_UPDATE_ALL);
            return getMapper().updateByExample(obj, example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据条件更新指定的字段数据(obj中属性非空的才会更新).
     * @param obj 需要更新的业务数据  不能为空
     * @param cond 更新条件  不能为空
     * @return int (0:修改失败数据库中数据不存在,大于0:修改成功 )
     */
    public int updateSelective(final GntInfo obj, final GntInfoUpdateParam cond) {
        try {
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            encodeUpdateCriteria(cond, example, criteria, MicrovideoServiceOperationType.METHOD_TYPE_UPDATE_SELECTIVE);
            return getMapper().updateByExampleSelective(obj, example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 分页查询.
     * @param cond 查询条件  不能为空
     * @param page 分页条件  不能为空
     * @return List GntInfo
     */
    public List<GntInfo> query(final GntInfoQueryParam cond, MicrovideoPage page) {
        List<GntInfo> returnList = null;
        try {
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            encodeQueryCriteria(cond, example, criteria, MicrovideoServiceOperationType.METHOD_TYPE_QUERY_PAGE);
            criteria.andDataDelFlagEqualTo(MicrovideoConstant.LOGICAL_DELETE_NOMAL);
            if (page != null) {
                page.setTotalNum(getMapper().countByExample(example));
            } else {
                page = new MicrovideoPage(getMapper().countByExample(example), 1, 10);
            }
            example.setPage(page);
            returnList = getMapper().selectByExample(example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return returnList;
    }

    /**
     * 查询.
     * @param cond 查询条件  不能为空
     * @return List GntInfo
     */
    public List<GntInfo> query(final GntInfoQueryParam cond) {
        List<GntInfo> returnList = null;
        try {
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            encodeQueryCriteria(cond, example, criteria, MicrovideoServiceOperationType.METHOD_TYPE_QUERY_LIST);
            criteria.andDataDelFlagEqualTo(MicrovideoConstant.LOGICAL_DELETE_NOMAL);
            example.setPage(null);
            returnList = getMapper().selectByExample(example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return returnList;
    }

    /**
     * 根据主键删除.
     * @param  id   主键id  不能为空
     * @return int (0:删除失败数据库中数据不存在,1:删除成功 )
     */
    public int deleteById(final String id) {
        try {
            GntInfo srcObj = this.findById(id);
            if (srcObj == null) {
                getLog().error("删除异常 数据库中数据不存在");
                return 0;
            }
            return getMapper().deleteByPrimaryKey(id);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据主键逻辑删除.
     * @param  id   主键id  不能为空
     * @param  version   版本号  不能为空
     * @return int (0:删除失败数据库中数据不存在,1:删除成功 )
     */
    public int deleteFlagById(final String id, final Integer version) {
        try {
            GntInfo srcObj = this.findByIdAndVersion(id, version);
            if (srcObj == null) {
                getLog().error("逻辑删除异常 数据库中数据不存在");
                return 0;
            }
            return getMapper().deleteFlagByPrimaryKey(id, version);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据多个主键id批量逻辑删除.
     * @param objId    主键id逗号分隔  不能为空
     * @return int (0:删除失败数据库中数据不存在,大于0:删除成功 )
     */
    public int batchDeleteFlag(final String objId) {
        try {
            if (MicrovideoStringUtil.isBlank(objId)) {
                getLog().error("方法:[batchDeleteFlag] 参数:[objId] 异常信息:[objId为空]");
                return 0;
            }
            String[] objIds = objId.split(",");
            if (objIds.length == 0) {
                getLog().error("方法:[batchDeleteFlag] 参数:[objId] 异常信息:[objIds length is 0]");
                return 0;
            }
            GntInfoExample example = new GntInfoExample();
            example.createCriteria().andIdIn(Arrays.asList(objIds));
            return getMapper().batchDelFlag(example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据多个主键id批量删除.
     * @param objId    主键id逗号分隔  不能为空
     * @return int (0:删除失败数据库中数据不存在,大于0:删除成功 )
     */
    public int batchDelete(final String objId) {
        try {
            if (MicrovideoStringUtil.isBlank(objId)) {
                getLog().error("方法:[batchDelete] 参数:[objId] 异常信息:[objId为空]");
                return 0;
            }
            String[] objIds = objId.split(",");
            if (objIds.length == 0) {
                getLog().error("方法:[batchDelete] 参数:[objId] 异常信息:[objIds length is 0]");
                return 0;
            }
            GntInfoExample example = new GntInfoExample();
            example.createCriteria().andIdIn(Arrays.asList(objIds));
            return getMapper().deleteByExample(example);
        } catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 根据条件删除.
     * @param cond     查询条件
     * @return int (0:删除失败数据库中数据不存在,大于0:删除成功 )
     */
    public int deleteByExample(final GntInfoUpdateParam cond) {
        try {
            GntInfoExample example = new GntInfoExample();
            GntInfoExample.Criteria criteria = example.createCriteria();
            encodeDelCriteria(cond, example, criteria, MicrovideoServiceOperationType.METHOD_TYPE_DELETE_COND);
            return getMapper().deleteByExample(example);
        }catch (final MicrovideoBizException e) {
            MicrovideoAssert.error(MicrovideoCode.DB_ERROR);
        }
        return 1;
    }

    /**
     * 清空表(请谨慎操作).
     * @return int (0:删除失败数据库中数据不存在,大于0:删除成功 )
     */
    public int clearTable() {
        return getMapper().clearTable();
    }

    /**
     * 更新所有数据逻辑删除标记为删除状态.
     * @return int (0:修改失败数据库中数据不存在,大于0:修改成功)
     */
    public int updateAllDelflagToInvalid() {
        GntInfoUpdateParam obj = new GntInfoUpdateParam();
        obj.setDataDelFlag(1);
        GntInfoExample example = new GntInfoExample();
        return getMapper().updateByExampleSelective(obj, example);
    }

    /**
     * 更新逻辑删除标记是正常的数据为删除状态.
     * @return int (0:修改失败数据库中数据不存在,大于0:修改成功 )
     */
    public int updateDelflagValidToInvalid() {
        GntInfoUpdateParam obj = new GntInfoUpdateParam();
        obj.setDataDelFlag(1);
        GntInfoExample example = new GntInfoExample();
        example.createCriteria().andDataDelFlagEqualTo(0);
        return getMapper().updateByExampleSelective(obj, example);
    }
}

