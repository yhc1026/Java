package com.spring.bookmanage.enums;

public enum BookStatusEnum {
    DELETE(0, "delete"),
    NORMAL(1, "normal"),
    FORBIDDEN(2, "forbidden");

    private Integer code;
    private String desc;
    BookStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BookStatusEnum getByCode(Integer code) {
        switch (code){
            case 0: return BookStatusEnum.DELETE;
            case 1: return BookStatusEnum.NORMAL;
            case 2: return BookStatusEnum.FORBIDDEN;
            default: return null;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
