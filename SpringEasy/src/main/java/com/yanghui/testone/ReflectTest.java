package com.yanghui.testone;

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
        reflectStudentTest reflectStudentTest = new reflectStudentTest("yh", 2);
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
    public void reflectTestTwo(){
        reflectStudentTest reflectStudentTest =new reflectStudentTest("yhh",22);
        System.out.println(reflectStudentTest.getName());
      //  com.yanghui.testone.reflectStudentTest.speak();
        //获取私有方法
        Method[] methods =reflectStudentTest.getClass().getDeclaredMethods();
        for(Method method:methods){
            method.setAccessible(true);
            try {
                if(method.getName().equals("Speak")) {
                    method.invoke(reflectStudentTest,"yh","22");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }


    public static void threePoint(String...strings){
         for(String s:strings){
             System.out.println(s);
         }
    }

    @Test
    public void threeTets(){
        threePoint("yh","yyyy");
    }

}
