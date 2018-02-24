package com.silent.fiveghost.guide.model;

import com.silent.fiveghost.guide.http.httpapis.CallBack;
import com.silent.fiveghost.guide.http.httpfactor.HttpFactor;
import com.silent.fiveghost.guide.http.httprequest.RetrofitHttpRequest;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import okhttp3.RequestBody;

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

    public void up(String url, Map<String, RequestBody> files, CallBack callBack) {
        HttpFactor.getInstance().create(RetrofitHttpRequest.class).up(null, url, files, callBack);
    }
}
