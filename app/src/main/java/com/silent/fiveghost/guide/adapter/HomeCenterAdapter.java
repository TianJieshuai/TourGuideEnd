package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 张鑫雨 on 2018/2/1 0001.
 */

public class HomeCenterAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private Context context;

    public HomeCenterAdapter(FragmentManager fm, ArrayList<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }
}
