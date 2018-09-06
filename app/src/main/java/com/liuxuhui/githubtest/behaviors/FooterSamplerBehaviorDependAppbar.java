package com.liuxuhui.githubtest.behaviors;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称：GithubTest
 * 类描述：自定义Behavior，仿简书滑动隐藏头部的底部，全屏效果
 * 创建人：liuxuhui
 * 创建时间：2017/2/10 11:15
 * 修改人：liuxuhui
 * 修改时间：2017/2/10 11:15
 * 修改备注：
 */

public class FooterSamplerBehaviorDependAppbar extends CoordinatorLayout.Behavior<View> {

    public FooterSamplerBehaviorDependAppbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float transY = Math.abs(dependency.getTop());
        child.setTranslationY(transY);
        return true;
    }
}
