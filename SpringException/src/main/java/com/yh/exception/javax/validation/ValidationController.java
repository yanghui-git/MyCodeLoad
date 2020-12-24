package com.yh.exception.javax.validation;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 验证validation-api的功能
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/one")
    public String testOne(@RequestBody @Valid ValidationEntity validationEntity) {
        return JSON.toJSONString(validationEntity);
    }

}
