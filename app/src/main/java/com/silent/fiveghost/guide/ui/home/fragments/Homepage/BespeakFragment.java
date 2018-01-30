package com.silent.fiveghost.guide.ui.home.fragments.Homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.guide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BespeakFragment extends Fragment {


    public BespeakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bespeak, container, false);
    }

}
