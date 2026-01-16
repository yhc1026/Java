package com.spring.product.service;


import com.spring.model.ProductInfo;
import com.spring.product.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public ProductInfo selectProductInfoById(Integer productId) {
        return productMapper.selectProductInfoById(productId);
    }

}
