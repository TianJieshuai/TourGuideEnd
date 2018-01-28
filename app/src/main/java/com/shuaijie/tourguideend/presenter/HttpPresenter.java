package com.shuaijie.tourguideend.presenter;

import com.shuaijie.tourguideend.event.DataEvent;
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
    public void getData(DataEvent event) {
        /*
         * 数据事件
         */
        model.sendPost(event.getUrl(), event.getMap(), event.getCallBack());
    }
}
