package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.User;
import cn.microvideo.framework3.project.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public Object findAll() {
        return userMapper.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userMapper.selectById(id);
    }

}