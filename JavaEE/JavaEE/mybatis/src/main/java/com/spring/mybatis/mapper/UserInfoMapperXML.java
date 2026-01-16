package com.spring.mybatis.mapper;


import com.spring.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {


    List<UserInfo> selectAll();
}
