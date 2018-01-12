package com.shuaijie.tourguideend.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by shuaiJie on 2018/1/3.
 */

public class GsonUtils {
    private static Gson gson;

    private GsonUtils() {
    }

    private static Gson getGson() {
        if (gson == null) synchronized (GsonUtils.class) {
            if (gson == null) gson = new Gson();
        }
        return gson;
    }

    public static String toJson(Object o) {
        return getGson().toJson(o);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return getGson().fromJson(json, typeOfT);
    }
}
