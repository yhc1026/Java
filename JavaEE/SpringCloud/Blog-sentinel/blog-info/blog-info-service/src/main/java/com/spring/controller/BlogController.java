package com.spring.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.spring.BlogServiceAPI;
import com.spring.pojo.AddBlogInfoRequest;
import com.spring.pojo.BlogInfoResponse;
import com.spring.pojo.Result;
import com.spring.pojo.UpBlogRequest;
import com.spring.service.BlogService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController implements BlogServiceAPI {

    @Autowired
    private BlogService blogService;


    /**
     * 加入了对于接口的安全保护，通过Sentinel注解+Sentinel控制台配置实现
     * 修改了BlogInfoResponse，添加了msg字段，可能会报错
     */
    @SentinelResource(value = "/blog/getList", blockHandler = "getListBlockHandler")
    @Override
    public Result<List<BlogInfoResponse>> getList(){
        return Result.success(blogService.getList());
    }
    public Result<List<BlogInfoResponse>> getListBlockHandler(BlockException e){
        log.info(" getListBlockHandler ");
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        blogInfoResponse.setMsg("数据库压力大，请稍后再试");
        return Result.success(blogInfoResponse);
    }


    @SentinelResource(value = "/blog/getBlogDetail", blockHandler = "getBlogDetailBlockHandler")
    @Override
    public Result<BlogInfoResponse> getBlogDeatail(@NotNull Integer blogId){
        log.info("getBlogDetail, blogId: {}", blogId);
        return Result.success(blogService.getBlogDeatil(blogId));
    }
    public Result<BlogInfoResponse> getBlogDetailBlockHandler(BlockException e){
        log.info(" getBlogDetailBlockHandler ");
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        blogInfoResponse.setMsg("数据库压力大，请稍后再试");
        return Result.success(blogInfoResponse);
    }

    @SentinelResource(value = "/blog/addBlog", blockHandler = "addBlogBlockHandler")
    @Override
    public Result<Boolean> addBlog(@Validated @RequestBody AddBlogInfoRequest addBlogInfoRequest){
        log.info("addBlog 接收参数: "+ addBlogInfoRequest);
        return Result.success(blogService.addBlog(addBlogInfoRequest));
    }
    public Result<Boolean> addBlogBlockHandler(BlockException e){
        log.info(" addBlogBlockHandler ");
        return Result.success(false);
    }


    @SentinelResource(value = "/blog/updateBlog", blockHandler = "updateBlogBlockHandler")
    @Override
    public Result<Boolean> updateBlog(@Valid @RequestBody UpBlogRequest upBlogRequest){
        log.info("updateBlog 接收参数: "+ upBlogRequest);
        return Result.success(blogService.update(upBlogRequest));
    }
    public  Result<Boolean> updateBlogBlockHandler(BlockException e){
        log.info(" updateBlogBlockHandler ");
        return Result.success(false);
    }


    @SentinelResource(value = "/blog/deleteBlog", blockHandler = "deleteBlogBlockHandler")
    @Override
    public Result<Boolean> deleteBlog(@NotNull Integer blogId){
        log.info("deleteBlog 接收参数: "+ blogId);
        return Result.success(blogService.delete(blogId));
    }
    public Result<Boolean> deleteBlogBlockHandler(BlockException e){
        log.info(" deleteBlogBlockHandler ");
        return Result.success(false);
    }
}
