package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.route_details.DetailsRoute;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by lenovo on 2018/1/28.
 */

public class Route_Adapter extends RecyclerView.Adapter<Route_Adapter.ViewHolder> {
    private Context context;
    private List<String> list;
    public Route_Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.route_recylaout, parent, false);

        ViewHolder viewHolder=new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.price.setText(list.get(position));

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailsRoute.class));


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView price;
        private  View vv;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            vv = itemView;
            price = itemView.findViewById(R.id.Price_xml);

        }
    }
}
