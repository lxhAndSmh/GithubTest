package com.liuxuhui.githuptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuxuhui.githuptest.R;

/**
 * Created by liuxuhui on 2018/2/26 16:07
 * git 命令行练习
 */
public class GitExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_example);
        //修改刚提交的错误代码 git commit --amend
    }
}
