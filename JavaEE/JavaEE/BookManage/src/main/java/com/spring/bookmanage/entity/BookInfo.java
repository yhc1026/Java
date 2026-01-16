package com.spring.bookmanage.entity;


import lombok.Data;

import java.util.Date;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private Integer price;
    private String publish;
    private Integer status;
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
