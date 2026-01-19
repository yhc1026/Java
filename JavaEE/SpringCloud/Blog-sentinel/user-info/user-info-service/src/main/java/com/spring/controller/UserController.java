package com.spring.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.spring.api.UserServiceAPI;
import com.spring.api.pojo.UserInfoRegisterRequest;
import com.spring.api.pojo.UserInfoRequest;
import com.spring.api.pojo.UserInfoResponse;
import com.spring.api.pojo.UserLoginResponse;
import com.spring.pojo.Result;
import com.spring.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController implements UserServiceAPI {

    @Autowired
    private UserService userService;

    /**
     * 加入了对于接口的安全保护，通过Sentinel注解+Sentinel控制台配置实现
     * 修改了UserLoginResponse，添加了msg属性，可能会报错
     */
    @SentinelResource(value = "/user/login", blockHandler = "loginBlockHandler")
    @Override
    public Result<UserLoginResponse> login(@Validated @RequestBody UserInfoRequest user){
        log.info("用户登录, userName: {}", user.getUserName());
        return Result.success(userService.login(user));
    }
    public Result<UserLoginResponse> loginBlockHandler(@Validated @RequestBody UserInfoRequest user, BlockException e){
        log.info("用户登录, userName: {}", user.getUserName());
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setMsg("用户登录, 请稍后再试");
        return Result.success(userLoginResponse);
    }


    @Override
    public Result<UserInfoResponse> getUserInfo(@NotNull Integer userId){
        return Result.success(userService.getUserInfo(userId));
    }


    @Override
    public Result<UserInfoResponse> getAuthorInfo(@NotNull Integer blogId){
        return Result.success(userService.selectAuthorInfoByBlogId(blogId));
    }


    @SentinelResource(value = "/user/register", blockHandler = "registerBlockHandler")
    @Override
    public Result<Integer> register(@Validated @RequestBody UserInfoRegisterRequest registerRequest) {
        return Result.success(userService.register(registerRequest));
    }
    public Result<Integer> registerBlockHandler(@Validated @RequestBody UserInfoRegisterRequest registerRequest, BlockException e){
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setMsg("用户注册, 请稍后再试");
        return Result.success(userLoginResponse);
    }
}
