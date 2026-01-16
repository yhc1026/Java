package com.spring.blogsystem.common.intercepter;

import com.spring.blogsystem.common.constant.Constants;
import com.spring.blogsystem.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.USER_TOKEN_HEAD_KEY);
        if(token == null){
            log.info("空token");
            response.setStatus(401);
            return false;
        }
        Claims claims = JWTUtils.parseToken(token);
        if(claims==null){
            log.info("token解析失败{}",token);
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
