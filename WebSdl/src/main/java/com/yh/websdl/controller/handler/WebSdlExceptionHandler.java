package com.yh.websdl.controller.handler;

import cn.com.dbappsecurity.sdl.annotations.UnSafeArg;
import cn.com.dbappsecurity.sdl.exceptions.SDLException;
import cn.com.dbappsecurity.sdl.exceptions.UnSafeArgsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class WebSdlExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public Object handlerOne(RuntimeException e) {
        //  System.out.println("异常处理方法--one------");
        //     System.out.println(e.getMessage());
        return "参数校验失败---" + e.getMessage();
    }

    @ExceptionHandler(value = SDLException.class)
    public Object handlerOne(SDLException e) {
        //  System.out.println("异常处理方法--one------");
        //     System.out.println(e.getMessage());
        return "websdl error :-------" + e.getMsg();
    }
}
