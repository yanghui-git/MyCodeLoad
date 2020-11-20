package com.yh.exception.handler;

import com.yh.exception.exception.ExceptionTestOne;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public void handlerOne(RuntimeException e) {
        System.out.println("异常处理方法--one------");
        System.out.println(e.getMessage());
    }


    @ExceptionHandler(value = ExceptionTestOne.class)
    public void handlerTwo(RuntimeException e) {
        System.out.println("自定义异常处理方法-666666------");
        System.out.println(e.getMessage());
    }


}
