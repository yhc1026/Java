package com.spring.order.service;


import com.spring.order.mapper.OrderMapper;
import com.spring.order.model.OrderInfo;
import com.spring.order.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public OrderInfo selectOrderInfoById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderInfoById(orderId);
        String url="http://cloud-product/product/selectProductInfoByProductId?productId="+orderInfo.getProductId();
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }

}
