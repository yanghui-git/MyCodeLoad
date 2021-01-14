package com.yh.module;

/**
 * 观察者主题对象
 */
public interface Subject {

    /**
     * 订阅
     */
    void attach(Observer observer);

    /**
     * 取消订阅
     */
    void delete(Observer observer);

    /**
     * 变更通知
     */
    void notifyChange();
}
