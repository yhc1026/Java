package com.spring.blogsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.blogsystem.common.exception.BlogException;
import com.spring.blogsystem.mapper.BlogInfoMapper;
import com.spring.blogsystem.pojo.dataobject.BlogInfo;
import com.spring.blogsystem.pojo.request.AddBlogRequest;
import com.spring.blogsystem.pojo.request.UpdateBlogRequest;
import com.spring.blogsystem.pojo.response.BlogInfoResponse;
import com.spring.blogsystem.service.BlogService;
import com.spring.blogsystem.utils.BeansTransUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    /**
     * 博客删除标识，1代表删除，0代表没删除
     */
    private static final Integer BLOG_DELETE=1;
    private static final Integer BLOG_NOT_DELETE=0;


    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private BeansTransUtils beansTransUtils;


    @Override
    public List<BlogInfoResponse> getList() {

        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0);
        List<BlogInfo> list = blogInfoMapper.selectList(queryWrapper);

        List<BlogInfoResponse> blogInfoResponse = list.stream().map(blogInfo->{
            BlogInfoResponse response = beansTransUtils.transBlog(blogInfo);
            return response;
        }).collect(Collectors.toList());

        return blogInfoResponse;
    }

    @Override
    public BlogInfoResponse getBlogById(int id) {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, 0).eq(BlogInfo::getId, id);
        BlogInfo blogInfo = blogInfoMapper.selectOne(queryWrapper);

        BlogInfoResponse blogInfoResponse = beansTransUtils.transBlog(blogInfo);
        return blogInfoResponse;
    }

    @Override
    public boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo = beansTransUtils.AddBlogRequestTrans(addBlogRequest);
        Integer cnt = blogInfoMapper.insert(blogInfo);
        if(cnt==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        BlogInfo blogInfo1 = blogInfoMapper.selectById(updateBlogRequest.getId());
        if(blogInfo1==null){
            log.info("要修改的博客不存在");
            throw new BlogException(-1, "要修改的博客不存在");
        }
        if(blogInfo1.getDeleteFlag()==BLOG_DELETE){
            log.info("该博客已删除，请勿重复操作");
            throw new BlogException(-1, "该博客已删除，请勿重复操作");
        }
        BlogInfo blogInfo = beansTransUtils.UpdateBlogRequestTrans(updateBlogRequest);
        int cnt = blogInfoMapper.updateById(blogInfo);
        if(cnt==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBlogById(int id) {
        BlogInfo blogInfo1 = blogInfoMapper.selectById(id);
        if(blogInfo1==null){
            log.info("要删除的博客不存在");
            throw new BlogException(-1, "要删除的博客不存在");
            //return false;
        }

        if (blogInfo1.getDeleteFlag()==BLOG_DELETE){
            log.info("该博客已删除，请勿重复操作");
            throw new BlogException(-1, "该博客已删除，请勿重复操作");
            //return false;
        }

        if(blogInfo1.getDeleteFlag()==BLOG_NOT_DELETE){
            BlogInfo blogInfo = new BlogInfo();
            blogInfo.setId(id);
            blogInfo.setDeleteFlag(BLOG_DELETE);
            int cnt = blogInfoMapper.updateById(blogInfo);
            if (cnt == 1) {
                return true;
            }
        }
        log.info("删除博客失败");
        return false;
    }

}
