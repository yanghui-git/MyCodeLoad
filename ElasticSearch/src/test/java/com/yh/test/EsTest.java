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
public class EsTest {

    @Autowired
    private ESUtil esUtil;

    @Test
    public void add() throws Exception {
        esUtil.createIndex("demohaha");
        //  esUtil.deleteIndex("demohaha");
        assertTrue(esUtil.isExistIndex("demohaha"));
    }

    @Test
    public void add2() throws Exception {
        for (int i = 0; i <= 12; i++) {
            Student student = new Student("test" + i, 20 + i, "num" + i);
            esUtil.addDocument("demohaha", student);
        }
    }

    @Test
    public void get() throws Exception {
        esUtil.getDocument("demohaha", "doc", "E_fJA3cBjyjiQxunntuf");
    }

    @Test
    public void delete() throws Exception {
        esUtil.deleteDocument("demohaha", "doc", "1");
    }

    @Test
    public void update() throws Exception {
        System.out.println("更新前：    ");
        esUtil.getDocument("demohaha", "doc", "GPfJA3cBjyjiQxunntv9");
        esUtil.upDateDocument("demohaha", "doc", "GPfJA3cBjyjiQxunntv9",
                new Student("更新测试", 100, ""));
        System.out.println("更新后： ");
        esUtil.getDocument("demohaha", "doc", "GPfJA3cBjyjiQxunntv9");
    }



}
