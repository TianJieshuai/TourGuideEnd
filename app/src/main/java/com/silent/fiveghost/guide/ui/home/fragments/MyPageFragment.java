package com.silent.fiveghost.guide.ui.home.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.MyRouteActivity;
import com.silent.fiveghost.guide.ui.home.MySettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends BaseFragment implements View.OnClickListener {

    private com.zhy.autolayout.AutoRelativeLayout mSetting;
    private com.zhy.autolayout.AutoRelativeLayout mRoute;

    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_my_page);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
        mSetting  =  (com.zhy.autolayout.AutoRelativeLayout)findViewById(R.id.mSetting);
        mRoute  = (com.zhy.autolayout.AutoRelativeLayout)findViewById(R.id.mRoute);
        mRoute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mSetting:
                getContext().startActivity(new Intent(getActivity(), MySettingActivity.class));
                break;
            case R.id.mRoute:
                getContext().startActivity(new Intent(getActivity(), MyRouteActivity.class));
                break;
        }
    }
}
