package com.spring.blogsystem.utils;

import com.spring.blogsystem.pojo.dataobject.BlogInfo;
import com.spring.blogsystem.pojo.dataobject.UserInfo;
import com.spring.blogsystem.pojo.request.AddBlogRequest;
import com.spring.blogsystem.pojo.request.UpdateBlogRequest;
import com.spring.blogsystem.pojo.response.BlogInfoResponse;
import com.spring.blogsystem.pojo.response.UserLoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class BeansTransUtils {

    /**
     * BlogInfo转换为BlogInfoResponse
     * @param blogInfo
     * @return
     */
    public BlogInfoResponse transBlog(BlogInfo blogInfo){
        if(blogInfo == null){
            return null;
        }
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,blogInfoResponse);
        return blogInfoResponse;
    }


    /**
     * UserInfo转换为UserLoginResponse
     * @param userInfo
     * @return
     */
    public UserLoginResponse transUser(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserLoginResponse userInfoResponse = new UserLoginResponse(null, null, null);
        BeanUtils.copyProperties(userInfo,userInfoResponse);
        return userInfoResponse;
    }

    /**
     * AddBlogRequest转换为BlogInfo
     * @param addBlogRequest
     * @return
     */
    public BlogInfo AddBlogRequestTrans(AddBlogRequest addBlogRequest){
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest, blogInfo);
        return blogInfo;
    }

    /**
     * UpdateBlogRequest转换为BlogInfo
     * @param updateBlogRequest
     * @return
     */
    public BlogInfo UpdateBlogRequestTrans(UpdateBlogRequest updateBlogRequest){
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest, blogInfo);
        return blogInfo;
    }
}
