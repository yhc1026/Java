package com.spring.bookmanage.service;


import com.spring.bookmanage.entity.UserInfo;
import com.spring.bookmanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfo queryUserInfoByName(String username) {
        return userInfoMapper.queryUserInfoByName(username);
    }
}
