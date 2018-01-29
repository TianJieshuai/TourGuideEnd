package com.shuaijie.tourguideend.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.event.DataEvent;
import com.shuaijie.tourguideend.event.GetDataEvent;
import com.shuaijie.tourguideend.event.PostDataEvent;
import com.shuaijie.tourguideend.utils.GsonUtils;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2017/12/25.
 */
/*
 *定义抽象的BaseFragment,其余的Fragment全部继承BaseFragment，
 *便于统一管理，一处修改，到处有效
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 根（父）view
     */
    protected View mRootView;

    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;

    //setHeaderView设置的view作用加载头布局
    protected View headerView;
    //身体布局可同时存储多个
    protected Map<Integer, View> bodyViewMap = new HashMap<>();
    // 状态栏填充
    protected View statusBar;
    //尾布局
    protected View footerView;
    //头布局
    protected LinearLayout headerlayout;
    //尾布局
    protected LinearLayout footerlayout;
    //不可滚动
    protected LinearLayout not_scroll_body_layout;
    //可滚动
    protected LinearLayout scroll_body_layout;
    //下拉刷新
    protected LinearLayout refresh_body_layout;
    //身体布局
    protected RelativeLayout body_layout;
    //间隙
    protected View header_body_interval;
    protected View body_footer_interval;
    //滚动控件
    protected ScrollView scroll_body_view;
    //下拉刷新控件
    protected SwipeRefreshLayout refresh_body_view;
    //分段加载容器
    protected LinearLayout base;
    //悬浮容器
    protected RelativeLayout dock;


    public final View inflate(int res) {
        return View.inflate(getContext(), res, null);
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

    //不可滚动
    private final int BODY_MODE_NOTSCROLL = 1;
    //可滚动
    private final int BODY_MODE_SCROLL = 2;
    //下拉刷新
    private final int BODY_MODE_REFRESH = 3;
    //身体布局加载模式
    private int bodyShowModl = BODY_MODE_NOTSCROLL;


    //设置身体布局加载模式
    public void setBodyShowModl(int bodyShowModl) {
        switch (bodyShowModl) {
            case BODY_MODE_NOTSCROLL:
                this.bodyShowModl = BODY_MODE_NOTSCROLL;
            case BODY_MODE_SCROLL:
                this.bodyShowModl = BODY_MODE_NOTSCROLL;
            case BODY_MODE_REFRESH:
                this.bodyShowModl = BODY_MODE_REFRESH;
                break;
            default:
                throw new NullPointerException("未识别");
        }
    }

    private final void checkShowBody() {
        switch (bodyShowModl) {
            case BODY_MODE_NOTSCROLL:
                not_scroll_body_layout.setVisibility(View.VISIBLE);
                break;
            case BODY_MODE_SCROLL:
                scroll_body_layout.setVisibility(View.VISIBLE);
                break;
            case BODY_MODE_REFRESH:
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
                case BODY_MODE_NOTSCROLL:
                    not_scroll_body_layout.addView(bodyViewMap.get(res));
                    break;
                case BODY_MODE_SCROLL:
                    scroll_body_layout.addView(bodyViewMap.get(res));
                    break;
                case BODY_MODE_REFRESH:
                    refresh_body_layout.addView(bodyViewMap.get(res));
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "未找到此布局", Toast.LENGTH_SHORT).show();
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
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_base, container, false);
        // 初始化基础控件
        initViews();
        initData(getArguments());


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
        // 初始化子类布局
        initView();
        // 初始化数据
        onVisibleToUser();


        mIsPrepare = true;

        return mRootView;
    }

    protected void initView() {
    }

    private void initViews() {
        headerlayout = findViewById(R.id.headerlayout);
        header_body_interval = findViewById(R.id.header_body_interval);
        not_scroll_body_layout = findViewById(R.id.not_scroll_body_layout);
        scroll_body_layout = findViewById(R.id.scroll_body_layout);
        scroll_body_view = findViewById(R.id.scroll_body_view);
        refresh_body_layout = findViewById(R.id.refresh_body_layout);
        refresh_body_view = findViewById(R.id.refresh_body_view);
        body_layout = findViewById(R.id.body_layout);
        body_footer_interval = findViewById(R.id.body_footer_interval);
        footerlayout = findViewById(R.id.footerlayout);
        base = findViewById(R.id.base);
        dock = findViewById(R.id.dock);
        statusBar = findViewById(R.id.statusBar);
    }


    /**
     * 初始化数据
     *
     * @param arguments 接收到的从其他地方传递过来的参数
     */
    protected abstract void initData(Bundle arguments);

    /*
     * 懒加载的方法，只用在base里面重写就可以了
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        this.mIsVisible = isVisibleToUser;

        if (isVisibleToUser) {
            onVisibleToUser();
        }
    }

    /**
     * 用户可见时执行的操作
     */
    private void onVisibleToUser() {
        if (mIsPrepare && mIsVisible) {
            //由名字就可以看出，真正的懒加载的方法，子类必须重写，然后方法中完成具体的逻辑
            run();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     */
    protected abstract void run();

    /*
     * 查找控件的方法
     */
    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }
        return (T) mRootView.findViewById(id);
    }

    public String toJson(Object o) {
        return GsonUtils.toJson(o);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return GsonUtils.fromJson(json, typeOfT);
    }

    /**
     * ***************************************************************************************
     * 网络相关 ********************************************************************************
     * *****************************************************************************************
     */
    public void sendPost(PostDataEvent event) {
        sendHttp(event);
    }

    public void sendGet(GetDataEvent event) {
        sendHttp(event);
    }

    public void sendHttp(DataEvent event) {
        EventBus.getDefault().post(event);
    }
}