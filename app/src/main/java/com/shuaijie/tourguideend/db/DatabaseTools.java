package com.shuaijie.tourguideend.db;

import android.content.Context;

import com.shuaijie.tourguideend.db.product.MyOpenHelper;

/**
 * @author 农民伯伯
 * @version 2017/12/23
 */

public class DatabaseTools {
    private static MyOpenHelper mHelper;

    private DatabaseTools() {
    }

    public static void initHelper(Context context, String name) {
        if (mHelper == null) {
            mHelper = new MyOpenHelper(context, name);
        }
    }

    public static MyOpenHelper getHelper() {
        if (mHelper == null) {
            new RuntimeException("MyOpenHelper is null,No init it");
        }
        return mHelper;
    }
}
