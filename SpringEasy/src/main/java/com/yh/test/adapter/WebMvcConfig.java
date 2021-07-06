package com.yh.test.adapter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://blog.csdn.net/zhangpower1993/article/details/89016503
 * WebMvcConfig 配置
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //启动注册拦截器到 配置中
        registry.addInterceptor(new MyAdapter());
    }
}
