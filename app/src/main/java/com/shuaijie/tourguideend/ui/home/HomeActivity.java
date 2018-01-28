package com.shuaijie.tourguideend.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.base.fragment.BaseFragment;
import com.shuaijie.tourguideend.ui.home.adapters.HomePagerAdapter;
import com.shuaijie.tourguideend.ui.home.fragments.HomeFragment;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity {


    private ViewPager viewpager;
    private TabLayout tablayout;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> names;
    private HomePagerAdapter homePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        setSteepStatusBar(true);
        addBodyView(R.layout.view_viewpager);
        setFooterView(R.layout.view_tablayout);
    }

    @Override
    protected void run() {
        fragments = new ArrayList<>();
        names = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        names.add("首页");
        names.add("路线");
        names.add("抢单");
        names.add("订单");
        names.add("我的");
        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), fragments, names);
        viewpager.setAdapter(homePagerAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(4).setIcon(R.mipmap.ic_launcher);

    }


    protected void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
    }
}
