package com.shuaijie.tourguideend.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by shuaiJie on 2018/1/6.
 */

public class VersionUtils {

    private static Context mContext;
    public static String VERSION_NAME;
    public static int VERSION_CODE;

    public static void init(Context context) {
        mContext = context;
        VERSION_NAME = getVersionName();
        VERSION_CODE = getVersionCode();
    }

    /*
     * 获取当前程序的版本名
     */
    private static String getVersionName() {
        try {
            //获取packagemanager的实例
            PackageManager packageManager = mContext.getPackageManager();
            //getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);

            Log.e("TAG", "版本号" + packInfo.versionCode);
            Log.e("TAG", "版本名" + packInfo.versionName);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "0";
        }
    }


    /*
     * 获取当前程序的版本号
     */
    private static int getVersionCode() {
        try {

            //获取packagemanager的实例
            PackageManager packageManager = mContext.getPackageManager();
            //getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            Log.e("TAG", "版本号" + packInfo.versionCode);
            Log.e("TAG", "版本名" + packInfo.versionName);
            return packInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            return 1;
        }
    }
}
