package com.spring.blogsystem.pojo.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponse {
    private Integer id;
    private String token;
    private String userName;
}
