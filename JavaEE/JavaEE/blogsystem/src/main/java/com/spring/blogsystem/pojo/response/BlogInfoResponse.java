package com.spring.blogsystem.pojo.response;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BlogInfoResponse {

    private String id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private LocalDate createTime;
    private LocalDate updateTime;
}
