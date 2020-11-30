package com.yh.resttemplate.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 不带参数的get
     *
     * @param url
     * @param T
     * @param <T>
     */
    public static <T> void get(String url, Class<T> T) {
        T t = restTemplate.getForObject(url, T);
        System.out.println(JSON.toJSONString(t));
    }

    /**
     * 带参数的get
     *
     * @param url
     * @param T
     * @param <T>
     */
    public static <T> void get(String url, Class<T> T, String... params) {
        T t = restTemplate.getForObject(url, T, params);
        System.out.println(JSON.toJSONString(t));
    }

    /**
     * 带参数的get
     *
     * @param url
     * @param T
     * @param <T>
     * @PathVarible
     */
    public static <T> void get(String url, Class<T> T, Map<String, Object> params) {
        T t = restTemplate.getForObject(url, T, params);
        System.out.println(JSON.toJSONString(t));
    }

    /**
     * post
     */
    public static <T> void post(String url, Object object, Class<T> T) {
        T t = restTemplate.postForObject(url, object, T);
        System.out.println(JSON.toJSONString(t));
    }


}
