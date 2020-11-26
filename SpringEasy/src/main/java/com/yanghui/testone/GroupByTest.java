package com.yanghui.testone;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByTest {


    @Test
    public void testJson() {
        Teacher teacher = new Teacher();
        teacher.setApikey("11111");
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge("18");
        student.setName("yyhh");
        students.add(student);
        teacher.setStudents(students);
        System.out.println(JSON.parseObject(JSON.toJSONString(teacher)));
    }


    @Test
    public void compare() {
        String ss = null;
        System.out.println(ss.equals("66"));
    }


    /**
     * 返回重复个数
     */
    @Test
    public void getCommon() {
        Set<String> ss = new HashSet<>();
        ss.add("1");
        ss.add("22");
        ss.add("1");
        System.out.println(JSON.toJSONString(ss));
        List<String> stringList = new ArrayList<>();
        stringList.add("11");
        stringList.add("22");
        stringList.add("33");
        List<String> stringLis2 = new ArrayList<>();
        stringLis2.add("11");
        stringLis2.add("22");
        stringLis2.add("44");
        System.out.println(getCommonCount(stringLis2, stringList));
    }

    private static int getCommonCount(List<String> s1, List<String> s2) {
        int count = 0;
        if (s1.size() == 0 || s2.size() == 0) {
            return count;
        }
        for (String ss : s2) {
            if (s1.contains(ss)) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * 聚合
     */
//    @Test
//    public void groupTest() {
//        Student student1 = new Student("Cicso", "1.txt");
//        Student student2 = new Student("Cicso", "2.txt");
//        Student student3 = new Student("H3C", "h3c1");
//        Student student4 = new Student("H3C", "h3c2");
//        Student student5 = new Student("test", "tettt");
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
//        studentList.add(student4);
//        studentList.add(student5);
//
//        System.out.println("    gyh h".trim().length());
//
//        List<String> test = new ArrayList<>();
//        test = studentList.stream().map(testtt -> testtt.getName()).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(test));
//
//        Map<String, List<Student>> resultTwo = new HashMap<>();
//
//        resultTwo = studentList.stream().collect(Collectors.groupingBy(testttt -> {
//            return testttt.getName();
//        }));
//        Map<String, List<String>> re = new HashMap<>();
//
//        for (String key : resultTwo.keySet()) {
//            List<String> result = new ArrayList<>();
//            resultTwo.get(key).stream().forEach(ss ->
//                    result.add(ss.getAge())
//            );
//            re.put(key, result);
//        }
//        System.out.println("666"+JSON.toJSONString(re));
//        JSONObject jsonObject =new JSONObject();
//        jsonObject.put("errCode","200");
//        jsonObject.put("message","get data success");
//        jsonObject.put("data",resultTwo);
//        System.out.println(JSON.toJSONString(jsonObject));

//        System.out.println(JSON.toJSONString(resultTwo));
//
//        Map<String, List<String>> result = new HashMap<>();
//
//        for (Student student : studentList) {
//            result.put(student.getName(), new ArrayList<>());
//        }
//
//        for (String key : result.keySet()) {
//            List<String> ss = new ArrayList<>();
//            for (Student student : studentList) {
//                if (student.getName().equals(key)) {
//                    ss.add(student.getAge());
//                }
//            }
//            result.put(key, ss);
//        }
//
//        System.out.println(JSON.toJSONString(result));

   //}
}
