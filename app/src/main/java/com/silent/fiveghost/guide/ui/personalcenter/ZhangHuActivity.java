package com.silent.fiveghost.guide.ui.personalcenter;

import android.content.Intent;
import android.view.View;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

public class ZhangHuActivity extends BaseActivity implements View.OnClickListener {


    private AutoLinearLayout shoujihao;
    private AutoLinearLayout xiugaimima;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_zhang_hu);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
        shoujihao = (com.zhy.autolayout.AutoLinearLayout) findViewById(R.id.shoujihao);
        xiugaimima = (com.zhy.autolayout.AutoLinearLayout) findViewById(R.id.xiugaimima);
        shoujihao.setOnClickListener(this);
        xiugaimima.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shoujihao:
                startActivity(new Intent(this,ShouJiHaoActivity.class));
                break;
            case R.id.xiugaimima:
                startActivity(new Intent(this,XgMiMaActivity.class));
                break;
        }
    }
}
