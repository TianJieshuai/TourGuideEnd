package com.shuaijie.tourguideend.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.ui.Zxing.ZxingActivity;
import com.shuaijie.tourguideend.base.activity.BaseActivity;


public class HomeActivity extends BaseActivity implements View.OnClickListener {


    private Button bu_main;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_main);
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        bu_main = (Button) findViewById(R.id.bu_main);

        bu_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_main:
                startActivity(new Intent(this, ZxingActivity.class));
                break;
        }
    }
}
