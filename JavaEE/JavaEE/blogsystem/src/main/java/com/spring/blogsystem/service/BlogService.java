package com.spring.blogsystem.service;


import com.spring.blogsystem.mapper.BlogInfoMapper;
import com.spring.blogsystem.pojo.dataobject.BlogInfo;
import com.spring.blogsystem.pojo.request.AddBlogRequest;
import com.spring.blogsystem.pojo.request.UpdateBlogRequest;
import com.spring.blogsystem.pojo.response.BlogInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogById(int blogId);

    boolean addBlog(AddBlogRequest addBlogRequest);

    boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    boolean deleteBlogById(int id);
}
