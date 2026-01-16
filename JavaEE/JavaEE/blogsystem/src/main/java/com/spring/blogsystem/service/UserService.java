package com.spring.blogsystem.service;


import com.spring.blogsystem.pojo.request.UserLoginRequest;
import com.spring.blogsystem.pojo.response.UserLoginResponse;
import org.springframework.stereotype.Service;

public interface UserService{
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);
    UserLoginResponse checkPassword2(UserLoginRequest userLoginRequest);

    UserLoginResponse getUserInfo(Integer id);

    UserLoginResponse getAuthorInfo(Integer blogId);
}
