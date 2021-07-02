package com.yh.test;

import com.yh.test.value.ValueDemo;
import com.yh.util.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringContextUtilTest {

    /**
     * 测试获取service
     */
    @Test
    public void test() {
        ValueDemo valueDemo = (ValueDemo) SpringContextUtil.getBean("valueDemo");
        System.out.println(valueDemo);
    }

    /**
     * 测试获取环境变量
     */
    @Test
    public void testTwo() {
        System.out.println(SpringContextUtil.getProperty("server.port", "100"));
        System.out.println(SpringContextUtil.getProperty("testttee", "随便测试"));
    }
}
