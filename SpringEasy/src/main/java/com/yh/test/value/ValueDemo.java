package com.yh.test.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueDemo {

    /**
     * https://blog.csdn.net/zhangzehai2234/article/details/88564759
     * @Value 设备默认值
     */
    @Value("${test.name2:HaHa}")
    private String name;

    @Value("${test.age}")
    private int age;


    @Bean
    public StudentDemo getStudentDemo() {
        StudentDemo studentDemo = new StudentDemo();
        studentDemo.setAge(age);
        studentDemo.setName(name);
        System.out.println("name--   " + name + "   age--  " + age);
        return studentDemo;
    }
}
