package com.silent.fiveghost.guide.ui.start;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.RelativeLayout;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.application.App;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.login.LoginActivity;
import com.silent.fiveghost.guide.ui.welcom.WelcomActivity;
import com.silent.fiveghost.guide.utils.PrefUtils;

public class StartActivity extends BaseActivity {
    private RelativeLayout rlSplash;

    @SuppressLint("NewApi")
    @Override
    protected void init() {
        base.setBackground(getDrawable(R.mipmap.back));
        addBodyView(R.layout.activity_splash);
        jumpNextPage();
    }

    @Override
    protected void run() {

    }

    protected void initView() {

    }

    private void jumpNextPage() {
        App.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 判断之前有没有展示过功能引导页
                boolean guideShowed = PrefUtils.getBoolean(StartActivity.this,
                        PrefUtils.GUIDE_SHOWED, false);
                Log.e("TAG", "" + guideShowed);
                // 如果没有展示过功能引导页
                if (!guideShowed) {
                    // 跳转到功能引导页
                    startActivity(WelcomActivity.class);
                } else {
                    startActivity(LoginActivity.class);
                }
                finish();
            }
        }, 2000);

    }

}
