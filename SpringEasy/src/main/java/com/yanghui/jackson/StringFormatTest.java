package com.yanghui.jackson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

public class StringFormatTest {


    /**
     * String.format()
     */
    @Test
    public void testTwo(){
        String str=null;
        str=String.format("hi,这是测试人 %s %s%s","yh","yh","yyhhhh");
        System.out.println(str);
        str=String.format("boolean测试%b",1==2);
        System.out.println(str);
        str=String.format("整数 %d",12);
        System.out.println(str);
        //四舍五入
        str=String.format("浮点型 %.4f",12.99612);
        System.out.println(str);
        Date date=new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);

    }

    @Test
    public void testttssth() {
        String json ="\"{\"requiredFields\":[\"field1\"]}\"";
        System.out.println(json);
        DataSetFilter dataSetFilter =SerializeUtil.decodeJson(json,DataSetFilter.class);

    }

    @Test
    public void testttssthL() {
        String json ="\\\"1";
        System.out.println(json);
        System.out.println("\\\"");
        System.out.println(json.contains("\\\""));
        System.out.println(json.replaceAll("\\\\\\\"","\\\""));
        Map map =new HashMap();
        map.put("1","22222");
        map.put("2","444");
        map.put("3",Collections.singletonList(1));
        System.out.println(SerializeUtil.encodeJson(map));
    }

    @Test
            public void oo(){
               StudentJson studentJson =new StudentJson();
               studentJson.setAge("20");
               studentJson.setName("test");
               studentJson.setListTest(Collections.singletonList("2222"));
               System.out.println(SerializeUtil.encodeJson(studentJson));
    }

}
