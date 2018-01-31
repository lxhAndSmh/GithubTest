package com.liuxuhui.githuptest.behaviors;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称：GithupTest
 * 类描述：
 * 创建人：liuxuhui
 * 创建时间：2017/2/9 18:59
 * 修改人：liuxuhui
 * 修改时间：2017/2/9 18:59
 * 修改备注：
 */

public class FooterSamplerBehavior extends CoordinatorLayout.Behavior<View> {

    public FooterSamplerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float transY = Math.abs(dependency.getTranslationY());
        child.setTranslationY(transY);
        return true;
    }
}
