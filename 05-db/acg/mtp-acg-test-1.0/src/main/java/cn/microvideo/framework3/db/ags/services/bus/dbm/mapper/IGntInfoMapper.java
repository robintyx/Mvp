package cn.microvideo.framework3.db.ags.services.bus.dbm.mapper;

import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 感动科技.
 * 企业信息表-数据库Mapper.
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Repository
public interface IGntInfoMapper {
    /**
    * 获取总数.
    * @param  example 不能为空.
    * @return int
    */
    int countByExample(GntInfoExample example);

    /**
    * 根据条件删除数据.
    * @param  example 不能为空.
    * @return int
    */
    int deleteByExample(GntInfoExample example);

    /**
    * 根据主键删除.
    * @param  id 不能为空.
    * @return int
    */
    int deleteByPrimaryKey(String id);

    /**
    * 添加数据.
    * @param  param 不能为空.
    * @return int
    */
    int insert(GntInfo param);

    /**
    * 添加数据.
    * @param  param 不能为空.
    * @return int
    */
    int insertSelective(GntInfo param);

    /**
    * 查询.
    * @param  sql 不能为空.
    * @return List GntInfo
    */
    List<GntInfo> selectData(@Param("sql") String sql);

    /**
    * 检查表结构与实体的一致性.
    * @return List GntInfo
    */
    List<GntInfo> checkTable();

    /**
    * 清空数据.
    * @return int
    */
    int clearTable();

    /**
    * 批量添加数据.
    * @param  list 不能为空.
    */
    void batchInsert(@Param("list") List list);

    /**
    * 查询.
    * @param  example 不能为空.
    * @return List GntInfo
    */
    List<GntInfo> selectByExample(GntInfoExample example);

    /**
    * 主键查询.
    * @param  id 不能为空.
    * @return GntInfo
    */
    GntInfo selectByPrimaryKey(String id);

    /**
    * 更新数据.
    * @param  param 不能为空.
    * @param  example 不能为空.
    * @return int
    */
    int updateByExampleSelective(@Param("param") GntInfo param, @Param("example") GntInfoExample example);

    /**
    * 更新数据.
    * @param  param 不能为空.
    * @param  example 不能为空.
    * @return int
    */
    int updateByExample(@Param("param") GntInfo param, @Param("example") GntInfoExample example);

    /**
    * 更新数据.
    * @param  param 不能为空.
    * @return int
    */
    int updateByPrimaryKeySelective(GntInfo param);

    /**
    * 更新数据.
    * @param  param 不能为空.
    * @return int
    */
    int updateByPrimaryKey(GntInfo param);

    /**
    * 逻辑删除.
    * @param  id 不能为空.
    * @param  version 不能为空.
    * @return int
    */
    int deleteFlagByPrimaryKey(@Param("id") String id, @Param("version") int version);

    /**
    * 逻辑删除.
    * @param  example 不能为空.
    * @return int
    */
    int batchDelFlag(@Param("example") GntInfoExample example);
}
