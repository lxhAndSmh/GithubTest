package com.liuxuhui.githuptest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.liuxuhui.githuptest.R;
import com.liuxuhui.githuptest.adapter.TabRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* 项目名称：BehaviorActivity
* 类描述：CoordinatorLayout与Behavior实现仿知乎的嵌套滑动和渐隐效果
* 创建人：liuxuhui
* 创建时间：2017/2/7 10:50
* 修改人：liuxuhui
* 修改时间：2017/2/7 10:50
* 修改备注：
* @version
*/
public class BehaviorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<String> strs;
    private TabRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        ButterKnife.bind(this);
        initData();
    }

    public void initData(){

        toolbar.setTitle("自定义Behavior");

        strs = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            strs.add("测试=====" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TabRecycleViewAdapter(this, strs);
        recyclerView.setAdapter(adapter);
    }
}