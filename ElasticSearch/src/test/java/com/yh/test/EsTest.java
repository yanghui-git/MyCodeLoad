package com.yh.test;

import com.yh.test.util.ESUtil;
import com.yh.test.util.dao.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
/**
 * https://blog.csdn.net/JacksonKing/article/details/104513527?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control
 *
 * ElasticSearch demo
 */
public class EsTest {

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

    /**
     * 插入文档/行数据
     */
    @Test
    public void add2() throws Exception {
        for (int i = 0; i <= 12; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setEmail(i + "@163.com");
            student.setInfo("哈哈哈哈测试es索引");
            student.setPlace("上海哦" + i);
            esUtil.addDocument("estest", student, String.valueOf(System.currentTimeMillis()));
        }
    }

    /**
     * 获取文档/行数据
     */
    @Test
    public void get() throws Exception {
        esUtil.getDocument("estest", "1719905556996");
    }

    /**
     * 演示全量更新，全量更新其实就是新增，有原数据则es先删除原数据再新增，无原数据则直接新增
     */
    @Test
    public void updateAll() throws Exception {
        Student student = new Student();
        student.setAge(1);
        student.setEmail(1 + "@163.com");
        student.setInfo("哈哈哈哈测试es索引");
        student.setPlace("上海哦" + 1);
        //先插入一条数据
        esUtil.addDocument("estest", student, "12345");
        esUtil.getDocument("estest", "12345");
        //再试试全量直接更新，其实就是新增
        student.setInfo("我在演示全量更新");
        esUtil.addDocument("estest", student, "12345");
        esUtil.getDocument("estest", "12345");
    }

    /**
     * 演示局部更新，只更新一部分字段
     */
    @Test
    public void updateLittle() throws Exception {
        Student student = new Student();
        student.setAge(1);
        student.setEmail(1 + "@163.com");
        student.setInfo("哈哈哈哈测试es索引");
        student.setPlace("上海哦" + 1);
        //先插入一条数据
        esUtil.addDocument("estest", student, "1555");
        esUtil.getDocument("estest", "1555");
        //再试试局部更新
        Map update = new HashMap() {
            {
                put("info", "演示更新部分字段");
                put("place", "杭州");
            }
        };
        esUtil.upDateDocument("estest", "1555", update);
        esUtil.getDocument("estest", "1555");
    }

    /**
     * 演示es删除
     */
    @Test
    public void delete() throws Exception {
        Student student = new Student();
        student.setAge(1);
        student.setEmail(1 + "@163.com");
        student.setInfo("哈哈哈哈测试es索引");
        student.setPlace("上海哦" + 1);
        //先插入一条数据
        esUtil.addDocument("estest", student, "188");
        esUtil.getDocument("estest", "188");

        // 演示多次删除 并不会返回错误结果 都是true
        esUtil.deleteDocument("estest", "188");
        esUtil.deleteDocument("estest", "188");
        esUtil.deleteDocument("estest", "188");

        esUtil.getDocument("estest", "188");
    }


}
