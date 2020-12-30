package com.yh.test.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigurationTest {

    @Autowired
    private ConfigurationDao configurationDao;

    @Test
    public void testOne() {
        System.out.println(configurationDao.toString());
    }
}
