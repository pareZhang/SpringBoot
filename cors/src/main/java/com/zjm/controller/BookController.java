package com.zjm.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 请求方法上配置跨域
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    //表示来自http://localhost:8081域的请求是支持跨域的，探测请求的有效期为1800秒，allowedHeaders表示允许的请求头，*表示所有请求头都被允许
    public String addBook(String name){
        return "receive:"+name;
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id){
        return String.valueOf(id);
    }
}
