package com.yh.test.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {


    @Async
    public void testOne() throws Exception {
        Thread.sleep(2000l);
        System.out.println("Async test 66666");
    }
}
