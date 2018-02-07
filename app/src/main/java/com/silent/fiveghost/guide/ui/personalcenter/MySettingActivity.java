package com.silent.fiveghost.guide.ui.personalcenter;

import android.content.Intent;
import android.view.View;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class MySettingActivity extends BaseActivity implements View.OnClickListener {


    private com.zhy.autolayout.AutoRelativeLayout relat;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_my_setting);
        setSteepStatusBar(true);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
        relat = (com.zhy.autolayout.AutoRelativeLayout)findViewById(R.id.relat);
        relat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.relat:
                startActivity(new Intent(this,ZhangHuActivity.class));
                break;
        }
    }
}
