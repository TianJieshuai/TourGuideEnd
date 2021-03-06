package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.details_robbing.Details_RobbingActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by lenovo on 2018/1/29.
 */

public class Rou_Adapter extends   RecyclerView.Adapter<Rou_Adapter.ViewHolder>  {
    private List<String> list;
    private Context context;
    public Rou_Adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rou_recy, parent, false);
       ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.name.setText(list.get(position));
            holder.vv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, Details_RobbingActivity.class));
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView name;
        private  View vv;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            vv = itemView;
            name = itemView.findViewById(R.id.rou_name);

        }
    }
}
