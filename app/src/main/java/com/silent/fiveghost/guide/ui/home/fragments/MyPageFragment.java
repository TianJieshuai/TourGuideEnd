package com.silent.fiveghost.guide.ui.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.utils.CircularImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends BaseFragment {

    private CircularImageView user_icon;
    private TextView user_name;
    private TextView user_sex;
    private RecyclerView mPersion_recyc;
    private TextView my_route;
    private TextView my_SafetySetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(), R.layout.fragment_my_page, null);
        initView(view);
        return view;
    }
        @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void run() {

    }

    private void initView(View view) {
        user_icon = (CircularImageView) view.findViewById(R.id.user_icon);
        user_name = (TextView) view.findViewById(R.id.user_name);
        user_sex = (TextView) view.findViewById(R.id.user_sex);
        mPersion_recyc = (RecyclerView) view.findViewById(R.id.mPersion_recyc);
        my_route = (TextView) view.findViewById(R.id.my_route);
        my_SafetySetting = (TextView) view.findViewById(R.id.my_SafetySetting);
    }



}
