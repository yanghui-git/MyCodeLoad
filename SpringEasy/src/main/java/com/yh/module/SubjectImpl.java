package com.yh.module;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class SubjectImpl implements Subject {

    private List<Observer> observerList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    public void delete(Observer observer) {
        this.observerList.remove(observer);
    }

    public void notifyChange() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
