package com.yh.test.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * https://blog.wangqi.love/articles/Java/Spring%20Event%E4%BA%8B%E4%BB%B6%E9%80%9A%E7%9F%A5%E6%9C%BA%E5%88%B6.html
 * Spring event 事件机制demo
 */
public class EventDao extends ApplicationEvent {

    String name;

    int age;

    String address;

    public EventDao(Object source,String name,int age,String address) {
        super(source);
        this.name=name;
        this.age=age;
        this.address=address;
    }

    @Override
    public String toString() {
        return "EventDao{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
