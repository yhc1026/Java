package com.spring.bookmanage.mapper;


import com.spring.bookmanage.entity.BookInfo;
import com.spring.bookmanage.entity.PageRequest;
import com.spring.bookmanage.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookInfoMapper {

    @Insert("insert into book_info(book_name, author, count, price, publish) values(#{bookName}, #{author}, #{count}, #{price}, #{publish})")
    Integer addBook(BookInfo bookInfo);

    @Select("select * from book_info where status!=0 limit #{offset},#{pageSize}")
    List<BookInfo> getListByPage(PageRequest pageRequest);

    @Select("select count(1) from book_info where status!=0")
    Integer count();

    @Select("select * from book_info where id=#{id}")
    BookInfo getBookById(String id);

    int updateBook(BookInfo bookInfo);

    int deleteBatchBook(List<Integer> ids);
}
