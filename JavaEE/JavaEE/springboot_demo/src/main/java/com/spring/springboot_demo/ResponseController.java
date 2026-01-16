package com.spring.springboot_demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/response")
@RestController
public class ResponseController {

    @RequestMapping("/r1")
    public User r1returnJson(){
        User user = new User("yhc",666, "2004/10/26");
        return user;
    }

    @RequestMapping("/r2")
    public User r2SetStatus(HttpServletResponse response){
        response.setStatus(401);
        User user = new User("yhc",666, "2004/10/26");
        return user;
    }

    @RequestMapping("/r3")
    public String r3SetHeader(HttpServletResponse response){
        response.setHeader("myHeader","myheader");
        return "success";
    }
}
