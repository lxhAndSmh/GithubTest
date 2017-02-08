package com.liuxuhui.githuptest.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.liuxuhui.githuptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：GithupTest
 * 类描述：
 * 创建人：user
 * 创建时间：2017/2/8 10:12
 * 修改人：user
 * 修改时间：2017/2/8 10:12
 * 修改备注：
 */

public class TabViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text)
    public TextView text;

    public TabViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
