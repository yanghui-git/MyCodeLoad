package com.yh.toredisson.test;

import org.redisson.api.listener.MessageListener;

import java.util.Date;

public class MessageListenerDemo implements MessageListener {
    public void onMessage(CharSequence charSequence, Object o) {
        System.out.println(o.toString() + new Date());
    }
}
