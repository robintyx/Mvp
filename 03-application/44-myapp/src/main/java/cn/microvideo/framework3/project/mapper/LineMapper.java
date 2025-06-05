package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Line;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineMapper {
    List<Line> selectAll();

    List<Line> selectById(Integer id);

    int deleteById(Integer id);

    int insertLine(Line line);

    int updateLine(Line line);
}