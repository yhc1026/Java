package com.spring.bookmanage.enums;

public enum ResultCodeEnum {

    UNLOGIN(-1),
    ERROR(-2),
    SUCCESS(200);

    private int code;

    ResultCodeEnum(int code) {
        this.code = code;
    }
}
