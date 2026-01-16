package com.spring.springboot_demo;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@RequestMapping("/request")
@RestController
public class RequestController {

    @RequestMapping("/r1")
    public String r1(String keyword){
        return "r1:"+keyword;
    }

    @RequestMapping("/r2")
    public String r2(@RequestParam(value="q",required = false) String keyword){
        return "r2:"+keyword;
    }

    @RequestMapping("/r3")
    public String r3(String[] arr){
        return Arrays.toString(arr);
    }

    @RequestMapping("/r4")
    public String r4(@RequestBody User user){
        return "user:"+user.toString();
    }

    @RequestMapping("/r5/{articleId}")
    public String r5(@PathVariable Integer articleId){
        return "articleId:"+articleId;
    }

    @RequestMapping("/r6")
    public String r6(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("F:"));
        return  "r6:"+file.getOriginalFilename();
    }

    @RequestMapping("/r7")
    public String r7(HttpServletRequest request, HttpServletResponse response) {
        String body=request.getParameter("body");
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "success r7";
    }

    @RequestMapping("/r8")
    public String r8(@CookieValue("name") String name) {
        return "name in cookie:"+name;
    }

    @RequestMapping("/r9")
    public String r9SetSession(HttpServletRequest request) {
        //从cookie中获取session id，根据session id获取session对象
        HttpSession session=request.getSession(true); //true: 如果没有获取到session，返回空的session对象
        session.setAttribute("name","yhc"); //这里将未来获取的用户数据写死了，实际情况是从客户端请求中获取详细的用户信息填写在这里
        session.setAttribute("age",20);
        return "success set session r9";
    }

    @RequestMapping("/r10")
    public String r10GetSession(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        if(session==null){
            return "no session";
        }
        else{
            String username=(String)session.getAttribute("name");
            return "username:"+username;
        }
    }

    @RequestMapping("/r11")
    public String r11GetSession(HttpSession session) {
        if(session==null){
            return "no session";
        }
        else{
            String username=(String)session.getAttribute("name");
            return "username:"+username;
        }
    }

    @RequestMapping("/r12")
    public String r12GetSession(@SessionAttribute("name") String name) {
        if(name==null){
            return "no attribute";
        }
        else{
            return "username:"+name;
        }
    }

    @RequestMapping("/r13")
    public String r13GetHeader(HttpServletRequest request) {
        String header=request.getHeader("User-Agent");
        return "header:"+header;
    }
}

