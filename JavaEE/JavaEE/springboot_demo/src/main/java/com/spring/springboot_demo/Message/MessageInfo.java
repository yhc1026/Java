package com.spring.springboot_demo.Message;
import lombok.Data;

@Data       //lombok工具中的Data注解可以自动生成getter，setter，tostring方法
public class MessageInfo {
    private String message;
    private String from;
    private String to;
}
