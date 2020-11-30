package com.yh.test.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void test() throws Exception {
        System.out.println("1111");
        asyncService.testOne();
        System.out.println("2222");
        System.in.read();
    }
}
