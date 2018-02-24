package com.silent.fiveghost.guide.http.httprequest;

import android.content.Context;
import android.text.TextUtils;

import com.silent.fiveghost.guide.http.httpapis.CallBack;
import com.silent.fiveghost.guide.http.httpapis.NewsApi;
import com.silent.fiveghost.guide.http.httputils.RetrofitUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;

import static com.silent.fiveghost.guide.utils.GsonUtils.fromJson;
import static com.silent.fiveghost.guide.utils.TypeUtils.getType;


/**
 * Created by shuaiJie on 2017/9/21.
 */

public class RetrofitHttpRequest<T> implements HttpRequest<T> {

    /**
     * @param context  上下文
     * @param url      网路地址
     * @param map      提交的键值对
     * @param callBack 回调监听
     */
    @Override
    public void sendGet(final Context context, String url, Map<String, String> map, final CallBack<T> callBack) {
        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException("url=\"" + url + "\"");
        }
        /**
         * 使用RetrofitUtils的create方法创建api接口对象
         */
        NewsApi newsApi = RetrofitUtils.getInstance().create(NewsApi.class);

        /**
         * 使用api接口对象发送网络请求 返回被观察者
         */
        Observable<ResponseBody> observable = newsApi.sendGet(url, map);

        /**
         * 配置被观察者
         */
        disposeObservable(observable, callBack);

    }

    /**
     * 无键值对Get请求
     *
     * @param context  上下文
     * @param url      网路地址
     * @param callBack 回调监听
     */
    @Override
    public void sendGet(Context context, String url, final CallBack<T> callBack) {
        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException("url=\"" + url + "\"");
        }
        /**
         * 使用RetrofitUtils的create方法创建api接口对象
         */
        NewsApi newsApi = RetrofitUtils.getInstance().create(NewsApi.class);

        /**
         * 使用api接口对象发送网络请求 返回被观察者
         */
        Observable<ResponseBody> observable = newsApi.sendGet(url);

        /**
         * 配置被观察者
         */
        disposeObservable(observable, callBack);
    }

    /**
     * @param context  上下文
     * @param url      网路地址
     * @param map      提交的键值对
     * @param callBack 回调监听
     */
    @Override
    public void sendPost(final Context context, String url, Map<String, String> map, final CallBack<T> callBack) {
        if (TextUtils.isEmpty(url) || map == null || map.size() == 0) {
            throw new NullPointerException("url=\"" + url + "\" map = null Or map.size() = 0");
        }
        /**
         * 使用RetrofitUtils的create方法创建api接口对象
         */
        NewsApi newsApi = RetrofitUtils.getInstance().create(NewsApi.class);

        /**
         * 使用api接口对象发送网络请求 返回被观察者
         */
        Observable<ResponseBody> observable = newsApi.sendPost(url, map);

        /**
         * 配置被观察者
         */
        disposeObservable(observable, callBack);
    }

    @Override
    public void up(Context context, String url, List<MultipartBody.Part> files, final CallBack<T> callBack) {
        if (TextUtils.isEmpty(url) || files == null || files.size() == 0) {
            throw new NullPointerException("url=\"" + url + "\" map = null Or map.size() = 0");
        }

        /**
         * 使用RetrofitUtils的create方法创建api接口对象
         */
        NewsApi newsApi = RetrofitUtils.getInstance().create(NewsApi.class);

        /**
         * 使用api接口对象发送网络请求 返回被观察者
         */
        Observable<ResponseBody> observable = newsApi.up(url, files);

        /**
         * 配置被观察者
         */
        disposeObservable(observable, callBack);
    }

    /**
     * 配置被观察者
     */
    private void disposeObservable(Observable<ResponseBody> observable, final CallBack<T> callBack) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            callBack.onSuccess((T) fromJson(string, getType(callBack)));
                        } catch (IOException e) {
                            callBack.onFailure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
