package com.liuxuhui.githubtest.bean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author liuxuhui
 * @date 2018/10/12
 */
public class Student implements Cloneable{
    @SerializedName("age")
    private int age;
    private String name;

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private List<String> num;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNum() {
        return num;
    }

    public void setNum(List<String> num) {
        this.num = num;
    }

    @Override
    public Object clone(){
        Student student = null;
        try {
            student = (Student) super.clone();
            student.teacher = (Teacher) teacher.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
    public class Teacher implements Cloneable{
        public int age;

        @Override
        public Object clone() {
            Teacher teacher = null;
            try {
                teacher = (Teacher) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return teacher;
        }
    }
}

