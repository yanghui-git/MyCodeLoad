package com.yh.ThreadLocal;

public class ThreadLocalTest {

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + ":: " + task.cal(10))).start();
        }

        TaskTwo taskTwo = new TaskTwo();
        for (int i = 0; i < 5; i++) {
            int j=i;
            new Thread(() -> System.out.println("222" + Thread.currentThread().getName() + "thread local " + taskTwo.cal(j).toString())).start();
        }
    }


    static class Task {

        private int value;

        public int cal(int i) {
            value += i;
            return value;
        }
    }

    /**
     * ThreadLocal https://blog.csdn.net/g6U8W7p06dCO99fQ3/article/details/106484907?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-9&spm=1001.2101.3001.4242
     */
    static class TaskTwo {
        private ThreadLocal<Integer> value = new ThreadLocal<>();

        public Integer cal(int i) {
            // 1 通过 Thread.currentThread() 获取当前线程
            // 2 ThreadLocalMap 维护 数据
            value.set((value.get() == null ? 0 : value.get()) + i);
            return value.get();
        }
    }

}
