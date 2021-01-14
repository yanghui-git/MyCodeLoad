package com.yh.test;

import com.sun.source.tree.AssertTree;
import com.yh.test.util.ESUtil;
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
}
