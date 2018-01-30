package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
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
 * Created by 习爸爸 on 2018/1/28.
 */
public class ListViewAdapter extends BaseAdapter {
    FragmentActivity activity;
    String[] strs;
    Context context;

    public ListViewAdapter(FragmentActivity activity, String[] strs) {
        this.context = activity;
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

        ViewHolder holder;
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.main, parent,false);
            holder = new ViewHolder();
//            holder.id = (TextView)convertView.findViewById(R.id.id);
//            holder.name = (TextView)convertView.findViewById(R.id.name);
//            holder.age = (TextView)convertView.findViewById(R.id.age);
            convertView.setTag(holder);

            AutoUtils.autoSize(convertView);
        }else{
            holder = (ViewHolder)convertView.getTag();
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
     *
     */
    private static class ViewHolder{
        private TextView id;
        private TextView name;
        private TextView age;
    }
}