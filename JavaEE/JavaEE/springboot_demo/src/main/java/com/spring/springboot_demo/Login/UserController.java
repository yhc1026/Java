package com.spring.springboot_demo.Login;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/login")
    public Boolean login(String username, String password, HttpSession session){
        //未学习数据库相关，先写死
        if(username==null||password==null){
            return false;
        }
        if("yhc".equals(username)&&"123456".equals(password)){
            session.setAttribute("username",username);
            return true;
        }
        return false;
    }

    @RequestMapping("/getloginuser")
    public String getLoginUser(HttpSession session){
        return (String)session.getAttribute("username");
    }
}
