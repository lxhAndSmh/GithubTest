package com.liuxuhui.githubtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.liuxuhui.githubtest.R;
import com.liuxuhui.githubtest.bean.School;
import com.liuxuhui.githubtest.bean.Student;
import com.liuxuhui.githubtest.bean.Worker;
import com.liuxuhui.githubtest.utils.CloneUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关于对象的深克隆和浅克隆
 *
 * 在Java中，数据类型分两种，值类型（即基本数据类型，int、byte等）和引用类型（包含类、接口和数组等复杂类型）；
 * 值类型进行克隆时，是深克隆；引用类型的克隆时，是浅克隆
 * 浅克隆：Object b = new Object(); Object a = b; 这时a和b在内存堆中引用同一个对象
 * 深克隆：即复制一个全新的对象，在内存堆里会新建一个对象
 *
 * @author liuxuhui
 * @date 2018/10/12
 */
public class ExampleActivity extends AppCompatActivity {

    private static final String TAG = "ExampleActivity";
    private List<Student> students = new ArrayList<>();
    @BindView(R.id.textView2)
    TextView textView;

    private Student stu1;
    private Student stu2;

    private School school1;
    private School school2;
    private StringBuilder stringBuilder;

    private Worker worker1;
    private Worker worker2;
    private StringBuilder stringBuilder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
        stu1 = new Student();
        stu1.setAge(2);
        stu1.setName("lilei");
        Student.Teacher teacher = stu1.new Teacher();
        teacher.age = 10;
        stu1.setTeacher(teacher);

        stu2 = (Student) stu1.clone();
        Log.d(TAG, "stu1:" + stu1.toString());
        Log.d(TAG, "stu2:" + stu2.toString());

        stu2.setAge(5);
        stu2.setName("hanmeimei");
        List<String> nums = new ArrayList<>();
        nums.add("hello");
        stu2.setNum(nums);
        Log.d(TAG, "-stu1:" + stu1.toString());
        Log.d(TAG, "-stu2:" + stu2.toString() + "====" + stu1.equals(stu2));

        stringBuilder = new StringBuilder();
        school1 = new School();
        school1.name = "北大";
        school2 = school1;
        stringBuilder.append("修改克隆值前：\n" + school1.toString() + "\n" + school2);
        school2.name = "清华";
        stringBuilder.append("\n修改克隆值后：\n" + school1.toString() + "\n" + school2);

        stringBuilder1 = new StringBuilder();
        worker1 = new Worker();
        worker1.age = 25;
        worker1.name = "Tom";
        worker1.school = new School("北大");
        worker2 = CloneUtils.clone(worker1);
        stringBuilder1.append("修改克隆值前：\n" + worker1.toString() + "\n" + worker2);
        worker2.age = 20;
        worker2.name = "Jim";
        worker2.school = new School("清华");
        stringBuilder1.append("\n修改克隆值后：\n" + worker1.toString() + "\n" + worker2);

    }

    @OnClick({R.id.btn_copy_1, R.id.btn_copy_2, R.id.btn_copy_3})
    public void onClick(View view) {
        switch (view.getId()) {
            //浅克隆
            case R.id.btn_copy_1:
                textView.setText(stringBuilder.toString());
                break;
            //深克隆
            case R.id.btn_copy_2:
                textView.setText(stu1.toString() + "\n" + stu2.toString());
                break;
            //通过字节流深克隆
            case R.id.btn_copy_3:
                textView.setText(stringBuilder1.toString());
                break;
            default:
                break;
        }
    }
}
