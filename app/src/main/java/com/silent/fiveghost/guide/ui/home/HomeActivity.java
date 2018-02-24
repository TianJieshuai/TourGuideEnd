package com.silent.fiveghost.guide.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.application.App;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.event.MessageEvent;
import com.silent.fiveghost.guide.ui.home.adapters.HomePagerAdapter;
import com.silent.fiveghost.guide.ui.home.fragments.HomeFragment;
import com.silent.fiveghost.guide.ui.home.fragments.MyPageFragment;
import com.silent.fiveghost.guide.ui.home.fragments.OrderFragment;
import com.silent.fiveghost.guide.ui.home.fragments.RouteFragment;
import com.silent.fiveghost.guide.ui.home.fragments.robsingle.RobSingleFragment;
import com.zhy.autolayout.utils.AutoUtils;

import org.greenrobot.eventbus.EventBus;

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
        viewpager.setCurrentItem(0);
        tablayout.setupWithViewPager(viewpager, false);
        tablayout.getTabAt(0).setIcon(R.drawable.home_selector);
        tablayout.getTabAt(1).setIcon(R.drawable.luxian_selector);
        tablayout.getTabAt(2).setIcon(R.drawable.qiangdian);
        tablayout.getTabAt(3).setIcon(R.drawable.dingdan_selector);
        tablayout.getTabAt(4).setIcon(R.drawable.me_selector);
        tablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition(), false);
            }
        });
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


        App.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 1000; x++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    EventBus.getDefault().removeAllStickyEvents();
                    EventBus.getDefault().postSticky(new MessageEvent(x));
                }
                EventBus.getDefault().postSticky(new MessageEvent(0));
            }
        });
    }


    protected void initView() {
//        statusBar.setVisibility(View.VISIBLE);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        View view = LayoutInflater.from(this).inflate(R.layout.home_dock, base, false);
        AutoUtils.autoSize(view);
        dock.addView(view);
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                viewpager.getParent().requestDisallowInterceptTouchEvent(true);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


}
