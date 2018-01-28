package com.shuaijie.tourguideend.presenter;

import com.shuaijie.tourguideend.event.LoginEvent;
import com.shuaijie.tourguideend.event.RegisterEvent;
import com.shuaijie.tourguideend.model.HttpModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * 认真的人到最后都是难过 2017/12/21.
 */

public class HttpPresenter {
    public HttpPresenter() {
        DaggerHttpComponent.create().inject(this);
    }

    @Inject
    protected HttpModel model;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void login(LoginEvent event) {
        /*
         * 登录事件
         */
        model.sendPost(event.getUrl(), event.getMap(), event.getCallBack());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void register(RegisterEvent event) {
        /*
         * 注册事件
         */
        model.sendPost(event.getUrl(), event.getMap(), event.getCallBack());
    }
}
