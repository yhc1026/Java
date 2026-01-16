package com.spring.blogsystem.controller;


import com.spring.blogsystem.pojo.request.AddBlogRequest;
import com.spring.blogsystem.pojo.request.UpdateBlogRequest;
import com.spring.blogsystem.pojo.response.BlogInfoResponse;
import com.spring.blogsystem.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/getlist")
    public List<BlogInfoResponse> getList(){
        return blogService.getList();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogById(int blogId){
        return blogService.getBlogById(blogId);
    }

    @RequestMapping("/addBlog")
    public boolean add(@RequestBody AddBlogRequest addBlogRequest){
        return blogService.addBlog(addBlogRequest);
    }

    @RequestMapping("/updateBlog")
    public boolean updateBlog(@RequestBody UpdateBlogRequest updateBlogRequest){
        return blogService.updateBlog(updateBlogRequest);
    }

    @RequestMapping("/deleteBlog")
    public boolean deleteBlog(int blogId){
        return blogService.deleteBlogById(blogId);
    }
}
