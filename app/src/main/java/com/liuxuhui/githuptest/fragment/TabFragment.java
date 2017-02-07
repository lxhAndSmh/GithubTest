package com.liuxuhui.githuptest.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liuxuhui.githuptest.R;

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
    ListView listView;

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
        View view = inflater.inflate(R.layout.fragment_tab, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    public void initData(){
        list = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            list.add("内容=====" + i);
        }
        ArrayAdapter adapter = new ArrayAdapter(context, R.layout.item_array, R.id.text, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
