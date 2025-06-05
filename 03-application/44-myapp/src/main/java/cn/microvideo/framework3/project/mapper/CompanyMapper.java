package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    List<Company> selectAll();
}
