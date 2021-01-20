package com.yh.proxy;

import com.yh.proxy.dynamic.DynamicStudentService;
import com.yh.proxy.stati.StaticStudentService;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试
 * 静态代理 https://www.zhihu.com/column/c_144466663
 */
public class TestStudent {

    /**
     * 静态代理测试
     */
    @Test
    public void staticTest() {
        StaticStudentService staticStudentService = new StaticStudentService(new StudentServiceImpl());
        staticStudentService.add();
        staticStudentService.delete();
    }

    /**
     * 动态代理
     */
    @Test
    public void dynamic() throws Exception {
        //代理的真实对象
        StudentService studentService = new StudentServiceImpl();
        InvocationHandler invocationHandler = new DynamicStudentService(studentService);

        ClassLoader classLoader = studentService.getClass().getClassLoader();
        Class[] interfaces = studentService.getClass().getInterfaces();

        StudentService service = (StudentService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        service.add();
    }
}
