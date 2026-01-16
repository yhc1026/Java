package com.example.demo.model;


import jakarta.websocket.Session;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@ConfigurationProperties(prefix = "captcha")
@Configuration
@Data
public class captchaProperties {
    private Integer width;
    private Integer height;
    private Session session;

    @Data
    public static class Session {
        private String captchaCode;
        private String time;
    }
}
