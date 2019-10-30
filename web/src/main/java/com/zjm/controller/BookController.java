package com.zjm.controller;

import com.zjm.pojo.Author;
import com.zjm.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求参数预处理
 */
@RestController
public class BookController {
    @GetMapping("/book")
    public String book(@ModelAttribute("a") Book book, @ModelAttribute("b") Author author){
        return book.toString()+">>>>>"+author.toString();
    }
}
