package com.liuxuhui.githubtest.bean;

import java.io.Serializable;

/**
 * @author liuxuhui
 * @date 2018/10/16
 */
public class Worker implements Serializable {

    public int age;
    public String name;
    public School school;

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
