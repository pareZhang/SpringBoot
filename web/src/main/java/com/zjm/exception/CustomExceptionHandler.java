package com.zjm.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;


/**
 * 全局异常处理
 */
@ControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
////    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response)throws IOException{
////        response.setContentType("text/html;charset=utf-8");
////        PrintWriter out=response.getWriter();
////        out.write("上传文件大小超出限制！");
////        out.flush();
////        out.close();
////    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e)throws IOException{
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","上传文件大小超出限制！");
        mv.setViewName("error");
        return mv;
    }
}
