package com.zjm.component;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义error视图
 * 此时无论请求发生4xx的错误还是5xx的错误，都会去到errorPage.html页面
 * 如果只是单纯地想自定义Error数据，还是建议继承DefaultErrorAttributes
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model ) {
        //Map<String,Object> model参数就是spring boot提供的默认的5条Error信息（可以自定义error数据对5条消息进行修改）
        ModelAndView mv=new ModelAndView("errorPage");
        mv.addObject("custommsg","出错啦！");   //添加自定义Error数据
        mv.addAllObjects(model);
        return mv;
    }
}
