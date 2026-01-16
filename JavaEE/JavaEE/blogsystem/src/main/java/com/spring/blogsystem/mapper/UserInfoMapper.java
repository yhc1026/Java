package com.spring.blogsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.blogsystem.pojo.dataobject.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from user_info where user_name=#{username}")
    UserInfo selectByUsername(String username);
}
