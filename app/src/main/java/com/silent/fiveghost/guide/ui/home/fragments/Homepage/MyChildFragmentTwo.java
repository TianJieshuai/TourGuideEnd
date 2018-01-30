package com.silent.fiveghost.guide.ui.home.fragments.Homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyChildFragmentTwo extends BaseFragment {

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
    }
}
