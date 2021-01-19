package com.yh.blockqueue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue 优先级队列   https://blog.csdn.net/qq_41907991/article/details/95666271
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        priorityQueue.add(new Task(2, "test2"));
        priorityQueue.add(new Task(5, "test5"));
        priorityQueue.add(new Task(1, "test1"));
        priorityQueue.add(new Task(3, "test3"));
        priorityQueue.add(new Task(9, "test9"));
        priorityQueue.add(new Task(8, "test8"));
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    @Data
    @AllArgsConstructor
    static class Task {
        int priority;
        String name;
    }

}
