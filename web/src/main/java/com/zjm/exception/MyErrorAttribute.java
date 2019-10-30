package com.zjm.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义Error数据
 * 对返回的数据进行自定义
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> errorAttributes=super.getErrorAttributes(webRequest,includeStackTrace); //获取springboot默认提供的错误信息
        errorAttributes.put("custommsg","出错啦！"); //添加自定义Error信息
        errorAttributes.remove("error");   //移除默认的Error信息
        return errorAttributes;
    }
}
