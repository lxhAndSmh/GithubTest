package com.liuxuhui.githuptest.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuxuhui.githuptest.R;
import com.liuxuhui.githuptest.adapter.TabRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {

    @BindView(R.id.listView)
    RecyclerView listView;

    private Unbinder unbinder;
    private List<String> list;
    private static Context context;

    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment newInstance(Context con){
        context = con;
        return  new TabFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    public void initData(){
        list = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            list.add("内容=====" + i);
        }
        TabRecycleViewAdapter adapter = new TabRecycleViewAdapter(context, list);
        listView.setLayoutManager(new LinearLayoutManager(context));
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
