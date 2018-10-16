package com.liuxuhui.githubtest.bean;

import java.io.Serializable;

/**
 * @author liuxuhui
 * @date 2018/10/15
 */
public class School implements Serializable{
    public String name;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
