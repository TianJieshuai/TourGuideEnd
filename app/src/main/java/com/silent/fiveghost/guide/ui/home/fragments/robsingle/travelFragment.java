package com.silent.fiveghost.guide.ui.home.fragments.robsingle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.travel_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class travelFragment extends BaseFragment {


    private RecyclerView travel_fragmentxml;

    public travelFragment() {
        // Required empty public constructor
    }

    public String url;

    public travelFragment getTravelFragment(String url) {
        this.url = url;
        return this;
    }

    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_travel);
    }

    @Override
    protected void run() {

    }
    protected void initView() {
        travel_fragmentxml = (RecyclerView) findViewById(R.id.travel_fragmentxml);
        List<String> list=new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
                list.add("昆仑山"+i);
        }
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
         travel_fragmentxml.setLayoutManager(lm);
        travel_fragmentxml.setAdapter(new travel_Adapter(list,getActivity()));
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View inflate = inflater.inflate(R.layout.fragment_travel, container, false);
//        initView(inflate);
//        return inflate;
//    }


}

