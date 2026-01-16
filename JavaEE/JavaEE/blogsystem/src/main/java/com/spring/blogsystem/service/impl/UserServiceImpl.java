package com.spring.blogsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.blogsystem.common.exception.BlogException;
import com.spring.blogsystem.mapper.BlogInfoMapper;
import com.spring.blogsystem.mapper.UserInfoMapper;
import com.spring.blogsystem.pojo.dataobject.BlogInfo;
import com.spring.blogsystem.pojo.dataobject.UserInfo;
import com.spring.blogsystem.pojo.request.UserLoginRequest;
import com.spring.blogsystem.pojo.response.UserLoginResponse;
import com.spring.blogsystem.service.UserService;
import com.spring.blogsystem.utils.BeansTransUtils;
import com.spring.blogsystem.utils.JWTUtils;
import com.spring.blogsystem.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BeansTransUtils beansTransUtils;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {

        log.info("userLoginRequest:{}", userLoginRequest);

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName, userLoginRequest.getUsername());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if(userInfo == null){
            log.info("userInfo is null");
            throw new BlogException(-1,"用户不存在");
        }

//        if(!userInfo.getPassword().equals(userLoginRequest.getPassword())){
//            log.info("password wrong");
//            throw new BlogException(-1,"密码错误");
//        }

        if(!SecurityUtils.check(userInfo.getPassword(), userLoginRequest.getPassword())){
            log.info("password wrong");
            throw new BlogException(-1,"密码错误");
        }

        log.info("success");
        Map<String,  Object> map = new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("username",userInfo.getUserName());
        String token = JWTUtils.generateJWTToken(map);
        return new UserLoginResponse(userInfo.getId(), token, userInfo.getUserName());
    }

    @Override
    public UserLoginResponse checkPassword2(UserLoginRequest userLoginRequest) {
//        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(UserInfo::getUserName, userLoginRequest.getUsername()).eq(UserInfo::getPassword, userLoginRequest.getPassword());
//        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        UserInfo userInfo = userInfoMapper.selectByUsername(userLoginRequest.getUsername());

        if(userInfo == null){
            log.info("userInfo is null");
            //throw new BlogException(-1,"用户不存在");
            return new UserLoginResponse(-1,"用户不存在", null) ;
        }

//        if(!userInfo.getPassword().equals(userLoginRequest.getPassword())){
//            log.info("password wrong");
//            //throw new BlogException(-1,"密码错误");
//            return new UserLoginResponse(-2,"密码错误", null) ;
//        }

        if(!SecurityUtils.check(userInfo.getPassword(), userLoginRequest.getPassword())){
            log.info("password wrong");
//            throw new BlogException(-1,"密码错误");
            return new UserLoginResponse(-2,"密码错误", null) ;
        }

        log.info("success");
        Map<String,  Object> map = new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("username",userInfo.getUserName());
        String token = JWTUtils.generateJWTToken(map);
        return new UserLoginResponse(userInfo.getId(), token, userInfo.getUserName());
    }

    @Override
    public UserLoginResponse getUserInfo(Integer id) {
        UserInfo userInfo = userInfoMapper.selectById(id);
        if(userInfo == null){
            log.info("userInfo is null");
            throw new BlogException(-1,"用户不存在");
        }
        return beansTransUtils.transUser(userInfo);
    }

    @Override
    public UserLoginResponse getAuthorInfo(Integer blogId) {

        BlogInfo blogInfo = blogInfoMapper.selectById(blogId);
        if(blogInfo == null){
            log.info("blogInfo is null");
            throw new BlogException(-1,"博客不存在");
        }

        UserInfo userInfo = userInfoMapper.selectById(blogInfo.getUserId());
        if(userInfo == null){
            log.info("userInfo is null");
            throw new BlogException(-1,"用户不存在");
        }

        return beansTransUtils.transUser(userInfo);
    }
}
