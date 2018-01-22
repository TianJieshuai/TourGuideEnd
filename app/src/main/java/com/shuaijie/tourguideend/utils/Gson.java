package com.shuaijie.tourguideend.utils;

import java.lang.reflect.Type;

/**
 * Created by shuaiJie on 2018/1/3.
 */

public class Gson {
    private static com.google.gson.Gson gson;

    private Gson() {
    }

    private static com.google.gson.Gson getGson() {
        if (gson == null) synchronized (Gson.class) {
            if (gson == null) gson = new com.google.gson.Gson();
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
