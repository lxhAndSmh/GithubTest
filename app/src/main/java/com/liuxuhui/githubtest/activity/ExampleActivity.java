package com.liuxuhui.githubtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.liuxuhui.githubtest.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxuhui
 * @date 2018/10/12
 */
public class ExampleActivity extends AppCompatActivity {

    private static final String TAG = "ExampleActivity";
    private List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Student stu1 = new Student();
        stu1.setAge(2);
        stu1.setName("lilei");
        Student stu2 = stu1;
       /* try {
            stu2 = (Student) stu1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
        stu2 = stu1;
        Log.d(TAG, "stu1:" + stu1.toString());
        Log.d(TAG, "stu2:" + stu2.toString());
        stu2.setAge(5);
        stu2.setName("hanmeimei");
        List<String> nums = new ArrayList<>();
        nums.add("hello");
        stu2.setNum(nums);
        Log.d(TAG, "-stu1:" + stu1.toString());
        Log.d(TAG, "-stu2:" + stu2.toString() + "====" + stu1.equals(stu2));

        for(int i = 0; i < 3; i++) {
            Student student = new Student();
            student.setAge(i);
            students.add(student);
        }
        Student stu3 = students.get(0);
       setValue(stu3);
    }

    private void setValue(Student student) {
        student.setAge(10);
        student.setName("gaolei");
        Log.d(TAG, "-stu3:" + students.get(0).toString() + "====" + student.equals(students.get(0)));
    }

}
