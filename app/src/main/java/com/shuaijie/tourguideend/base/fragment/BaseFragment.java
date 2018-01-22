package com.shuaijie.tourguideend.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuaijie.tourguideend.utils.Gson;

import java.lang.reflect.Type;

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

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutResouceId(), container, false);

        initData(getArguments());

        initView();

        mIsPrepare = true;

        onLazyLoad();

        setListener();

        return mRootView;
    }

    /**
     * 初始化数据
     *
     * @param arguments 接收到的从其他地方传递过来的参数
     */
    protected abstract void initData(Bundle arguments);

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 设置监听事件
     */
    protected abstract void setListener();

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
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     */
    protected abstract void onLazyLoad();

    /*
     * 查找控件的方法
     */
    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }

        return (T) mRootView.findViewById(id);
    }

    /**
     * 设置根布局资源id
     */
    protected abstract int getLayoutResouceId();

    /*
     * 这是跳转的方法，只跳转
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /*
     * 这是携带数据的跳转
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /*
     * 带跳回的方法
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    /*
     * 带回跳的并且携带数据的跳转
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public String toJson(Object o) {
        return Gson.toJson(o);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return Gson.fromJson(json, typeOfT);
    }
}