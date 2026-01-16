package com.spring.bookmanage.controller;

import com.spring.bookmanage.constant.Constants;
import com.spring.bookmanage.entity.*;
import com.spring.bookmanage.enums.BookStatusEnum;
import com.spring.bookmanage.enums.ResultCodeEnum;
import com.spring.bookmanage.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private  BookService bookService;

    @RequestMapping(value = "/addBook")
    public Result addBook(BookInfo bookInfo){
        log.info("add book"+bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())
                ||bookInfo.getCount()==null
                ||bookInfo.getPrice()==null
                ||!StringUtils.hasLength(bookInfo.getPublish())
                ||bookInfo.getStatus()==null
        ){
            log.error("bad parameter, "+bookInfo);
            return Result.fail("parameter error");
        }
        try {
            String i=bookService.addBook(bookInfo);
            System.out.println("\n"+i+"\n");
            return Result.success(i);
        }catch (Exception e){
            log.error("error,"+e);
            return Result.fail("fail: "+ e.getMessage());
        }
    }


    @RequestMapping("/getListByPage")
    public Result<ResponseResult<BookInfo>> getListByPage(PageRequest  pageRequest) {
        try{
            int i=1/0;
            ResponseResult<BookInfo> bookList = bookService.getListByPage(pageRequest);
            return Result.success(bookList);
        }catch (Exception e){
            return Result.fail("fail: "+ e.getMessage());
        }

    }

    @RequestMapping("/queryBookById")
    public BookInfo getBookById(String id){
        log.info("queryBookById: "+id);
        return bookService.getBookById(id);
    }

    @RequestMapping(value= "/updateBook")
    public Result updateBook(BookInfo bookInfo){
        log.info("updateBook: "+bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())
        ||bookInfo.getCount()==null
        ||bookInfo.getPrice()==null
        ||!StringUtils.hasLength(bookInfo.getPublish())
        ||bookInfo.getStatus()==null){
            log.error("bad parameter, "+bookInfo);
        }
        try {
            int i=bookService.updateBook(bookInfo);
            log.info("updateBook: "+i);
            if(i>0){
                return Result.success("");
            }else{
                return Result.fail("修改图书失败");
            }
        }catch (Exception e){
            log.error("error,"+e);
            return Result.fail("fail+ "+ e.getMessage());
        }
    }

    @RequestMapping(value="/deleteBook")
    public Result deleteBookById(int id){
        log.info("deleteBookById: "+id);
       try {
           BookInfo bookInfo = new BookInfo();
           bookInfo.setId(id);
           bookInfo.setStatus(BookStatusEnum.DELETE.getCode());
           log.info("book info: "+bookInfo);
           bookService.updateBook(bookInfo);
           return Result.success("");
       }catch (Exception e){
           log.error("error,"+e);
           return Result.fail("fail: "+e.getMessage());
       }
    }

    @RequestMapping(value="/deleteBatchBook")
    public Result deleteBatchBook(@RequestParam List<Integer> ids){
        log.info("deleteBatchBook: "+ids);
        try {
            return Result.success(bookService.deleteBatchBook(ids));
        }catch (Exception e){
            log.error("error,"+e);
            return Result.fail("fail: "+ e.getMessage());
        }

    }
}
