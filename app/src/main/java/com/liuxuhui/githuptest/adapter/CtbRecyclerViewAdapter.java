package com.liuxuhui.githuptest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.liuxuhui.githuptest.R;
import com.liuxuhui.githuptest.viewholder.CtbViewHolder;

/**
 * 项目名称：GithupTest
 * 类描述：
 * 创建人：user
 * 创建时间：2017/2/8 18:10
 * 修改人：user
 * 修改时间：2017/2/8 18:10
 * 修改备注：
 */

public class CtbRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;

    public CtbRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CtbViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
