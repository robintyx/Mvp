package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectById(Integer id);

    List<User> findAll();

    int insert(User user);
}