package com.silent.fiveghost.guide.ui.personalcenter;

import android.widget.ListView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.home.adapters.MyAdapter;

public class ReleaseRouteActivity extends BaseActivity {


    private ListView lv_list;
    private static final String[] strs = new String[]{
            "first", "second", "third", "fourth", "fifth"
    };

    @Override
    protected void init() {
        addBodyView(R.layout.activity_release_route);
    }

    @Override
    protected void run() {

    }
    @Override
    protected void initView() {
         lv_list = (ListView) findViewById(R.id.lv_list);
        MyAdapter myAdapter = new MyAdapter(this,strs);
        lv_list.setAdapter(myAdapter);
    }
}
