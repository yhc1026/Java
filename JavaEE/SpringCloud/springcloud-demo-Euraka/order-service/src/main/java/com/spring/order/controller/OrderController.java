package com.spring.order.controller;


import com.spring.order.model.OrderInfo;
import com.spring.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/selectOrderInfoByOrderId")
    public OrderInfo selectOrderInfoByOrderId(Integer orderId) {
        return orderService.selectOrderInfoById(orderId);
    }

}
