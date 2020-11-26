package com.yanghui.jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JacksonTestYh {

//    private ObjectMapper objectMapper = new ObjectMapper();

//    public ObjectMapper getObjectMapper() {
//        if (objectMapper == null) {
//            synchronized (JacksonTestYh.class) {
//                if (objectMapper == null) {
//                    objectMapper = new ObjectMapper();
//                }
//            }
//        }
//        return objectMapper;

    private MyObjectMapper objectMapper = new MyObjectMapper();

    public ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            synchronized (JacksonTestYh.class) {
                if (objectMapper == null) {
                    objectMapper = new MyObjectMapper();
                }
            }
        }
        return objectMapper;

    }

    //自定义解析配置
    class MyObjectMapper extends ObjectMapper {
        public MyObjectMapper() {
            //设置是否美化 即换行 /n 这种
         //   this.configure(SerializationFeature.INDENT_OUTPUT, true);
            this.configure(SerializationFeature.INDENT_OUTPUT, false);
        }
    }


    @Test
    public void test() throws Exception {
        Student student = new Student();
        student.setAge(20);
        student.setName("yh");
        student.setMM(Arrays.asList(new String[]{"1", "2", "3"}));
        //对象转json
        String jsonStr = getObjectMapper().writeValueAsString(student);
        System.out.println(jsonStr);
        //json转对象
        Student studentRe = getObjectMapper().readValue(jsonStr, Student.class);
        System.out.println(studentRe);
//        //File读取
//        Student studentRs2 =getObjectMapper().readValue(new File("D:\\桌面","1.txt"),Student.class);
//        System.out.println(studentRs2);
//        //FileInputStream读取
//        FileInputStream fileInputStream=new FileInputStream(new File("D:\\桌面","1.txt"));
//        Student studentRs3=getObjectMapper().readValue(fileInputStream,Student.class);
        //       System.out.println(studentRs3);
    }

    @Test
    public void test2() throws Exception {
        //json与数组
        Student[] students = new Student[]{new Student("yh1", 1, new ArrayList<>()), new Student("yh2", 2, new ArrayList<>())};
        String str = getObjectMapper().writeValueAsString(students);
        System.out.println(str);

        //str转数组
        Student[] test = getObjectMapper().readValue(str, Student[].class);
        System.out.println(JSON.toJSONString(test));

        //str 转list
        List<Student> studentList = getObjectMapper().readValue(str, new TypeReference<List<Student>>() {
        });
        System.out.println(JSON.toJSONString(studentList));

        List<Object> studentObj = getObjectMapper().readValue(str, new TypeReference<List<Object>>() {
        });
        System.out.println(JSON.toJSONString(studentObj));

    }


}
