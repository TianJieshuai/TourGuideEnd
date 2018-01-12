package com.shuaijie.tourguideend.http.factorys;

import android.content.Context;

import com.shuaijie.tourguideend.http.products.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/22
 *          抽象工厂中的抽象工厂
 */

public interface HttpFactorys {
    <T extends HttpRequest> HttpRequest conCreate(Context context, Class<T> clz);


}
