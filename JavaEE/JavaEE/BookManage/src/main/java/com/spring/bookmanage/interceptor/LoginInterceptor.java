package com.spring.bookmanage.interceptor;

import com.spring.bookmanage.constant.Constants;
import com.spring.bookmanage.entity.Result;
import com.spring.bookmanage.entity.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("目标代码执行前");
        HttpSession session = request.getSession(false);
        if(!checkStatus(session)){
            response.setStatus(401);
            return false;
        }
        //true放行，false拦截
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法执行后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("完成后");
    }

    public boolean checkStatus(HttpSession session) {
        if(session==null||(session.getAttribute(Constants.SESSION_USER_INFO)==null)){
            //用户未登录
            return false;
        }
        UserInfo userInfo=(UserInfo)session.getAttribute(Constants.SESSION_USER_INFO);
        if ((userInfo==null)||(userInfo.getId()<=0)){
            //用户未登录
            return false;
        }
        return true;
    }
}
