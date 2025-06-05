package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Section;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SectionMapper {
    List<Section> selectAll();
}
