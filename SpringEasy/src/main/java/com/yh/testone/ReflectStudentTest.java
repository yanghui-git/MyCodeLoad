package com.yh.testone;

public class ReflectStudentTest {
    private String name;
    private int age;

    private String  Speak(String name,String age){
        System.out.println(name+age);
        return  name+age;
    }
    public ReflectStudentTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 反射调动 静态方法
     * @param name
     * @param age
     * @return
     */
    private static String SpeckStaticTest(String name,String age){
        System.out.println("this is static " + name+age);
        return  name+age;
    }

    public ReflectStudentTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
