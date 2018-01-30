package com.silent.fiveghost.guide.ui.home.fragments.robsingle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RobSingleFragment extends BaseFragment implements View.OnClickListener {


    private TextView title_xml;
    private RadioButton travel_lv_xml;
    private RadioButton tourist_you_xml;
    private RadioButton rob_qiang_xml;
    private FrameLayout single_fragment;


    public RobSingleFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_rob_single);
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        title_xml = (TextView) findViewById(R.id.title_xml);
        title_xml.setText("抢单");

        travel_lv_xml = (RadioButton) findViewById(R.id.travel_lv_xml);
        AutoUtils.autoSize(travel_lv_xml);
        travel_lv_xml.setOnClickListener(this);
        tourist_you_xml = (RadioButton) findViewById(R.id.tourist_you_xml);
        AutoUtils.autoSize(tourist_you_xml);
        tourist_you_xml.setOnClickListener(this);
        rob_qiang_xml = (RadioButton) findViewById(R.id.rob_qiang_xml);
        AutoUtils.autoSize(rob_qiang_xml);
        rob_qiang_xml.setOnClickListener(this);

        single_fragment = (FrameLayout) findViewById(R.id.single_fragment);
        onClick(travel_lv_xml);
    }

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment like bottom ... and run LayoutCreator again
//        View view = View.inflate(getActivity(), R.layout.fragment_rob_single, null);
//
//        initView(view);
//        return view;
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.travel_lv_xml:
                replaceFragment(new travelFragment().getTravelFragment("1"));
                break;
            case R.id.tourist_you_xml:
                replaceFragment(new travelFragment().getTravelFragment("1"));
                break;
            case R.id.rob_qiang_xml:
                replaceFragment(new robFragment().getRobFragment("1"));
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.single_fragment, fragment);
        ft.commit();

    }




}
