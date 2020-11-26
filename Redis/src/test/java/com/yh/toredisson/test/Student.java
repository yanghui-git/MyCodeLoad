package com.yh.toredisson.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {

    public String name;

    public int age;
}
