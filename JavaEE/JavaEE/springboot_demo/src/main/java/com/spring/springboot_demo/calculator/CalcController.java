package com.spring.springboot_demo.calculator;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class CalcController {

    @RequestMapping("/sum")
    public String CalcController(Integer num1,Integer num2){
        if(num1==null||num2==null){
            return "input error";
        }
        Integer result=num1+num2;
        return ("<h1>sum= "+result+"</h1>");
    }
}
