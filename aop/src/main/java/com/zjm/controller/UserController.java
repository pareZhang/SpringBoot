package com.zjm.controller;

import com.zjm.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/getUserById")
    public String GetUserById(Integer id){
        return userService.getUserById(id);
    }
    @GetMapping("/deleteUserById")
    public void deleteUserById(Integer id){
         userService.deleteUserById(id);
    }
}
