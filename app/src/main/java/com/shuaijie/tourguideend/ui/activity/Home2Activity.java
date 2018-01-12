package com.shuaijie.tourguideend.ui.activity;


import android.os.Bundle;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;

public class Home2Activity extends BaseActivity {


    @Override
    protected void init() {

        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
        //设置布局
        addBodyView(R.layout.activity_home2);

    }

    /*
     * 填充数据
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
