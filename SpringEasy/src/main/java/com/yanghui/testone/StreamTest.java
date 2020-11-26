package com.yanghui.testone;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;


public class StreamTest {


    @Test
    public void comapreHash() {
        Student s1 = new Student("yh", "22", "158");
        Student s2 = new Student("yh", "22", "158");
        //  s2=s1;
        System.out.println(s2.equals(s2));
        System.out.println(Long.MAX_VALUE);
        System.out.println(System.getProperty("work.home"));
    }

//
//    @Test
//    public void lamadaTest(){
//        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
//        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
//        System.out.println(G7Countries);
//        List<String> ss =new ArrayList<>();
//        ss.add("11");
//        ss.add("22");
//        ss.add("11");
//        ss.add("33");
//        ss.stream().distinct().collect(Collectors.toList());
//        System.out.println( ss.stream().distinct().collect(Collectors.toList()));
//    }


//    @Test
//    public void streamTest() {
//        Student student1 = new Student("yh", "20", "158");
//        Student student2 = new Student("yh", "20", "156");
//        Student student3 = new Student("test", "22", "135");
//        Student student4 = new Student("test", "22", "136");
//        Student student5 = new Student("tt", "22", "134");
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
//        studentList.add(student4);
//        studentList.add(student5);
//        List<String> test =new ArrayList<>();
//        //将所有name放入新集合
//        test=studentList.stream().map(testtt->testtt.getName()).collect(Collectors.toList());
//        //去重
//        test=studentList.stream().map(ttt->ttt.getAge()).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(test));
//        Map<String, List<Student>> resultMap = new HashMap<>();
//        //分组聚合组装成map
//        resultMap = studentList.stream().collect(Collectors.groupingBy(Student::getName));
//        for (Map.Entry<String, List<Student>> hostEntry : resultMap.entrySet()) {
//            System.out.println(JSON.toJSONString(hostEntry));
//        }
//        // System.out.println(JSON.toJSONString(mapss));
//         studentList.stream().sorted(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//               return o1.num.compareTo(o2.num);
//            }
//        });
//        System.out.println(JSON.toJSONString(studentList));
//    }


    private class Student {
        private String name;
        private String age;
        private String num;


        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getNum() {
            return num;
        }

        public Student(String name, String age, String num) {
            this.name = name;
            this.age = age;
            this.num = num;
        }
    }
}
