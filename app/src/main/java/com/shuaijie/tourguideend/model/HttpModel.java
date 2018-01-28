package com.shuaijie.tourguideend.model;

import com.shuaijie.tourguideend.http.httpapis.CallBack;
import com.shuaijie.tourguideend.http.httpfactor.HttpFactor;
import com.shuaijie.tourguideend.http.httprequest.RetrofitHttpRequest;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;

/**
 * 网络层
 */

@Singleton
@Module
public class HttpModel {
    @Inject
    public HttpModel() {
    }

    public void sendGet(String url, CallBack callBack) {
        HttpFactor.getInstance().create(RetrofitHttpRequest.class).sendGet(null, url, callBack);
    }

    public void sendGet(String url, Map<String, String> map, CallBack callBack) {
        HttpFactor.getInstance().create(RetrofitHttpRequest.class).sendGet(null, url, map, callBack);
    }

    public void sendPost(String url, Map<String, String> map, CallBack callBack) {
        HttpFactor.getInstance().create(RetrofitHttpRequest.class).sendPost(null, url, map, callBack);
    }
}
