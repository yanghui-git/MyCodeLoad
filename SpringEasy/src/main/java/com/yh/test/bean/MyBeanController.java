package com.yh.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class MyBeanController {

    @Autowired
    private MyBean myBean;

    @GetMapping("/one")
    public Object testOne() {
        System.out.println(myBean.toString());
        return myBean.toString();
    }
}
