package com.silent.fiveghost.guide.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.HomePagerAdapter;
import com.silent.fiveghost.guide.ui.home.fragments.HomeFragment;
import com.silent.fiveghost.guide.ui.home.fragments.MyPageFragment;
import com.silent.fiveghost.guide.ui.home.fragments.RouteFragment;
import com.silent.fiveghost.guide.ui.home.fragments.robsingle.RobSingleFragment;

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
        setClearStack(true);
        setSteepStatusBar(true);
        addBodyView(R.layout.view_viewpager);
        setFooterView(R.layout.view_tablayout);
    }

    @Override
    protected void run() {
        fragments = new ArrayList<>();
        names = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new RouteFragment());
        fragments.add(new RobSingleFragment());
        fragments.add(new HomeFragment());
        fragments.add(new MyPageFragment());
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
        statusBar.setVisibility(View.VISIBLE);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
    }
}
