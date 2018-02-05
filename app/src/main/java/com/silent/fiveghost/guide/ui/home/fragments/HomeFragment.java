package com.silent.fiveghost.guide.ui.home.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.HomeCenterAdapter;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragmentTwo;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TextView tv_travel;
    private TextView tv_passenger;
    private ViewPager mViewPager;
    private ArrayList<Fragment> list;
    private HomeCenterAdapter adapter;



    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_homepage);
    }

    @Override
    protected void run() {


    }
    @Override
    protected void initView() {
        tv_travel = (TextView) findViewById(R.id.tv_travel);
        tv_passenger = (TextView) findViewById(R.id.tv_passenger);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        tv_passenger.setOnClickListener(this);
        tv_travel.setOnClickListener(this);
        list = new ArrayList<>();
        list.add(new MyChildFragment());
        list.add(new MyChildFragmentTwo());
        adapter = new HomeCenterAdapter(getActivity().getSupportFragmentManager(), list, getContext());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        initTravel();
                        break;
                    case 1:
                        initPassenger();
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

        @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_passenger:
                initTravel();
                break;
            case R.id.tv_travel:
                initPassenger();
                break;
        }
    }

    private void initTravel() {
        mViewPager.setCurrentItem(0);
        tv_passenger.setBackgroundColor(0xff232730);
        tv_passenger.setTextColor(0xff00cd96);
        tv_travel.setBackgroundColor(0xffffffff);
        tv_travel.setTextColor(0xff424242);
    }

    private void initPassenger() {
        mViewPager.setCurrentItem(1);
        tv_travel.setBackgroundColor(0xff232730);
        tv_travel.setTextColor(0xff00cd96);
        tv_passenger.setBackgroundColor(0xffffffff);
        tv_passenger.setTextColor(0xff424242);
    }


}
