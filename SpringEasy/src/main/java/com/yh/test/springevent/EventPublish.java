package com.yh.test.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 */
@Component
public class EventPublish {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 源码研究 设置 task executor ！=null 即开启异步线程去操作
     * @return
     *
     * 所有的事件响应程序都异步化了
     *
     * --> @Async 开启异步事件
     * AnnotationAsyncExecutionInterceptor
     *  Callable<Object> task = new Callable<Object>() {
     *                 public Object call() throws Exception {
     *                     try {
     *                         Object result = invocation.proceed();
     *                         if (result instanceof Future) {
     *                             return ((Future)result).get();
     *                         }
     */
/*
    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor());
        return simpleApplicationEventMulticaster;
    }
*/

    public void publish() {
        System.out.println("开始发布事件.......");
        EventDao eventDao = new EventDao(applicationContext, "test1", 100, "hangz");
        applicationContext.publishEvent(eventDao);
        System.out.println("发布事件成功");
        try {
            System.in.read();
        } catch (Exception e) {
            //   e.printStackTrace();
        }
    }

}
