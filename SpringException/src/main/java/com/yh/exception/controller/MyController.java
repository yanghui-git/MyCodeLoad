package com.yh.exception.controller;

import com.yh.exception.exception.ExceptionTestOne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class MyController {

    @GetMapping(value = "/one")
    public String methodOne() {
        throw new RuntimeException("自定义抛出异常 exception one");
        // return "method one";
    }

    @GetMapping(value = "/two")
    public void methodTwo() {
        System.out.println("method two");
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new ExceptionTestOne("自定义异常10/0");
        }
    }
}
