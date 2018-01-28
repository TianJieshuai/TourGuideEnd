package com.shuaijie.tourguideend.db.factor;

import android.content.Context;

import com.shuaijie.tourguideend.db.product.IOpenHelper;
import com.shuaijie.tourguideend.http.httprequest.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/26
 */

public interface DatabaseCreat {
    <T extends HttpRequest> IOpenHelper conCreate(Context context, Class<T> clz);
}
