package com.yh.module;

/**
 * https://blog.csdn.net/wanggang514260663/article/details/86138144
 *
 *观察者模式
 */
public class ObserverModule {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        ObserverImplOne observerImplOne = new ObserverImplOne();
      //  subject.attach(observerImplOne);
        ObserverImplTwo observerImplTwo = new ObserverImplTwo();
        subject.attach(observerImplTwo);
        subject.attach(observerImplOne);
        //变更通知
        subject.notifyChange();

        subject.delete(observerImplOne);
        subject.notifyChange();
    }

}
