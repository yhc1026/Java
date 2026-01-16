package com.spring.order.controller;


import com.spring.model.ProductInfo;
import com.spring.order.api.ProductApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/feign")
@RestController
public class FeignController {

    @Autowired
    private ProductApi productApi;

    /**
     * 通过远程调用访问p1方法
     * @param id
     * @return
     */
    @RequestMapping("/p1")
    public String p1(Integer id){
        return productApi.p1(id);
    }

    @RequestMapping("/p2")
    public String p2(Integer id, String name){
        return productApi.p2(id, name);
    }

    @RequestMapping("/p3")
    public String p3(Integer id,  String name){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setProductName(name);
        return productApi.p3(productInfo);
    }

    @RequestMapping("/p4")
    public String p4(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(1);
        productInfo.setProductName("测试");
        return productApi.p4(productInfo);
    }
}
