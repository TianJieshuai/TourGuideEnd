package com.silent.fiveghost.guide.ui.personalcenter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.home.adapters.Details_Adapter;

import java.util.ArrayList;
import java.util.List;

public class ReleaseRouteActivity extends BaseActivity implements View.OnClickListener {


    private ListView lv_list;
    private static final String[] strs = new String[]{
            "first", "second", "third", "fourth", "fifth"
    };
    private ScrollView scroll_details;
    private RecyclerView detailsRoute_recy;
    private TextView delet;
    private TextView add;
    private TextView xiugai;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_release_route);
    }

    @Override
    protected void run() {
        scroll_details.smoothScrollTo(0, 100);
    }

    @Override
    protected void initView() {
        detailsRoute_recy = (RecyclerView) findViewById(R.id.detailsRoute_recyxml);
        xiugai = (TextView) findViewById(R.id.xiugai);
        delet = (TextView) findViewById(R.id.delet);
        add = (TextView) findViewById(R.id.add);
        xiugai.setOnClickListener(this);
        delet.setOnClickListener(this);
        add.setOnClickListener(this);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailsRoute_recy.setLayoutManager(linearLayoutManager);
        detailsRoute_recy.setNestedScrollingEnabled(false);
        Details_Adapter details_adapter = new Details_Adapter(this, list);
        detailsRoute_recy.setAdapter(details_adapter);
        scroll_details = findViewById(R.id.scroll_details);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.xiugai:
                startActivity(new Intent(this,XiuGaiActivity.class));
                break;
            case R.id.delet:
                startActivity(new Intent(this,DeletActivity.class));
                break;
            case R.id.add:
                startActivity(new Intent(this,FaBuActivity.class));
                break;
        }
    }
}
