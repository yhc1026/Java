package com.spring.bookmanage.controller;


import com.spring.bookmanage.constant.Constants;
import com.spring.bookmanage.entity.BookInfo;
import com.spring.bookmanage.entity.UserInfo;
import com.spring.bookmanage.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    List<BookInfo> bookList = new ArrayList<>();

    @RequestMapping("/login")
    public Boolean Login(String username, String password, HttpSession session){
        if(username==null||password==null){
            return false;
        }
        UserInfo userInfo=userInfoService.queryUserInfoByName(username);
        if(userInfo==null){
            return false;
        }
        if(password.equals(userInfo.getPassword())){
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_INFO,userInfo);
            log.info("设置用户信息："+userInfo);
            return true;
        }
        return false;
    }
}
