package com.yh.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Java1.8 Optional
 * https://www.cnblogs.com/zhangboyu/p/7580262.html
 */
public class OptionalTest {
    public static void main(String[] args) {
        StudentOption studentOption = new StudentOption(20, null);
        String test = Optional.ofNullable(studentOption.getName()).orElse("111");
        test = Optional.ofNullable(test).orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "222";
            }
        });

        System.out.println(test.toString());


        studentOption = null;
        studentOption = Optional.ofNullable(studentOption).orElse(new StudentOption());
        test = Optional.ofNullable(studentOption.getName()).orElse("3");
        System.out.println(test);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class StudentOption {
        int age;
        String name;
    }
}
