package com.spring.order.service;


import com.spring.model.ProductInfo;
import com.spring.order.api.ProductApi;
import com.spring.order.mapper.OrderMapper;
import com.spring.order.model.OrderInfo;
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

    @Autowired
    private ProductApi productApi;

    public OrderInfo selectOrderInfoById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderInfoById(orderId);
//        String url="http://cloud-product/product/selectProductInfoByProductId?productId="+orderInfo.getProductId();
//        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        ProductInfo productInfo = productApi.selectProductInfoByProductId(orderInfo.getProductId());
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }

}
