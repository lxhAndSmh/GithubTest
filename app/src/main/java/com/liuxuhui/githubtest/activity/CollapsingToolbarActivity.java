package com.liuxuhui.githubtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.liuxuhui.githubtest.R;
import com.liuxuhui.githubtest.adapter.CtbRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* 项目名称：GithubTest
* 类描述：随着视图滑动可折叠的ToolBar
* 创建人：liuxuhui
* 创建时间：2017/2/8 17:41
* 修改人：liuxuhui
* 修改时间：2017/2/8 17:41
* 修改备注：
* @version
*/
public class CollapsingToolbarActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        ButterKnife.bind(this);
        initData();
    }

    public void initData(){
        toolbar.setTitle("你好");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CtbRecyclerViewAdapter adapter = new CtbRecyclerViewAdapter(CollapsingToolbarActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
