package com.spring.bookmanage.mapper;


import com.spring.bookmanage.entity.BookInfo;
import com.spring.bookmanage.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.print.Book;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info where user_name=#{name}")
    UserInfo queryUserInfoByName(String name);

    @Insert("insert into book_info(id, book_name, author, count, price, publish, status, create_time, update_time) values(bookInfo)")
    String addBook(BookInfo bookInfo);
}
