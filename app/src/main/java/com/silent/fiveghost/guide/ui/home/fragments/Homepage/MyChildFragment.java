package com.silent.fiveghost.guide.ui.home.fragments.Homepage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.TouristReservationActivity;
import com.silent.fiveghost.guide.ui.home.adapters.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyChildFragment extends BaseFragment {

    private ListView lv_home;
    private static final String[] strs = new String[]{
            "first", "second", "third", "fourth", "fifth"
    };
    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_my_child);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
        lv_home=(ListView) findViewById(R.id.lv_home);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(),strs);
        lv_home.setAdapter(listViewAdapter);
        lv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getContext().startActivity(new Intent(getActivity(), TouristReservationActivity.class));
            }
        });
    }


}
