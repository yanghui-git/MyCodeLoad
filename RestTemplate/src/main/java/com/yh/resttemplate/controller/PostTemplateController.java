package com.yh.resttemplate.controller;

import com.yh.resttemplate.dao.RestTemplateDao;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/test/post")
public class PostTemplateController {

    @RequestMapping(method = RequestMethod.POST, value = "/one")
    public RestTemplateDao one(@RequestBody RestTemplateDao restTemplateDao) {
        restTemplateDao.setContent(System.currentTimeMillis());
        return restTemplateDao;
    }

}
