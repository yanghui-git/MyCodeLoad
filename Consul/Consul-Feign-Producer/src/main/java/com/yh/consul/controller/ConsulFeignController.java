package com.yh.consul.controller;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/produce/list")
    public List<Student> test3() {
        return new ArrayList<>();
    }

}
