package com.spring.mybatis.service;


import com.spring.mybatis.mapper.UserInfoMapper;
import com.spring.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> getAllUsers() {
        return userInfoMapper.selectAll();
    }

    public UserInfo selectById(int id) {
        return userInfoMapper.selectById(id);
    }

    public Integer insertUser(UserInfo userInfo) {
        System.out.println(userInfo.getId());
        return userInfoMapper.insertUser(userInfo);
    }
}
