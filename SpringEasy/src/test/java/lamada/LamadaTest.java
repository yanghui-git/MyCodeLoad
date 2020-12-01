package lamada;

import com.yanghui.jackson.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 收集lamada表达式一些有意思的用法
 */
public class LamadaTest {

    public static void main(String[] args) {
        // test();
    }

    //求最大平均值
    @Test
    public void test() {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("test1", 20, null));
        studentsList.add(new Student("test2", 33, null));
        studentsList.add(new Student("test3", 22, null));
        studentsList.add(new Student("test4", 10, null));
        //  System.out.println(studentsList);
        int a = studentsList.stream().map(Student::getAge).reduce(Integer::max).get();
        int sum = studentsList.stream().map(Student::getAge).reduce(Integer::sum).get();
        System.out.println(a);
        System.out.println(sum);
    }

    //collectors.toList
    @Test
    public void test2() {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("test1", 20, null));
        studentsList.add(new Student("test2", 33, null));
        studentsList.add(new Student("test3", 22, null));
        studentsList.add(new Student("test4", 10, null));
        System.out.println(studentsList.stream().map(Student::getAge).collect(Collectors.toList()));
        System.out.println(studentsList.stream().map(Student::getName).collect(Collectors.toList()));
    }


}
