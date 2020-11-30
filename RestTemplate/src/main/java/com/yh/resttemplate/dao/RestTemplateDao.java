package com.yh.resttemplate.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateDao {

    private Object content;

    private int code;

    private String meg;
}
