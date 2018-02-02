package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.personalcenter.ReleaseRouteActivity;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * -------- This is 羊驼! -------
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * Created by 习爸爸 on 2018/1/31.
 */
public class MyAdapter extends BaseAdapter {

    String[] strs;
    Context context;

    public MyAdapter(ReleaseRouteActivity releaseRouteActivity, String[] strs) {
        this.context = releaseRouteActivity;
        this.strs = strs;
    }


    @Override
    public int getCount() {
        return strs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyAdapter.ViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.rotedetails_recycler_item, parent, false);
            holder = new MyAdapter.ViewHolder();
//            holder.id = (TextView)convertView.findViewById(R.id.id);
//            holder.name = (TextView)convertView.findViewById(R.id.name);
//            holder.age = (TextView)convertView.findViewById(R.id.age);
            convertView.setTag(holder);

            AutoUtils.autoSize(convertView);
        } else {
            holder = (MyAdapter.ViewHolder) convertView.getTag();
        }
//        holder.id.setText(strs.length);
//        holder.name.setText(strs.length);
//        holder.age.setText(strs.length);
        return convertView;
    }

    /**
     * 界面上的显示控件
     *
     * @author jiqinlin
     */
    private static class ViewHolder {

    }
}
