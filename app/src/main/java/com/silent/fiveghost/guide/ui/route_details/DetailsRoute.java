package com.silent.fiveghost.guide.ui.route_details;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.home.adapters.Details_Adapter;

import java.util.ArrayList;
import java.util.List;

public class DetailsRoute extends BaseActivity {

    private RecyclerView detailsRoute_recyxml;
    private ScrollView scroll_details;

    protected void initView() {
        detailsRoute_recyxml = (RecyclerView) findViewById(R.id.detailsRoute_recyxml);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1000" + i);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailsRoute_recyxml.setLayoutManager(linearLayoutManager);

        Details_Adapter details_adapter = new Details_Adapter(this, list);
        detailsRoute_recyxml.setAdapter(details_adapter);
        scroll_details = findViewById(R.id.scroll_details);

    }

    @Override
    protected void init() {
        addBodyView(R.layout.activity_details_route);

    }

    @Override
    protected void run() {
        scroll_details.smoothScrollTo(0,100);
    }
}
