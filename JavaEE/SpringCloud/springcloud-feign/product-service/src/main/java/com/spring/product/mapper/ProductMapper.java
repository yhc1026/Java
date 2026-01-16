package com.spring.product.mapper;


import com.spring.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ProductMapper {

    @Select("select * from product_detail where id = #{productId}")
    ProductInfo selectProductInfoById(Integer productId);
}
