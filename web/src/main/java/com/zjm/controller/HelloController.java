package com.zjm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        int i=1/0; //测试500错误
        return "Hello World";
    }
    @GetMapping("/model")
    public void hello(Model model){
        Map<String,Object> map=model.asMap();
        Set<String> keySet=map.keySet();
        Iterator<String> iterator=keySet.iterator();
        while (iterator.hasNext()){
            String key=iterator.next();
            Object value=map.get(key);
            System.out.println(key+">>>>>"+value);
        }
    }
}
