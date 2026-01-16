package com.spring.log.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/log")
@RestController
public class logController {

    public final static Logger logger = LoggerFactory.getLogger(logController.class);

    @RequestMapping("/printLog")
    public String printLog(){
        System.out.println("sout print");
        logger.info("logger print");
        return "print log";
    }
}
