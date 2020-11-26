package com.yanghui.testone;

import java.util.List;

public class Teacher {
    public List<Student> students;
    public String apikey;

    public Teacher() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher(List<Student> students, String apikey) {
        this.students = students;
        this.apikey = apikey;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
