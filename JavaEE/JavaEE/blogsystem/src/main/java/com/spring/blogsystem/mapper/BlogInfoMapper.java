package com.spring.blogsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.blogsystem.pojo.dataobject.BlogInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {
}
