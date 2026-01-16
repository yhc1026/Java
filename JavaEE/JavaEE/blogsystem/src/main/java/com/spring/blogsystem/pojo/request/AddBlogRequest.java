package com.spring.blogsystem.pojo.request;


import lombok.Data;

@Data
public class AddBlogRequest {

    private Integer userId;
    private String title;
    private String content;

}
