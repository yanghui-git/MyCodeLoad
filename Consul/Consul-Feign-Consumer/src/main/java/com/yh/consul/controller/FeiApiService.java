package com.yh.consul.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@FeignClient("Consul-Feign-Producer")
public interface FeiApiService {

    @GetMapping("/produce")
    public String test();

    @GetMapping("/produce/sum")
    public String test2(@RequestParam int a, @RequestParam int b);

    @GetMapping("/produce/list")
    public List<StudentVo> test3();
}
