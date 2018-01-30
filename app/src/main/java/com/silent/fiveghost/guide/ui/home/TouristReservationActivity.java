package com.silent.fiveghost.guide.ui.home;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.AgressFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.BespeakFragment;

public class TouristReservationActivity extends BaseActivity implements View.OnClickListener {


    private TextView agree_text;
    private TextView bespeak_text;
    private FrameLayout mFrameLayout;
    private BespeakFragment mBespeakFragment;
    private AgressFragment mAgressFragment;
    private FragmentTransaction msg;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_tourist_reservation);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
        agree_text = (TextView)findViewById(R.id.agree_text);
        bespeak_text = (TextView)findViewById(R.id.bespeak_text);
        mFrameLayout = (FrameLayout)findViewById(R.id.mFrameLayout);
        agree_text.setOnClickListener(this);
        bespeak_text.setOnClickListener(this);
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager(). beginTransaction();
        //开启Fragment事物
        mBespeakFragment = new BespeakFragment();
        msg.add(R.id.mFrameLayout, mBespeakFragment);
        msg.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAll(transaction);
        switch (view.getId()) {
            case R.id.agree_text:
                agree_text.setTextColor(0xff00cd96);
                bespeak_text.setTextColor(0xffffffff);
                if(mBespeakFragment == null){
                    mBespeakFragment = new BespeakFragment();
                    transaction.add(R.id.mFrameLayout,mBespeakFragment);
                }
                transaction.show(mBespeakFragment);
                transaction.commit();
                break;
            case R.id.bespeak_text:
                bespeak_text.setTextColor(0xff00cd96);
                agree_text.setTextColor(0xffffffff);
                if(mAgressFragment == null){
                    mAgressFragment = new AgressFragment();
                    transaction.add(R.id.mFrameLayout,mAgressFragment);
                }
                transaction.show(mAgressFragment);
                transaction.commit();
                break;
        }

    }
    private void hideAll(FragmentTransaction transaction) {
        if (mBespeakFragment != null) {
            transaction.hide(mBespeakFragment);
        }
        if (mAgressFragment != null) {
            transaction.hide(mAgressFragment);
        }
    }
}

