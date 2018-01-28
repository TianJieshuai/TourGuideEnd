package com.shuaijie.tourguideend.db.factor;

import android.content.Context;

import com.shuaijie.tourguideend.db.product.IOpenHelper;
import com.shuaijie.tourguideend.http.httprequest.HttpRequest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 农民伯伯
 * @version 2017/12/26
 */

public class DatabaseConCreate implements DatabaseCreat {
    @Override
    public <T extends HttpRequest> IOpenHelper conCreate(Context context, Class<T> clz) {

        try {
            Constructor<T> constructor = clz.getConstructor(String.class,
                    int.class);
            T t = constructor.newInstance(context, clz);
            return (IOpenHelper) t;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;

        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;

        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }

    }
}
