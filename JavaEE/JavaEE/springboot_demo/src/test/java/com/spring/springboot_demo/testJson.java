package com.spring.springboot_demo;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

public class testJson {

    @Test
    public void ObjectToJson(){
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("yhc",666, "2004/10/26");
        user.setUsername("yhc");
        user.setUsernum(666);
        user.setBirthday("2000/01/01");
        //对象转json
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }

    @Test
    public void JsonToObject(){
        ObjectMapper mapper = new ObjectMapper();
        String s="{\"birthday\":\"2000/01/01\",\"username\":\"yhc\",\"usernum\":666}";
        //json转对象
        User user=mapper.readValue(s,User.class);
        System.out.println(user);
    }
}
