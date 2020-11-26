package com.yanghui.testone;

public class reflectStudentTest {
    private String name;
    private int age;

    private String  Speak(String name,String age){
        System.out.println(name+age);
        return  name+age;
    }
    public reflectStudentTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public reflectStudentTest() {
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
