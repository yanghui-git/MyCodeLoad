package com.yh.test;

import com.yh.test.util.ESUtil;
import com.yh.test.util.dao.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
/**
 * https://blog.csdn.net/JacksonKing/article/details/104513527?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control
 *
 * ElasticSearch demo
 */
public class EsIndexTest {

    @Autowired
    private ESUtil esUtil;

    /**
     * 测试创建索引
     * 查看索引结构
     */
    @Test
    public void addIndex() throws Exception {
        esUtil.createIndex("estest", "{\"mappings\":{\"properties\":{\"info\":{\"type\":\"text\",\"analyzer\":\"ik_smart\"},\"email\":{\"type\":\"keyword\",\"index\":false},\"name\":{\"type\":\"object\",\"properties\":{\"firstName\":{\"type\":\"keyword\"},\"lastName\":{\"type\":\"keyword\"}}}}}}");
        //判断是否存在此索引
        assertTrue(esUtil.isExistIndex("estest"));
    }

    /**
     * 查看索引
     */
    @Test
    public void getIndex() throws Exception {
        System.out.println("查看索引结构......." + esUtil.getIndices("estest"));
    }

    /**
     * 测试删除索引
     */
    @Test
    public void deleteIndex() throws Exception {
        esUtil.deleteIndex("estest");
        assertFalse(esUtil.isExistIndex("estest"));
    }

    @Test
    public void add2() throws Exception {
        for (int i = 10; i <= 20; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setEmail(i + "@163.com");
            student.setInfo("神州租车");
            student.setPlace("杭州" );
            esUtil.addDocument("estest", student);
        }
    }

    @Test
    public void get() throws Exception {
        esUtil.getDocument("estest",  "QqJOqpABYwRckKe6azYf");
    }

    @Test
    public void delete() throws Exception {
        esUtil.deleteDocument("demohaha", "1");
    }

    @Test
    public void update() throws Exception {
//        System.out.println("更新前：    ");
//        esUtil.getDocument("demohaha", "_doc", "rLQ3OngBEkkMZmzxnufH");
//        esUtil.upDateDocument("demohaha", "_doc", "rLQ3OngBEkkMZmzxnufH",
//                new Student("更新测试", 100, ""));
//        System.out.println("更新后： ");
//        esUtil.getDocument("demohaha", "_doc", "rLQ3OngBEkkMZmzxnufH");
    }


}
