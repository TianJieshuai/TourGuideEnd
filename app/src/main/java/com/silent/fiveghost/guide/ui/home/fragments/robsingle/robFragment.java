package com.silent.fiveghost.guide.ui.home.fragments.robsingle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.Rou_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class robFragment extends BaseFragment {

    public String url;
    private RecyclerView rob_fragmentxml;

    public robFragment getRobFragment(String url) {
        this.url = url;
        return this;
    }


    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_rob);
    }

    @Override
    protected void run() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_rob, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rob_fragmentxml = (RecyclerView) inflate.findViewById(R.id.rob_fragmentxml);
        List<String> list=new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            list.add("昆仑山"+i);
        }
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rob_fragmentxml.setLayoutManager(lm);
        rob_fragmentxml.setAdapter(new Rou_Adapter(list,getActivity()));





    }
}
