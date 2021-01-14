package com.yh.module;

public class ObserverImplOne implements Observer {
    public void update() {
        System.out.println("one 收到变更消息");
    }
}
