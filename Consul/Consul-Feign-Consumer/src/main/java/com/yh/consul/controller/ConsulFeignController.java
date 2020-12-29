package com.yh.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulFeignController {

    @Autowired
    private FeiApiService feiApiService;

    @GetMapping("/consumer")
    public String test() {
        return "this is consumer";
    }

    @GetMapping("/consumer/feign")
    public String test2() {
        return feiApiService.test();
    }

    @GetMapping("/consumer/feign/sum")
    public String test23(@RequestParam int a, @RequestParam int b) {
        return feiApiService.test2(a, b);
    }
}
