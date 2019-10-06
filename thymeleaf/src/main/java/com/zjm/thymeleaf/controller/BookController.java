package com.zjm.thymeleaf.controller;

import com.zjm.thymeleaf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @RequestMapping("/book")
    public ModelAndView book(){
        ModelAndView mv=new ModelAndView();
        List<Book> bookList=new ArrayList<>();
        Book b1=new Book();
        b1.setId(1);
        b1.setName("三国");
        b1.setAuthor("罗贯中");
        Book b2=new Book();
        b2.setId(2);
        b2.setName("红楼梦");
        b2.setAuthor("曹雪芹");
        bookList.add(b1);
        bookList.add(b2);
        mv.addObject("bookList",bookList);
        mv.setViewName("books");
        return mv;
    }
}
