package com.example.demo.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import com.example.demo.model.captchaProperties;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RequestMapping("/captcha")
@RestController
public class captchaController {

    @Autowired
    private captchaProperties captchaProperties;
    private final static Long VALID_TIME = 60*1000L;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        response.setContentType("image/jpeg");
//      response.setCharacterEncoding("UTF-8");
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(captchaProperties.getHeight(), captchaProperties.getWidth(), 4, 10);
        try {
            circleCaptcha.write(response.getOutputStream());
            String code=circleCaptcha.getCode();
            session.setAttribute(captchaProperties.getSession().getCaptchaCode(), code);
            session.setAttribute(captchaProperties.getSession().getTime(), System.currentTimeMillis());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/check")
    public boolean checkCaptcha(String captcha, HttpSession session) {
        if (StringUtils.isEmpty(captcha)){
            return false;
        }
        String code= (String) session.getAttribute(captchaProperties.getSession().getCaptchaCode());
        boolean timeFlag=false;
        Long currentTime=System.currentTimeMillis();
        if(currentTime-VALID_TIME<=(Long) session.getAttribute(captchaProperties.getSession().getTime())){
            timeFlag=true;
        }
        if(code.equalsIgnoreCase(captcha)){
            return timeFlag;
        }
        return false;
    }
}
