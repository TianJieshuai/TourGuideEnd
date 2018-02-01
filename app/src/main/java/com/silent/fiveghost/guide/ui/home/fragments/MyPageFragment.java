package com.silent.fiveghost.guide.ui.home.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.personalcenter.MyRouteActivity;
import com.silent.fiveghost.guide.ui.personalcenter.MySettingActivity;
import com.silent.fiveghost.guide.ui.home.adapters.PersonalAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends BaseFragment implements View.OnClickListener {

    private com.zhy.autolayout.AutoRelativeLayout mSetting;
    private com.zhy.autolayout.AutoRelativeLayout mRoute;
    private RecyclerView mPersion_recyc;

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
        mPersion_recyc =(RecyclerView) findViewById(R.id.mPersion_recyc);
        mRoute.setOnClickListener(this);
mSetting.setOnClickListener(this);
        mPersion_recyc.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        PersonalAdapter adapter = new PersonalAdapter(getActivity());
        mPersion_recyc.setAdapter(adapter);
        adapter.setOnClickListener(new PersonalAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
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
