package com.spring.product.controller;


import com.spring.product.model.ProductInfo;
import com.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/selectProductInfoByProductId")
    public ProductInfo selectProductInfoByProductId(Integer productId) {
        return productService.selectProductInfoById(productId);
    }

}
