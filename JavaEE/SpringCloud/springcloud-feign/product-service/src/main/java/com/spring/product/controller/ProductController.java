package com.spring.product.controller;



import com.spring.ProductInterface;
import com.spring.model.ProductInfo;
import com.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController implements ProductInterface {

    @Autowired
    private ProductService productService;

    @RequestMapping("/selectProductInfoByProductId")
    public ProductInfo selectProductInfoByProductId(@RequestParam("productId")Integer productId) {
        return productService.selectProductInfoById(productId);
    }

    @RequestMapping("/p1")
    public String p1(Integer id){
        return ("id: "+id);
    }

    @RequestMapping("/p2")
    public String p2(Integer id,String name){
        return ("id: "+id+" name: "+name);
    }

    @RequestMapping("/p3")
    public  String p3(ProductInfo productInfo){
        return "productInfo: "+productInfo.toString();
    }

    @RequestMapping("/p4")
    public String p4(@RequestBody ProductInfo productInfo){
        return "productInfo:"+productInfo.toString();
    }
}
