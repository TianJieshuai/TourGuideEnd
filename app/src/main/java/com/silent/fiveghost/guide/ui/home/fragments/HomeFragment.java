package com.silent.fiveghost.guide.ui.home.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragmentTwo;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TextView tv_travel;
    private TextView tv_passenger;
    private MyChildFragment myChildFragment = new MyChildFragment();
    private MyChildFragmentTwo myChildFragmentTwo = new MyChildFragmentTwo();
    private FragmentManager manager;


    @Override
    protected void initData(Bundle arguments) {
        manager = getFragmentManager();
        addBodyView(R.layout.fragment_homepage);
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        tv_travel = (TextView) findViewById(R.id.tv_travel);
        tv_passenger = (TextView) findViewById(R.id.tv_passenger);

        //动态添加Fragment ,获取Fragment 管理器
        //开启Fragment事物
        tv_passenger.postDelayed(new Runnable() {
            @Override
            public void run() {
                onClick(tv_passenger);
            }
        }, 500);

        tv_passenger.setOnClickListener(this);
        tv_travel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = manager.beginTransaction();
//        hideAll(transaction);
        switch (view.getId()) {
            case R.id.tv_passenger:
                tv_passenger.setBackgroundColor(0xff232730);
                tv_passenger.setTextColor(0xff00cd96);
                tv_travel.setBackgroundColor(0xffffffff);
                tv_travel.setTextColor(0xff424242);
                transaction.replace(R.id.mFragment, myChildFragment).commit();
                break;
            case R.id.tv_travel:
                tv_travel.setBackgroundColor(0xff232730);
                tv_travel.setTextColor(0xff00cd96);
                tv_passenger.setBackgroundColor(0xffffffff);
                tv_passenger.setTextColor(0xff424242);
                transaction.replace(R.id.mFragment, myChildFragmentTwo).commit();
                break;
        }

    }

    private void hideAll(FragmentTransaction transaction) {
        if (myChildFragment != null) {
            transaction.hide(myChildFragment);
        }
        if (myChildFragmentTwo != null) {
            transaction.hide(myChildFragmentTwo);
        }
    }
}
