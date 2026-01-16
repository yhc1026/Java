package com.spring.transaction.controller;

import com.spring.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 只要手动创建了事务，就必须显式调用 commit() 才会生效。
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition definitions;

    @RequestMapping("/registry")
    public String registry(String name,String password) {

        TransactionStatus transaction=dataSourceTransactionManager.getTransaction(definitions);

        //⽤⼾注册
        userService.registryUser(name, password);
//        dataSourceTransactionManager.commit(transaction);
        dataSourceTransactionManager.rollback(transaction);
        return "注册成功";
    }

    @Transactional      //事务注解
    @RequestMapping("/registryAnnotation")
    public String registry2(String name,String password) {
        //⽤⼾注册
        userService.registryUser(name, password);
        return "注册成功";
    }

}
