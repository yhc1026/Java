package com.spring.blogsystem.common.exception;


import lombok.Data;

@Data
public class BlogException extends RuntimeException {
    private int code;
    private String errMsg;


    public BlogException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }
}
