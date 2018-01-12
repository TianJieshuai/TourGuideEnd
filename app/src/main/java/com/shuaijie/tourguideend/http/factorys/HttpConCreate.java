package com.shuaijie.tourguideend.http.factorys;

import android.content.Context;
import android.util.Log;

import com.shuaijie.tourguideend.http.products.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/22
 *          抽象工厂中的具体工厂
 */

public class HttpConCreate implements HttpFactorys {

    @Override
    public <T extends HttpRequest> HttpRequest conCreate(Context context, Class<T> clz) {
        try {
            HttpRequest request = (HttpRequest) Class.forName(clz.getName()).newInstance();
            return request;
        } catch (InstantiationException e) {
            e.printStackTrace();
            Log.e("TAG", e.toString());
            return null;
        } catch (IllegalAccessException e) {
            Log.e("TAG", e.toString());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            Log.e("TAG", e.toString());
            e.printStackTrace();
            return null;

        }


    }
}
