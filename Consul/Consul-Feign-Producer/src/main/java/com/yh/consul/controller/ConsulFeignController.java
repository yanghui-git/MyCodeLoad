package com.yh.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulFeignController {

    @GetMapping("/produce")
    public String test() {
        return "this is produce";
    }

    @GetMapping("/produce/sum")
    public int test2(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

}
