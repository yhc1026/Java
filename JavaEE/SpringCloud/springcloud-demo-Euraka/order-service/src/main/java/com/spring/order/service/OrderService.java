package com.spring.order.service;


import com.spring.order.mapper.OrderMapper;
import com.spring.order.model.OrderInfo;
import com.spring.order.model.ProductInfo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private List<ServiceInstance> instances;

    @PostConstruct
    public void init(){
        //从eureka获取服务列表
        instances = discoveryClient.getInstances("cloud-product");
    }


//    public OrderInfo selectOrderInfoById(Integer orderId) {
//        OrderInfo orderInfo = orderMapper.selectOrderInfoById(orderId);
////        String url="http://127.0.0.1:9090/product/selectProductInfoByProductId?productId="+orderInfo.getProductId();
//        //从eureka获取服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-product");
//        String uri = instances.get(0).getUri().toString();
//        log.info("uri:{}",uri);
//        String url = uri + "/product/selectProductInfoByProductId?productId=" + orderInfo.getProductId();
//        log.info("url:{}",url);
//        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
//        orderInfo.setProductInfo(productInfo);
//        return orderInfo;
//    }


    /**
     * 实现手动负载均衡
     * @param orderId
     * @return
     */
//    //计数器
//    private AtomicInteger count = new AtomicInteger(1);
//    public OrderInfo selectOrderInfoById(Integer orderId) {
//        OrderInfo orderInfo = orderMapper.selectOrderInfoById(orderId);
////      String url="http://127.0.0.1:9090/product/selectProductInfoByProductId?productId="+orderInfo.getProductId();
//
//        // 对于count先取值再+1，用于计算轮流实例
//        int index = count.getAndIncrement()%instances.size();
//        String uri = instances.get(index).getUri().toString();
//
//        log.info("uri:{}",uri);
//        String url = uri + "/product/selectProductInfoByProductId?productId=" + orderInfo.getProductId();
//        log.info("url:{}",url);
//        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
//        orderInfo.setProductInfo(productInfo);
//        return orderInfo;
//    }

    /**
     * 使用LoadBalancer实现负载均衡
     * @param orderId
     * @return
     */
    public OrderInfo selectOrderInfoById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderInfoById(orderId);

        //把ip+port改为应用名称，例如这里的cloud-product
        String url="http://cloud-product/product/selectProductInfoByProductId?productId="+orderInfo.getProductId();

        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }

}
