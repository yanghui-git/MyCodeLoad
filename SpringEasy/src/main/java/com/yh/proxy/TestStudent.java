package com.yh.proxy;

import com.yh.proxy.dynamic.CglibStudent;
import com.yh.proxy.dynamic.DynamicStudentService;
import com.yh.proxy.stati.StaticStudentService;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
        //配置系统属性为true,代理类生成时将自动写入磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //代理的真实对象
        StudentService studentService = new StudentServiceImpl();
        InvocationHandler invocationHandler = new DynamicStudentService(studentService);

        ClassLoader classLoader = studentService.getClass().getClassLoader();
        Class[] interfaces = studentService.getClass().getInterfaces();

        StudentService service = (StudentService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        //     service.add();
    }

    /**
     * https://blog.csdn.net/u013419838/article/details/93749164?ops_request_misc=%25257B%252522request%25255Fid%252522%25253A%252522161119232316780299079255%252522%25252C%252522scm%252522%25253A%25252220140713.130102334..%252522%25257D&request_id=161119232316780299079255&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-93749164.first_rank_v2_pc_rank_v29&utm_term=jdk%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90
     * 源码解析
     *
     * @param args
     */
    public static void main(String[] args) {
        //配置系统属性为true,代理类生成时将自动写入磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //代理的真实对象
        StudentService studentService = new StudentServiceImpl();
        InvocationHandler invocationHandler = new DynamicStudentService(studentService);

        ClassLoader classLoader = studentService.getClass().getClassLoader();
        Class[] interfaces = studentService.getClass().getInterfaces();

        StudentService service = (StudentService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        service.add();
        //  service.toString();
    }

    @Test
    public void cglib() throws Exception {
        // 设置输出代理类到指定路径，便于后面分析
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/hui.yang/IdeaProjects/MyCodeLoad2.0");
        CglibStudent cglib = new CglibStudent();
        StudentServiceImpl studentService = (StudentServiceImpl) cglib.getInstance(new StudentServiceImpl());
        studentService.add();
    }

    @Test
    public void reflect() throws Exception {
        Method method = Class.forName("com.yh.proxy.StudentService").getMethod("add");
        method.invoke(new StudentServiceImpl(), null);
        Class.forName("java.lang.Object").getMethod("toString").invoke(new StudentServiceImpl(), null);
    }
}
