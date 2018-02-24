package com.silent.fiveghost.guide.http.httprequest;

import android.content.Context;

import com.silent.fiveghost.guide.http.httpapis.CallBack;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by shuaiJie on 2017/9/21.
 */

public interface HttpRequest<T> {
    /**
     * @param context  上下文
     * @param url      网路地址
     * @param map      提交的键值对
     * @param callBack 回调监听
     */
    void sendGet(Context context, String url, Map<String, String> map, CallBack<T> callBack);

    /**
     * @param context  上下文
     * @param url      网路地址
     * @param callBack 回调监听
     */
    void sendGet(Context context, String url, CallBack<T> callBack);

    /**
     * @param context  上下文
     * @param url      网路地址
     * @param map      提交的键值对
     * @param callBack 回调监听
     */
    void sendPost(Context context, String url, Map<String, String> map, CallBack<T> callBack);

    /**
     * 上传事件
     *
     * @param context  上下文
     * @param url      网路地址
     * @param files    文件
     * @param callBack 回调监听
     */
    void up(Context context, String url, Map<String, RequestBody> files, CallBack<T> callBack);
}
