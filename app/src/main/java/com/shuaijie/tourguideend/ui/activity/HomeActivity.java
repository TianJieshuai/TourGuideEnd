package com.shuaijie.tourguideend.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;

/**
 * 你的指尖--有改变世界的力量！
 * Created by Nyh on 2017/12/22.
 */

public class HomeActivity extends BaseActivity {

    private ViewPager view_viewPager;
    private TabLayout tab_tablayout;

    /*
     *初始化布局
     */
    @Override
    protected void init() {
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
        //设置布局
        addBodyView(R.layout.activity_home);
    }

    /*
     *初始化控件
     */
    protected void initView() {
        view_viewPager = findViewById(R.id.view_viewPager);
        tab_tablayout = findViewById(R.id.tab_tablayout);
        //将tablayout和viewpager绑定
        tab_tablayout.setupWithViewPager(view_viewPager);
    }

    /*
     *设置数据
     */
    @Override
    protected void run() {

    }

    /*
     * 有侧滑页面的方法
     */
    @Override
    protected void addLeftMenu(boolean enable) {


    }

    /*
     * 在此方法中保存数据
     */
    @Override
    protected void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
    }
}
