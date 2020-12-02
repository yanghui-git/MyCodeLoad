package com.yh.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data  //get set
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
public class Student {

    String name;

    int age;

    List<String> MM;

}
