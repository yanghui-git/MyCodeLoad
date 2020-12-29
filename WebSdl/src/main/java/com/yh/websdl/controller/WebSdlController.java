package com.yh.websdl.controller;

import cn.com.dbappsecurity.sdl.annotations.SafeID;
import cn.com.dbappsecurity.sdl.annotations.SafeIP;
import cn.com.dbappsecurity.sdl.annotations.SafeMail;
import cn.com.dbappsecurity.sdl.annotations.SafeUploadFile;
import cn.com.dbappsecurity.sdl.exceptions.SDLException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;

@RestController
@RequestMapping("/websdl/test")
public class WebSdlController {

    @GetMapping(value = "/one")
    public String methodOne() {
        throw new RuntimeException("自定义抛出异常 exception one");
    }

    @GetMapping(value = "/one2")
    public String methodOne2() {
        try {
            throw new RuntimeException("自定义抛出异常 exception one");
        } catch (Exception e) {
        }
        try {
            throw new SDLException("niubi");
        } catch (SDLException e) {
            throw new RuntimeException("自定义抛出异常 exception two");
        }
    }

    /**
     * 测试ip
     */
    @GetMapping(value = "/two")
    public String methodTwo(@SafeIP @RequestParam("ip") String ip) {
        System.out.println("验证ip" + ip);
        return ip;
    }

    /**
     * 测试整数类型参数
     */
    @GetMapping(value = "/three")
    public String methodThree(@SafeID @RequestParam("id") String id) {
        System.out.println("验证整数类型" + id);
        return id;
    }

    /**
     * 测试文件后缀   allowed表示上传那些 后缀名
     */
    @PostMapping(value = "/four")
    public String methodFour(@SafeUploadFile(allowedExt = "demo12345") @RequestParam MultipartFile multipartFile) {
        return "验证file 后缀名" + multipartFile.getOriginalFilename();
    }


    /**
     * not null 测试
     */
    @GetMapping(value = "/five")
    public String methodFive( @RequestParam(value = "name",defaultValue = "11") Integer name) {
        int a=name+2;
        return "验证name :    " + a;
    }


    /**
     * 校验邮箱
     */
    @GetMapping(value = "/six")
    public String methodSix(@SafeMail @RequestParam(value = "email") String email) {
        return "验证邮箱 :    " + email;
    }
}
