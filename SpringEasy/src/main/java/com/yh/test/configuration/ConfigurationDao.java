package com.yh.test.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "configuration")
@Component
@Data
public class ConfigurationDao {

    public String name;

    public int age;


    public boolean enable;

}
