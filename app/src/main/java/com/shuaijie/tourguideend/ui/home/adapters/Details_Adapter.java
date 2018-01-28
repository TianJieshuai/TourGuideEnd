package com.shuaijie.tourguideend.ui.home.adapters;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shuaijie.tourguideend.R;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by lenovo on 2018/1/28.
 */

public class Details_Adapter extends RecyclerView.Adapter<Details_Adapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public Details_Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.details_recylaout, parent, false);
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
            time = itemView.findViewById(R.id.time_xml);

        }
    }
}
