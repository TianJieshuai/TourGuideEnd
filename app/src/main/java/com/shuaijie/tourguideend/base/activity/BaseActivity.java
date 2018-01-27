package com.shuaijie.tourguideend.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.utils.Gson;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * 你的指尖--有改变世界的力量！
 * Created by Nyh on 2017/12/22.
 */
/*
 *定义抽象的BaseActivity,其余的Activity全部继承BaseActivity，
 *便于统一管理，一处修改，到处有效
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    //是否状态栏透明
    protected boolean isSetStatusBar = false;
    //是否允许全屏
    protected boolean mAllowFullScreen = false;
    //是否禁止屏幕旋转
    protected boolean isAllowScreenRoate = false;
    //用来保存所有已经打开的Activity
    protected static Stack<Activity> activityList = new Stack<Activity>();

    //记录上次点击按钮的时间
    private long lastClickTime;

    //按钮连续点击最低间隔时间
    public final static int CLICK_TIME = 500;
    //头布局
    private LinearLayout headerlayout;
    //尾布局
    private LinearLayout footerlayout;
    //不可滚动
    private LinearLayout not_scroll_body_layout;
    //可滚动
    private LinearLayout scroll_body_layout;
    //下拉刷新
    private LinearLayout refresh_body_layout;
    //身体布局
    private RelativeLayout body_layout;
    //间隙
    private View header_body_interval;
    private View body_footer_interval;
    //滚动控件
    private ScrollView scroll_body_view;
    //下拉刷新控件
    private SwipeRefreshLayout refresh_body_view;

    //setHeaderView设置的view作用加载头布局
    private View headerView;
    //身体布局可同时存储多个
    private Map<Integer, View> bodyViewMap = new HashMap<>();
    //尾布局
    private View footerView;

    public final View inflate(int res) {
        return View.inflate(this, res, null);
    }

    //头布局
    public void setHeaderView(int headerView) {
        setHeaderView(inflate(headerView));
    }

    //头布局
    public void setHeaderView(View headerView) {
        this.headerView = headerView;
    }

    //设置身体布局 key = resID
    protected void addBodyView(int res) {
        this.bodyViewMap.put(res, inflate(res));
    }

    //设置尾布局
    public void setFooterView(int footerView) {
        setFooterView(inflate(footerView));
    }

    //设置尾布局
    public void setFooterView(View footerView) {
        this.footerView = footerView;
    }

    //检测加载头布局
    private final void checkLoadHeader() {
        if (headerView != null) {
            headerlayout.addView(headerView);
            header_body_interval.setVisibility(View.VISIBLE);
        }
    }

    //身体布局加载模式
    private int bodyShowModl = 1;
    //不可滚动
    private final int NOTSCROLL = 1;
    //可滚动
    private final int SCROLL = 2;
    //下拉刷新
    private final int REFRESH = 3;

    //设置身体布局加载模式
    public void setBodyShowModl(int bodyShowModl) {
        switch (bodyShowModl) {
            case NOTSCROLL:
            case SCROLL:
            case REFRESH:
                this.bodyShowModl = bodyShowModl;
                break;
            default:
                throw new NullPointerException("未识别");
        }
    }

    private final void checkShowBody() {
        switch (bodyShowModl) {
            case NOTSCROLL:
                not_scroll_body_layout.setVisibility(View.VISIBLE);
                break;
            case SCROLL:
                scroll_body_layout.setVisibility(View.VISIBLE);
                break;
            case REFRESH:
                refresh_body_layout.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 加载布局
     *
     * @param res
     */
    protected final void loadBody(int res) {
        removeBodyAllViews();
        View bodyView = bodyViewMap.get(res);
        try {
            if (bodyView == null) {
                bodyViewMap.put(res, inflate(res));
            }
            switch (bodyShowModl) {
                case NOTSCROLL:
                    not_scroll_body_layout.addView(bodyViewMap.get(res));
                    break;
                case SCROLL:
                    scroll_body_layout.addView(bodyViewMap.get(res));
                    break;
                case REFRESH:
                    refresh_body_layout.addView(bodyViewMap.get(res));
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, "未找到此布局", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 移除现在显示的身体布局
     */
    private final void removeBodyAllViews() {
        not_scroll_body_layout.removeAllViews();
        scroll_body_layout.removeAllViews();
        refresh_body_layout.removeAllViews();
    }

    /**
     * 检测加载尾布局
     */
    private final void checkLoadFooter() {
        if (footerView != null) {
            footerlayout.addView(footerView);
            body_footer_interval.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        // 将activity推入栈中
        activityList.push(this);
        // 初始化布局,记得要在这个方法里面setContentView()
        init();
        // 初始化基础控件
        initViews();

        //检测加载头布局
        checkLoadHeader();
        //检测加载身体布局
        checkShowBody();
        //检测加载尾布局
        checkLoadFooter();
        //加载身体布局
        Iterator<Map.Entry<Integer, View>> iterator = bodyViewMap.entrySet().iterator();
        if (iterator.hasNext())
            loadBody(iterator.next().getKey());
        //初始化页面控件
        initView();
        // 初始化数据
        run();

        //如果设置为true，就显示全屏
        if (mAllowFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        //状态栏透明的(沉浸式状态栏)
        if (isSetStatusBar) {
            steepStatusBar();
        }
        //如果为false就禁止屏幕旋转
        if (!isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从栈中移除当前activity
        if (activityList.contains(this)) {
            activityList.remove(this);
        }
    }

    private void initViews() {
        headerlayout = (LinearLayout) findViewById(R.id.headerlayout);
        not_scroll_body_layout = (LinearLayout) findViewById(R.id.not_scroll_body_layout);
        scroll_body_layout = (LinearLayout) findViewById(R.id.scroll_body_layout);
        scroll_body_view = (ScrollView) findViewById(R.id.scroll_body_view);
        refresh_body_layout = (LinearLayout) findViewById(R.id.refresh_body_layout);
        refresh_body_view = (SwipeRefreshLayout) findViewById(R.id.refresh_body_view);
        body_layout = (RelativeLayout) findViewById(R.id.body_layout);
        footerlayout = (LinearLayout) findViewById(R.id.footerlayout);
        header_body_interval = (View) findViewById(R.id.header_body_interval);
        body_footer_interval = (View) findViewById(R.id.body_footer_interval);
    }

    protected void initView() {
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz         所跳转的Activity类
     * @param requestCode 请求码
     */
    public void startActivityForResult(Class<?> clz, int requestCode) {
        startActivityForResult(new Intent(this, clz), requestCode);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转页面
     *
     * @param clz         所跳转的Activity类
     * @param bundle      跳转所携带的信息
     * @param requestCode 请求码
     */
    public void startActivityForResult(Class<?> clz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 消息提示框
     *
     * @param message 提示消息文本
     */
    public void showToast(String message) {
        if (!message.equals("")) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 消息提示框
     *
     * @param messageId 提示消息文本ID
     */
    public void showToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

    /*
     * 如果你的项目有侧滑栏可以处理此方法,声明成protected的让子类可以重写
     */
    protected void addLeftMenu(boolean enable) {
        // 是否能有侧滑栏
        if (enable) {

        } else {

        }
    }

    /**
     * 初始化布局
     **/
    protected abstract void init();

    /**
     * 初始化数据
     **/
    protected abstract void run();

    /**
     * 初始化控件和监听
     **/

    /*
     * 子类可用该方法查找控件
     */
    public <T extends View> T findViewById(int id) {
        return (T) super.findViewById(id);
    }


    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /*
      用于保存Activity的数据不丢失
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /*
     *子类可以在横竖屏切换时重写该方法用于保存数据不丢失
     */
    protected void saveInstanceState(Bundle outState) {

    }

    /**
     * [是否允许全屏]
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     * [是否允许屏幕旋转]
     *
     * @param isAllowScreenRoate
     */
    public void setScreenRoate(boolean isAllowScreenRoate) {
        this.isAllowScreenRoate = isAllowScreenRoate;
    }

    //验证上次点击按钮时间间隔，防止重复点击
    public boolean verifyClickTime() {
        if (System.currentTimeMillis() - lastClickTime <= CLICK_TIME) {
            return false;
        }
        lastClickTime = System.currentTimeMillis();
        return true;
    }

    /**
     * 关闭所有(前台、后台)Activity,注意：请已BaseActivity为父类
     */
    protected static void finishAll() {
        int leng = activityList.size();
        for (int i = 0; i < leng; i++) {
            Activity activity = activityList.pop();
            activity.finish();
        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (KeyEvent.KEYCODE_BACK == keyCode) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                finishAll();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private Fragment currentFragment;

    /**
     * Fragment替换(当前destrory,新的create)
     */
    public void fragmentReplace(int target, Fragment toFragment, boolean backStack) {
        //获取V4包下的Fragment管理器
        FragmentManager manager = getSupportFragmentManager();
        //拿到事务对象
        FragmentTransaction transaction = manager.beginTransaction();
        String toClassName = toFragment.getClass().getSimpleName();
        if (manager.findFragmentByTag(toClassName) == null) {
            transaction.replace(target, toFragment, toClassName);
            if (backStack) {
                transaction.addToBackStack(toClassName);
            }
            transaction.commit();
        }
    }

    /**
     * Fragment替换(核心为隐藏当前的,显示现在的,用过的将不会destrory与create)
     */
    public void smartFragmentReplace(int target, Fragment toFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 如有当前在使用的->隐藏当前的
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        String toClassName = toFragment.getClass().getSimpleName();
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(toClassName) != null) {
            transaction.show(toFragment);
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(target, toFragment, toClassName);
        }
        transaction.commit();
        // toFragment更新为当前的
        currentFragment = toFragment;
    }

    public String toJson(Object o) {
        return Gson.toJson(o);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return Gson.fromJson(json, typeOfT);
    }
}
