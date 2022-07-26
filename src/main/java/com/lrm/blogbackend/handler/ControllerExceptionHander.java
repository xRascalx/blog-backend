package com.lrm.blogbackend.handler;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//可以攔截springboot controller的異常錯誤
@ControllerAdvice
public class ControllerExceptionHander {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //表示這個方法可以做異常處理(只要是Exception都可以處理)
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        //紀錄
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);

        //查找其他位置有無e和ResponseStatus，如果為null，則交給springboot本身控制器做導頁，而非給我們自定義的error
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }

        //返回錯誤頁面
        ModelAndView mv = new ModelAndView();
        //獲取URL
        mv.addObject("url",request.getRequestURL());
        //獲取異常訊息
        mv.addObject("exception",e);
        //返回到error頁面
        mv.setViewName("error/error");
        return mv;
    }
}
