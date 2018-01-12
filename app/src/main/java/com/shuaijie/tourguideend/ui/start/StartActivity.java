package com.shuaijie.tourguideend.ui.start;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RelativeLayout;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.ui.welcom.WelcomActivity;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.ui.login.LoginActivity;
import com.shuaijie.tourguideend.utils.PrefUtils;

public class StartActivity extends BaseActivity {
    private Handler handler = new Handler();
    private RelativeLayout rlSplash;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_splash);
        jumpNextPage();
    }

    @Override
    protected void run() {

    }

    protected void initView() {

    }

    private void jumpNextPage() {

        // 判断之前有没有展示过功能引导页
        boolean guideShowed = PrefUtils.getBoolean(StartActivity.this,
                PrefUtils.GUIDE_SHOWED, false);
        Log.e("TAG", "" + guideShowed);
        // 如果没有展示过功能引导页
        if (!guideShowed) {
            // 跳转到功能引导页
            startActivity(new Intent(StartActivity.this, WelcomActivity.class));
        } else {
            rlSplash = (RelativeLayout) findViewById(R.id.rl_splash);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                }
            }, 2000);
        }
        finish();
    }

}
