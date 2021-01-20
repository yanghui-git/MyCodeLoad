package com.yh.proxy.stati;

import com.yh.proxy.StudentService;

/**
 * 静态代理模式   缺陷： 如果很多类都需要增加日志 ***  岂不是需要给每个类都要配置代理类？？
 */
public class StaticStudentService implements StudentService {

    StudentService studentService;

    public StaticStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void add() {
        System.out.println("添加学生");
        studentService.add();
        System.out.println("添加学生成功");
    }

    public void delete() {
        System.out.println("删除学生");
        studentService.delete();
        System.out.println("删除学生成功");
    }

}
