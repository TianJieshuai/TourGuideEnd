package com.shuaijie.tourguideend.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.shuaijie.tourguideend.event.EventRegister;
import com.shuaijie.tourguideend.utils.VersionUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by 韩学文 on 2017/12/25.
 * 花自飘零水自流。一种相思，两处闲愁。
 * 此情无计可消除，才下眉头，却上心头。
 */

public class App extends Application {

    private static App context;

    public static App getContext() {
        return context;
    }

    //底下的放置里面  微信的 QQ的
    static {
        //初始化事件总线
        EventRegister.init();
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    //对sdk进行初始化  开启DEBUG模式


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
        context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //登录注册
        UMShareAPI.get(this);
        Config.DEBUG = true;
        VersionUtils.init(this);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //消息推送
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("TAG", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
        //Bug收集
        CrashReport.initCrashReport(getApplicationContext(), "d7bf6471ca", false);

    }
}
