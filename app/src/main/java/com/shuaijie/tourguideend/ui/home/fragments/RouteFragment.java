package com.shuaijie.tourguideend.ui.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.fragment.BaseFragment;
import com.shuaijie.tourguideend.ui.home.adapters.Route_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteFragment extends BaseFragment {


    private RecyclerView Routerecycler_xml;

    public RouteFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_route);
    }

    @Override
    protected void run() {
    }

    protected void initView() {
        Routerecycler_xml = (RecyclerView) findViewById(R.id.Routerecycler_xml);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1000" + i);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Routerecycler_xml.setLayoutManager(linearLayoutManager);
        Routerecycler_xml.setAdapter(new Route_Adapter(getActivity(), list));
    }
}
