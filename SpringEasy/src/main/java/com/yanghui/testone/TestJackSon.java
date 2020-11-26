package com.yanghui.testone;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;


public class TestJackSon {
    public String error;
    public String name;
    public String age;
    public List<TestJackSon> tests;

    public TestJackSon() {
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public List<TestJackSon> getTests() {
        return tests;
    }

    public void setTests(List<TestJackSon> tests) {
        this.tests = tests;
    }

    public static void main(String[] args) {
        List<TestJackSon> tests = new ArrayList<>();
        TestJackSon t1 = new TestJackSon();
        t1.setName("yh");
        t1.setAge("20");
        TestJackSon t2 = new TestJackSon();
        t2.setName("yh2");
        t2.setAge("202");
        tests.add(t1);
        tests.add(t2);

        TestJackSon testJackSon = new TestJackSon();
        testJackSon.setAge("testAge");
        testJackSon.setName("testName");
        testJackSon.setTests(tests);

        System.out.println(JSON.toJSONString(testJackSon));


    }


}