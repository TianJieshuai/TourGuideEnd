package com.shuaijie.tourguideend.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;


public class HomeActivity extends BaseActivity {


    private ViewPager viewpager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        addBodyView(R.layout.view_viewpager);
        setFooterView(R.layout.view_tablayout);
    }

    @Override
    protected void run() {

    }


    protected void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
    }
}
