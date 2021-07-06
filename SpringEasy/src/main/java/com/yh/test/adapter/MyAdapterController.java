package com.yh.test.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器 探究 spring-mvc
 * 日志记录 权限检查
 */
@RestController
@RequestMapping("/adaptor")
public class MyAdapterController {

    @GetMapping("/one")
    public Object one() {
        System.out.println("one......");
        return "one";
    }
}
