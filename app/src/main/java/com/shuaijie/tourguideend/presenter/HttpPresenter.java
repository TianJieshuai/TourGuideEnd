package com.shuaijie.tourguideend.presenter;

import com.shuaijie.tourguideend.event.GetDataEvent;
import com.shuaijie.tourguideend.event.PostDataEvent;
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
    public void postData(PostDataEvent event) {
        /*
         * Post数据事件
         */
        model.sendPost(event.getUrl(), event.getMap(), event.getCallBack());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(GetDataEvent event) {
        /*
         * Get数据事件
         */
        if (event.getMap() != null)
            model.sendGet(event.getUrl(), event.getMap(), event.getCallBack());
        else
            model.sendGet(event.getUrl(), event.getCallBack());
    }
}
