package com.spring.springboot_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/v1")
    public String hello1(){
        return "hello1";
    }

}
