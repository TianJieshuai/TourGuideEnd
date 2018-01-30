package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.silent.fiveghost.guide.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by lenovo on 2018/1/29.
 */

public class travel_Adapter extends RecyclerView.Adapter<travel_Adapter.ViewHolder> {
    private List<String> list;
    private Context context;
    public travel_Adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.robsingle_recy, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
                holder.time.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView time;

        public ViewHolder(View itemView) {

            super(itemView);
            AutoUtils.autoSize(itemView);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
}
