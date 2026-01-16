package com.spring.bookmanage.entity;


import com.spring.bookmanage.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {

    private ResultCodeEnum code;  //-1：未登录；-2：后端错误；200：正常
    private String errMsg;
    private T data;


    public static <T> Result success(T data) {
        Result result=new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result fail(String errMsg) {
        Result result=new Result();
        result.setCode(ResultCodeEnum.ERROR);
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Result unLogin() {
        Result result=new Result();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("unLogin");
        result.setData(null);
        return result;
    }
}
