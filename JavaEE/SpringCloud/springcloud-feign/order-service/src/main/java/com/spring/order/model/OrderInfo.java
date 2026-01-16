package com.spring.order.model;

import com.spring.model.ProductInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.PrimitiveIterator;

@Data
public class OrderInfo {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer num;
    private Integer price;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    private ProductInfo productInfo;
}
