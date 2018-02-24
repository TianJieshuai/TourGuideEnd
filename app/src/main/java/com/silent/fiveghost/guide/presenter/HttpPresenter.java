package com.silent.fiveghost.guide.presenter;

import com.silent.fiveghost.guide.event.GetDataEvent;
import com.silent.fiveghost.guide.event.PostDataEvent;
import com.silent.fiveghost.guide.event.UpDataEvent;
import com.silent.fiveghost.guide.model.HttpModel;

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
        model.sendPost(event.getUrl(), event.getMap(), event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(GetDataEvent event) {
        /*
         * Get数据事件
         */
        if (event.getMap() != null)
            model.sendGet(event.getUrl(), event.getMap(), event);
        else
            model.sendGet(event.getUrl(), event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void up(UpDataEvent event) {
        /*
         * 上传事件
         */
        model.up(event.getUrl(), event.getFiles(), event);
    }
}
