package com.yh.websdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * WebSdl 调研
 */
@SpringBootApplication
@ComponentScan(value = {"cn.com.dbappsecurity.sdl.interceptors", "com.yh.websdl"})
public class WebSdlMain {
    public static void main(String[] args) {
        SpringApplication.run(WebSdlMain.class);
    }


}
