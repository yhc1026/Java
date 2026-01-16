package com.spring.bookmanage.service;

import com.spring.bookmanage.entity.BookInfo;
import com.spring.bookmanage.entity.PageRequest;
import com.spring.bookmanage.entity.ResponseResult;
import com.spring.bookmanage.enums.BookStatusEnum;
import com.spring.bookmanage.mapper.BookInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookService {

    @Autowired
    BookInfoMapper bookInfoMapper;


    public String addBook(BookInfo bookInfo){
        try {
            bookInfoMapper.addBook(bookInfo);
            return "";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest){
        Integer count= bookInfoMapper.count();
        log.info("print out page size and offset: "+pageRequest.getPageSize() + "," + pageRequest.getCurrentPage());
        List<BookInfo> bookList=bookInfoMapper.getListByPage(pageRequest);
        for (BookInfo bookInfo:bookList){
            bookInfo.setStatusCN(BookStatusEnum.getByCode(bookInfo.getStatus()).getDesc());
        }
        ResponseResult<BookInfo> responseResult=new ResponseResult<>();
        responseResult.setTotal(count);
        responseResult.setRecords(bookList);
        return responseResult;
    }

    public BookInfo getBookById(String id) {
        return bookInfoMapper.getBookById(id);
    }

    public int updateBook(BookInfo bookInfo) {
        return bookInfoMapper.updateBook(bookInfo);
    }

    public String deleteBatchBook(List<Integer> ids) {
        int i=bookInfoMapper.deleteBatchBook(ids);
        if(i>0){return "";}
        return "error";
    }
}
