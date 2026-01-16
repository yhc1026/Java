package com.spring.mybatis.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class UserInfo {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
