package com.silent.fiveghost.guide.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.HomePagerAdapter;
import com.silent.fiveghost.guide.ui.home.fragments.HomeFragment;
import com.silent.fiveghost.guide.ui.home.fragments.MyPageFragment;
import com.silent.fiveghost.guide.ui.home.fragments.OrderFragment;
import com.silent.fiveghost.guide.ui.home.fragments.RouteFragment;
import com.silent.fiveghost.guide.ui.home.fragments.robsingle.RobSingleFragment;
import com.zhy.autolayout.utils.AutoUtils;

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
        addBodyView(R.layout.activity_home);
    }

    @Override
    protected void run() {
        fragments = new ArrayList<>();
        names = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new RouteFragment());
        fragments.add(new RobSingleFragment());
        fragments.add(new OrderFragment());
        fragments.add(new MyPageFragment());
        names.add("首页");
        names.add("路线");
        names.add("抢单");
        names.add("订单");
        names.add("我的");
        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), fragments, names);
        viewpager.setAdapter(homePagerAdapter);
        viewpager.setOffscreenPageLimit(fragments.size());
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
        tablayout.getTabAt(4).setIcon(R.mipmap.ic_launcher);

        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                fragments.get(position).onResume();
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                for (int x = 0; x < fragments.size(); x++) {
                    fragments.get(x).onStop();
                }
                super.onPageScrollStateChanged(state);
            }
        });
    }


    protected void initView() {
//        statusBar.setVisibility(View.VISIBLE);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        View view = LayoutInflater.from(this).inflate(R.layout.home_dock, base, false);
        AutoUtils.autoSize(view);
        RadioGroup reaio = view.findViewById(R.id.reaio);
        dock.addView(view);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
    }


}
