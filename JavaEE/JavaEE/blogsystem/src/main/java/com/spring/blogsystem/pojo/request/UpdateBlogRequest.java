package com.spring.blogsystem.pojo.request;


import lombok.Data;

@Data
public class UpdateBlogRequest {

    private Integer id;
    private String title;
    private String content;

}
