package com.spring.aop.controller;


import com.spring.aop.advice.annotation.annotationRealize;
import com.spring.aop.advice.annotation.annotationTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/AOP")
public class AOPController {

    /**
     * 使用传统方式进行AOP编程
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/test1")
    public String testAOPClassic() throws InterruptedException {
        log.info("AOPController 测试传统AOP");
        TimeUnit.MILLISECONDS.sleep(10);
        return "complete";
    }



    /**
     * 使用annotation的方式进行AOP编程
     * @return
     * @throws InterruptedException
     */
    @annotationTest
    @RequestMapping("/test2-1")
    public String testAOPAnnotation() throws InterruptedException {
        log.info("AOPController 测试AOP annotation");
        TimeUnit.MILLISECONDS.sleep(10);
        return "complete";
    }

    @annotationTest
    @RequestMapping("/test2-2")
    public String testAOPAnnotation2() throws InterruptedException {
        log.info("AOPController 测试AOP annotation二号接口");
        TimeUnit.MILLISECONDS.sleep(50);
        return "complete 二号接口";
    }
}
