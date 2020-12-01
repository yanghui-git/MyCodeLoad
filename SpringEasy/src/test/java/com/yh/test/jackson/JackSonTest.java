package com.yh.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JackSonTest {

    @Test
    public void testOne() throws Exception {
        Map jsonNodes = new HashMap();
        jsonNodes.put("name", "test");
        jsonNodes.put("age", 22);
        jsonNodes.put("mm", true);
        String json = new ObjectMapper().writeValueAsString(jsonNodes);
        System.out.println(json);
        ObjectNode objectNode = new ObjectMapper().readValue(json, ObjectNode.class);
        System.out.println(objectNode.toString());
        System.out.println(objectNode.path("name"));
        System.out.println(objectNode.path("mmm").isMissingNode());
    }

    @Test
    public void testTwo() {
        //输出一次
        do {
            System.out.println("666666");
        } while (1 > 2);

        System.out.println("------------------------");

        boolean ss = 1 > 2;
        while (ss) {
            System.out.println("7777777");
        }
    }
}
