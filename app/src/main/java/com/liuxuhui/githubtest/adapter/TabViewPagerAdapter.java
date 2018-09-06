package com.liuxuhui.githubtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 项目名称：GithupTest
 * 类描述：
 * 创建人：user
 * 创建时间：2017/2/7 17:08
 * 修改人：user
 * 修改时间：2017/2/7 17:08
 * 修改备注：
 */

public class TabViewPagerAdapter extends FragmentPagerAdapter{

    private List<String> tabList;
    private List<Fragment> fragments;

    public TabViewPagerAdapter(FragmentManager manager, List<String> tabList, List<Fragment> fragments) {
        super(manager);
        this.tabList = tabList;
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
