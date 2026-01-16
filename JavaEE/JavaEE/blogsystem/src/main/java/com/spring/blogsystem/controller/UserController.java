package com.spring.blogsystem.controller;


import com.spring.blogsystem.pojo.request.UserLoginRequest;
import com.spring.blogsystem.pojo.response.Result;
import com.spring.blogsystem.pojo.response.UserLoginResponse;
import com.spring.blogsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("controller");
        return userService.checkPassword(userLoginRequest);
    }

    @RequestMapping("/myLogin")
    public Result login2(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse response= userService.checkPassword2(userLoginRequest);
        if(response.getId()==-1){
            return Result.fail("空用户",null);
        }
        if(response.getId()==-2){
            return Result.fail("密码错误",null);
        }
        return Result.success(response);
    }

    @RequestMapping("/getUserInfo")
    public UserLoginResponse getUserInfo(Integer userId){
        return userService.getUserInfo(userId);
    }

    @RequestMapping("/getAuthorInfo")
    public UserLoginResponse getAuthorInfo(Integer blogId){
        return userService.getAuthorInfo(blogId);
    }
}
