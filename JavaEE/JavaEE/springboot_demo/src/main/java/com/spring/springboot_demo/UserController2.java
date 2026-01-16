package com.spring.springboot_demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController2 {
    @RequestMapping("/m1")
    public String m1(){
        return "m1";
    }

    @RequestMapping("/getuser")
    public String getUser(User user){
        String str=user.toString();
        return str;
    }
}
