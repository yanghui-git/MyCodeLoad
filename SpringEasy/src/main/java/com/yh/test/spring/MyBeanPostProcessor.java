package com.yh.test.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MyBeanPostProcessor  {

    private String name;

    private Integer age;

}
