package com.silent.fiveghost.guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.beans.DateBeans;

import java.util.ArrayList;

/**
 * 认真的人到最后都是难过 2018/1/31.
 */

public class DateRecAdapter extends RecyclerView.Adapter<DateRecAdapter.ViewHolder> {
    private ArrayList<DateBeans> dateBeans;
    private Context context;


    public DateRecAdapter(ArrayList<DateBeans> dateBeans) {
        this.dateBeans = dateBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.daterecitem, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_renminbi_ripi_one.setText(dateBeans.get(position).getMoney());
        holder.tv_riqi_one.setText(dateBeans.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dateBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_riqi_one;
        TextView tv_renminbi_ripi_one;
        public ViewHolder(View itemView) {
            super(itemView);
             tv_riqi_one = itemView.findViewById(R.id.tv_riqi_one);
            tv_renminbi_ripi_one = itemView.findViewById(R.id.tv_renminbi_ripi_one);
        }
    }
}
