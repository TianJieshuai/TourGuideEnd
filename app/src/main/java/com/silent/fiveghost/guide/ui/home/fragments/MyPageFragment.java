package com.silent.fiveghost.guide.ui.home.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.PersonalAdapter;
import com.silent.fiveghost.guide.ui.personalcenter.CaiWuLiuShuiActivity;
import com.silent.fiveghost.guide.ui.personalcenter.Help_CenterActivity;
import com.silent.fiveghost.guide.ui.personalcenter.MyRouteActivity;
import com.silent.fiveghost.guide.ui.personalcenter.MySettingActivity;
import com.silent.fiveghost.guide.utils.AlphaChangeListener;
import com.silent.fiveghost.guide.utils.XScrollView;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends BaseFragment implements View.OnClickListener, AlphaChangeListener {

    private com.zhy.autolayout.AutoRelativeLayout mSetting;
    private com.zhy.autolayout.AutoRelativeLayout mRoute;
    private RecyclerView mPersion_recyc;
    private com.zhy.autolayout.AutoRelativeLayout help_center;
    private com.zhy.autolayout.AutoRelativeLayout cwls;
    private AutoRelativeLayout mPersion_toolbar;
    private XScrollView mPersonalScroll;
    private TextView mTitle1;
    private AutoRelativeLayout tp1;

    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_my_page);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {


        mSetting = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.mSetting);
        mPersonalScroll = (com.silent.fiveghost.guide.utils.XScrollView) findViewById(R.id.mPersonalScroll);
        mTitle1 = (TextView) findViewById(R.id.mTitle1);
        tp1 = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.tp1);
        mPersion_toolbar = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.mPersion_toolbar);
        mRoute = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.mRoute);
        help_center = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.help_center);
        cwls = (com.zhy.autolayout.AutoRelativeLayout) findViewById(R.id.cwls);
        mPersion_recyc = (RecyclerView) findViewById(R.id.mPersion_recyc);
        mPersion_toolbar.setVisibility(View.GONE);
        mPersonalScroll.setAlphaChangeListener(this);
        mRoute.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        cwls.setOnClickListener(this);
        help_center.setOnClickListener(this);
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
        switch (view.getId()) {
            case R.id.mSetting:
                getContext().startActivity(new Intent(getActivity(), MySettingActivity.class));
                break;
            case R.id.mRoute:
                getContext().startActivity(new Intent(getActivity(), MyRouteActivity.class));
                break;
            case R.id.help_center:
                getContext().startActivity(new Intent(getActivity(), Help_CenterActivity.class));
                break;
            case R.id.cwls:
                getContext().startActivity(new Intent(getActivity(), CaiWuLiuShuiActivity.class));
                break;
        }
    }

    @Override
    public void alphaChanging(float alpha) {

        mPersion_toolbar.setVisibility(View.VISIBLE);
        float s = (1 - alpha) * 1;
        if (s > 1) {
            s = 1;

            mTitle1.setVisibility(View.GONE);
            tp1.setVisibility(View.GONE);
        }
        else {
            mTitle1.setVisibility(View.VISIBLE);
            tp1.setVisibility(View.VISIBLE);
        }
        mPersion_toolbar.setAlpha(s);

    }
}
