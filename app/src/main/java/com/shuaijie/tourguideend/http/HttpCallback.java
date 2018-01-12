package com.shuaijie.tourguideend.http;

/**
 * @author 农民伯伯
 * @version 2017/12/22
 */

public interface HttpCallback<T> {
    //成功回调
    void success(T t);

    //失败的回调
    void failure(Throwable e);
}
