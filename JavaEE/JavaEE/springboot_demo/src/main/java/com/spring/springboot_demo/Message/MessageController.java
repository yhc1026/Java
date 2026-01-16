package com.spring.springboot_demo.Message;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {

    private List<MessageInfo> messageInfoList=new ArrayList<>();

    @RequestMapping(value="/puttolist", produces = "application/json")    //produces: 始终返回json数据
    public String putToList(@RequestBody MessageInfo messageInfo){    //requestBody：将前端传入的json参数转换为对象格式；如果不加这个注解，就需要用传参的方式挨个传，然后该方法将其组装成一个对象
        if(messageInfo.getFrom()==null
           &&messageInfo.getTo()==null
           &&messageInfo.getMessage()==null){
            return "{\"ok\":0}";
        }
        messageInfoList.add(messageInfo);
        return "{\"ok\":1}";
    }

    @RequestMapping("/getlist")
    public List<MessageInfo> getList(){
        return messageInfoList;
    }
}
