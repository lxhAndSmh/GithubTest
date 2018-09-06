package com.liuxuhui.githubtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.liuxuhui.githubtest.R;
import com.liuxuhui.githubtest.viewholder.TabViewHolder;

import java.util.List;

/**
 * 项目名称：GithupTest
 * 类描述：TabFragment的RecycleView适配器
 * 创建人：liuxuhui
 * 创建时间：2017/2/8 10:01
 * 修改人：
 * 修改时间：2017/2/8 10:01
 * 修改备注：
 */

public class TabRecycleViewAdapter extends RecyclerView.Adapter<TabViewHolder> {

    private Context context;
    private List<String> list;

    public TabRecycleViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TabViewHolder(LayoutInflater.from(context).inflate(R.layout.item_array, parent, false));
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }

}
