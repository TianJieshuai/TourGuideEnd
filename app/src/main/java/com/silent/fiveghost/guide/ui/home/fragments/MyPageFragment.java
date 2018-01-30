package com.silent.fiveghost.guide.ui.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends BaseFragment {


    public MyPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void run() {

    }

}
