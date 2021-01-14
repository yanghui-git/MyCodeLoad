package com.yh.testone;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeTest {

    @Data
    @AllArgsConstructor
    static class Demo {
        boolean parent;
        String parentName;
        String name;
        List<Demo> list;
    }

    public static void main(String[] args) {
        List<Demo> demos = Arrays.asList(
                new Demo(true, null, "1", null),
                new Demo(false, "1", "2", null),
                new Demo(false, "1", "3", null),
                new Demo(false, "2", "4", null),
                new Demo(false, "3", "5", null),
                new Demo(false, "3", "6", null),
                new Demo(false, "1", "7", null),
                new Demo(false, "7", "8", null),
                new Demo(false, "8", "9", null)

        );
        LinkedList<Demo> arrayList = new LinkedList();
        arrayList.addAll(demos.stream().filter(Demo::isParent).collect(Collectors.toList()));
        Demo last1 = arrayList.getLast();
        while (true) {
            Demo last = arrayList.removeLast();
            List<Demo> collect = demos.stream().filter(s -> last.name.equals(s.parentName)).collect(Collectors.toList());
            arrayList.addAll(collect);
            last.list = collect;
            if (arrayList.isEmpty())
                break;
        }
        System.out.println(last1);

    }

    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.getLast());
        System.out.println(list.getLast());
        System.out.println(list.getFirst());

        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        /*boolean aaa = true;
        while (aaa) {
            int a = list.removeLast();
            System.out.println(a);
            if (list.isEmpty()) {
                aaa = false;
                //break;
            }
        }
*/
    }
}
