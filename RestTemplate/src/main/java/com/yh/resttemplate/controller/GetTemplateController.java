package com.yh.resttemplate.controller;

import com.yh.resttemplate.dao.RestTemplateDao;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/test")
public class GetTemplateController {

    @RequestMapping(method = RequestMethod.GET, value = "/one")
    public void one() {
        System.out.println("one");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/two/{name}")
    public void two(@PathVariable(value = "name") String name) {
        System.out.println(name + System.currentTimeMillis());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/three")
    public void three(@RequestParam(value = "name") String name) {
        System.out.println(name + System.currentTimeMillis());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/four")
    public RestTemplateDao four(@RequestParam(value = "name", required = true) String name) {
        return new RestTemplateDao("success", 200, name);
    }
}
