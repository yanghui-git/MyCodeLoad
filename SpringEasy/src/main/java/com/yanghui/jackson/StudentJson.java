package com.yanghui.jackson;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class StudentJson {

    String name;

    String age;

    List<String> listTest;


    @Override
    public String toString() {
        return "StudentJson{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", listTest=" + listTest +
                '}';
    }

    @Test
    public void testJson() {
        StudentJson studentJson = new StudentJson();
        studentJson.setAge("22");
        studentJson.setName("yyhh");
        List<String> test = new ArrayList<>();
        test.add("111");
        test.add("222");
        studentJson.setListTest(test);
        //转json
        String jsonOne = SerializeUtil.encodeJson(studentJson);
        System.out.println(jsonOne);
        //json转对象
        StudentJson studentJsonTwo = SerializeUtil.decodeJson(jsonOne, StudentJson.class);
        System.out.println(studentJsonTwo.age);
        System.out.println(studentJsonTwo.name);
        System.out.println(JSON.toJSONString(studentJson.listTest));
    }

    @Test
    public void testJsonTwo() {
        Map<Object, Object> testMap = new HashMap<>();
        testMap.put("name", "yh");
        testMap.put("age", 200);
        List<String> test = new ArrayList<>();
        test.add("111");
        test.add("222");
        testMap.put("list", test);
        //Map 转json
        String jsonOne = SerializeUtil.encodeJson(testMap);
        System.out.println(jsonOne);
        // json转map
        Map<Object, Object> mapTwo = SerializeUtil.decodeJson(jsonOne, Map.class);
        System.out.println(mapTwo.get("name"));
    }
//
//    @Test
//    public void testJsonThree() {
//        List<StudentJson> studentJsonList = new ArrayList<>();
//        for (int i = 1; i < 4; i++) {
//            StudentJson studentJson = new StudentJson();
//            studentJson.setName("yy" + i);
//            studentJson.setAge("20" + i);
//            studentJson.setListTest(new ArrayList<>());
//            studentJsonList.add(studentJson);
//        }
//        //list 转json
//        String json = SerializeUtil.encodeJson(studentJsonList);
//        System.out.println(json);
//        //json转list
//        List<StudentJson> studentJsonListTwo = SerializeUtil.decodeJsonList(json, StudentJson.class);
//        System.out.println(studentJsonListTwo.toString());
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        System.out.println(SerializeUtil.encodeJson(studentJsonListTwo));
//        Object object = JSON.parse(SerializeUtil.encodeJson(studentJsonListTwo));
//
//        System.out.println(object);
//
//        //json转map
//        List<HashMap> testMap=SerializeUtil.decodeJsonList(json,HashMap.class);
//        System.out.println("testMap"+JSON.toJSONString(testMap));
//
//    }
//
//    @Test
//    public void ttt() {
//        Double ss = Double.valueOf("22.11");
//        Double ssss=Double.parseDouble("2.1122");
//        System.out.println(ss);
//        System.out.println(ssss);
//
//        System.out.println(String.format("get data from datasource failed ; urls %s %s ; errMessage %s ","11","22","3"));
//    }

    @Test
    public void testttt() {
        List<String> stt = new ArrayList<>();
        stt.add("111");
        stt.add("333");
        stt.add("55");
        Iterator iterator = stt.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(JSON.toJSONString("1"));
    }


    @Test
    public void testttsst() throws Exception {
        System.out.println("222");
        System.out.println("333");
        System.out.println(JSON.toJSONString(null));
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        System.out.println("333");
    }


    @Test
    public void testttssts() throws Exception {

        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");

        List<String> test1 = new ArrayList<>();
        test1.add("11");
        test1.add("2");
        test1.add("31");
        test1.add("4");
        test1.add("5");

        //集合取交集
        test1.retainAll(test);

        System.out.println(test1);


        System.out.println(Double.parseDouble("2.12"));
    }

    @Test
    public void nn() {
        String value="0000-00-00 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            value = sdf.format(sdf.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }
}
