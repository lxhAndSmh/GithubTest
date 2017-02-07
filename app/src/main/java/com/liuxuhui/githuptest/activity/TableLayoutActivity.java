package com.liuxuhui.githuptest.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuxuhui.githuptest.R;
import com.liuxuhui.githuptest.adapter.TabViewPagerAdapter;
import com.liuxuhui.githuptest.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
* 项目名称：TableLayoutActivity
* 类描述：AppBarLayout嵌套TabLayout的使用
* 创建人：liuxuhui
* 创建时间：2017/2/7 15:02
* 修改人：liuxuhui
* 修改时间：2017/2/7 15:02
* 修改备注：
* @version
*/
public class TableLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toobar;
    @BindView(R.id.tabLayout)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private List<Fragment> fragments;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        fragments = new ArrayList<>();
        list = new ArrayList<>();
        toobar.setTitle("TableLayoutActivity");
        toobar.setLogo(R.mipmap.ic_launcher);

        //可滑动的
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        for(int i = 1; i < 10; i++){
            tab.addTab(tab.newTab().setText("标题" + i));
            TabFragment fragment = TabFragment.newInstance(TableLayoutActivity.this);
            fragments.add(fragment);
            list.add("标题" + i);
        }

        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager(), list, fragments);
        viewPager.setAdapter(adapter);

        //和ViewPager关联起来
        tab.setupWithViewPager(viewPager);
    }

    @OnClick({R.id.fab})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Snackbar.make(v, "fab点击", Snackbar.LENGTH_LONG).setAction("cancle", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //消除Snackbar后的事件处理
                    }
                }).show();
                break;
        }
    }
}
