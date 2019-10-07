package com.zjm.controller;

import com.zjm.bean.User;
import com.zjm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
