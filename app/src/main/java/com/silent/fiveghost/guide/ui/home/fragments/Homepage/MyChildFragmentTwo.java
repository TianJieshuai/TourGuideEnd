package com.silent.fiveghost.guide.ui.home.fragments.Homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.beans.HomeItemBean;
import com.silent.fiveghost.guide.ui.home.adapters.RecycleViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyChildFragmentTwo extends BaseFragment {

    private RecyclerView lv_home;
    private ArrayList<HomeItemBean> beanslist;
    private static final String[] strs = new String[]{
            "first", "second", "third", "fourth", "fifth"
    };

    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_my_child);
    }

    @Override
    protected void run() {


    }

    @Override
    protected void initView() {
        beanslist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beanslist.add(new HomeItemBean("城市：丽江",
                    "时间：2018.01.20至2018.02.24",
                    "人数：4人", "旅游偏好：自然风景", "订单类型：一站式"));
        }
        lv_home = (RecyclerView) findViewById(R.id.lv_home);
        lv_home.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        RecycleViewAdapter listViewAdapter = new RecycleViewAdapter(getActivity(), beanslist);
        lv_home.setAdapter(listViewAdapter);
    }
}
