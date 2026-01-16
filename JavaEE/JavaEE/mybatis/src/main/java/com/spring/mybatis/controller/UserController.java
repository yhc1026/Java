package com.spring.mybatis.controller;


import com.spring.mybatis.model.UserInfo;
import com.spring.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/getAllUser")
    public List<UserInfo> getAllUser(){
        return userService.getAllUsers();
    }

    @RequestMapping("/selectById")
    private UserInfo getUserInfo(int id){
        return userService.selectById(id);
    }

    @RequestMapping("/insertUser")
    private Integer insertUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(1);
        userInfo.setPassword("123456");
        userInfo.setUsername("yhc");
        return userService.insertUser(userInfo);
    }
}
