package com.yh.resttemplate.test;

import com.yh.resttemplate.dao.RestTemplateDao;
import com.yh.resttemplate.util.RestTemplateUtil;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RestTemplateUtilTest {

    @Test
    public void one() {
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/one", Object.class);
    }

    @Test
    public void two() {
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/two/{name}", Object.class, "test");
    }

    @Test
    public void three() {
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("name", "testName");
        //testMap.put("age", 20);
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/two/{name}", Object.class, testMap);
    }

    @Test
    public void four() {
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("name", "testRequestParams");
        //testMap.put("age", 20);
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/three?name={name}", Object.class, testMap);
    }

    @Test
    public void five() {
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("name", "testRequestParams");
        //testMap.put("age", 20);
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/four?name={name}", Object.class, testMap);
        RestTemplateUtil.get("http://127.0.0.1:8080/rest/test/four?name={name}", RestTemplateDao.class, testMap);
    }


    @Test
    public void six() {
        // POST 传参
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", 22);
        RestTemplateDao restTemplateDao = (RestTemplateDao) new RestTemplate().postForObject("http://127.0.0.1:8080/rest/test/post/one", hashMap, RestTemplateDao.class);
        System.out.println(restTemplateDao);
        //  RestTemplateUtil.post("http://127.0.0.1:8080/rest/test/post/one", multiValueMap, Object.class);
    }


}
