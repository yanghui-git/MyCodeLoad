package com.yanghui.testone;

public class Student {
    public String name;
    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

}
