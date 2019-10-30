package com.zjm.exception;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice是一个全局数据处理组件，因此也可以在@ControllerAdvice中配置全局数据
 * 使用@ModelAttribute注解进行配置
 * 添加全局数据
 */
@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute(value = "info")  //value属性表示这条返回数据的key，方法的返回值是返回数据的value
    public Map<String,String> userInfo(){
        HashMap<String,String> map=new HashMap<>();
        map.put("username","罗贯中");
        map.put("gender","男");
        return map;
    }

    /**
     * 请求参数预处理
     * @param binder
     */
    @InitBinder("a") //表示该方法时处理@ModleAttribute("a")中的对应的参数
    public void init(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }

    /**
     * 请求参数预处理
     * @param binder
     */
    @InitBinder("b") //表示该方法时处理@ModleAttribute("b")中的对应的参数
    public void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }
}
