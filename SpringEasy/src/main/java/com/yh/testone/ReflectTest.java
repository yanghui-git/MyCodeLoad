package com.yh.testone;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射测试
 */
public class ReflectTest {

    @Test
    public void reflectTest() throws IllegalAccessException {
        ReflectStudentTest reflectStudentTest = new ReflectStudentTest("yh", 2);
        Class reflectClass = reflectStudentTest.getClass();
//获取所有参数
        Field[] resFields = reflectClass.getDeclaredFields();
        for (Field field : resFields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            System.out.println(field.get(reflectStudentTest));
        }
    }

    /**
     * 获取私有方法
     */
    @Test
    public void reflectTestTwo() {
        ReflectStudentTest reflectStudentTest = new ReflectStudentTest("yhh", 22);
        // System.out.println(reflectStudentTest.getName());
        //  com.yanghui.testone.reflectStudentTest.speak();
        //获取私有方法
        Method[] methods = reflectStudentTest.getClass().getDeclaredMethods();
        for (Method method : methods) {
            // 设置访问属性
            method.setAccessible(true);
            try {
                if (method.getName().equals("Speak")) {
                    method.invoke(reflectStudentTest, "yh", "1");
                    method.invoke(null, "yh", "2");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //
            try {
                // 反射调用 静态方法
                if (method.getName().equals("SpeckStaticTest")) {
                    method.invoke(reflectStudentTest, "yh", "3");
                    //<p>If the underlying method is static, then the specified {@code obj}
                    //     * argument is ignored. It may be null.
                    method.invoke(null, "yh", "4");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void threePoint(String... strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void threeTets() {
        threePoint("yh", "yyyy");
    }

}
