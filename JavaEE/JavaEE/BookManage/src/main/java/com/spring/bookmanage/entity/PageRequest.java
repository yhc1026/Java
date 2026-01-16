package com.spring.bookmanage.entity;


import lombok.Data;

@Data
public class PageRequest {

    private Integer currentPage=1;
    private Integer pageSize=10;
    private Integer offset;

    public Integer getOffset() {
        offset=(currentPage-1)*pageSize;
        return offset;
    }

}
