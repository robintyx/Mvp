package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Stake;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StakeMapper {
    List<Stake> findAll();

    Stake getStakeById(Integer id);

    int insertStake(Stake stake);

    int updateStake(Stake stake);

    int deleteStakeById(Integer stakeId);
}
