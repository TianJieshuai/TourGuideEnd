package com.shuaijie.tourguideend.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.shuaijie.tourguideend.R;

/**
 * Created by shuaiJie on 2017/12/2.
 */

public class Dock {
    //窗口管理器
    private static WindowManager manager;

    //添加视图
    public static WindowManager makeView(final View view) {
        return makeView(view, 5000);
    }

    public static WindowManager makeView(final View view, long delayMillis) {
        WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
        //TYPE_SYSTEM_OVERLAY 比 TYPE_PHONE 更高级，可以避免应用程序改变状态栏时被覆盖，但是不能点击滑动
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;

        mLayoutParams.format = PixelFormat.RGBA_8888;
        mLayoutParams.flags =
                // 不阻塞事件传递到后面的窗口
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        //沉浸式状态栏
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                        // 悬浮窗口较小时，后面的应用图标由不可长按变为可长按,弹出的View收不到Back键的事件
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        //不受手机界面限制，比如y值设置为负的时候可以在状态栏上显示
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;


        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;

        view.setLayoutParams(mLayoutParams);
        manager.addView(view, mLayoutParams);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeView(view);
            }
        }, delayMillis);
        return manager;
    }

    //在Application中初始化保证使用同一个窗口管理器
    public static void init(Context context) {
        manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    //移除视图
    public static void removeView(View view) {
        manager.removeView(view);
    }
}
