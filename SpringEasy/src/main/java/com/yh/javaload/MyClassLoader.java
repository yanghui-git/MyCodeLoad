package com.yh.javaload;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.nio.file.Files;

/**
 * 自定义类加载器   https://www.cnblogs.com/guoyansi19900907/p/12566101.html
 */
public class MyClassLoader extends ClassLoader {

    /**
     *  Note： loadClass()也能被重写，但是我们不建议这样做，否则所有的类都会走这个方法来加载类；
     *  那么虚拟机内置的一些类也会用这个方法里面的逻辑来加载，然后报错
     */
    @Override
    protected Class<?> findClass(String name) {
        Class clazz = null;
        System.out.println("开始执行自定义类加载器");
        try {
            // 读取class 字节码
            byte[] classDate = Files.readAllBytes(new File("/Users/hui.yang/Desktop/StudentLoad.class").toPath());
            //将class的字节码数组转换成class类的实例
            clazz = defineClass(name, classDate, 0, classDate.length);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("结束自定义类加载器.......");
        return clazz;
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class clazz = myClassLoader.loadClass("com.yh.javaload.StudentLoad");
            System.out.println(clazz.getClassLoader());
            System.out.println(JSON.toJSONString(clazz.getMethods()));

            //校验判断是否类加载器相同 *****相同   同一类加载器加载的对象 true
            Class clazz2 = myClassLoader.loadClass("com.yh.javaload.StudentLoad");
            System.out.println(clazz == clazz2);

            Class clazz3 = new MyClassLoader().loadClass("com.yh.javaload.StudentLoad");
            System.out.println(clazz == clazz3);

            //报错 findClass 位置不对*******  未找到文件
            // Class clazz4 = ClassLoader.getSystemClassLoader().loadClass("com.yh.javaload.StudentLoad");
            // System.out.println(clazz == clazz4);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


