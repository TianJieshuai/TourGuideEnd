package com.silent.fiveghost.guide.ui.home.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.beans.HomeItemBean;
import com.silent.fiveghost.guide.ui.home.TouristReservationActivity;

import java.util.ArrayList;

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
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeItemBean> list = new ArrayList<>();

    public RecycleViewAdapter(Context context, ArrayList<HomeItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, final int position) {

        holder.tv_cityname.setText(list.get(position).getCityname());
        holder.tv_time.setText(list.get(position).getTime());
        holder.tv_love.setText(list.get(position).getLove());
        holder.tv_number.setText(list.get(position).getNumber());
        holder.tv_order_type.setText(list.get(position).getTv_order_type());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,TouristReservationActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView tv_cityname;
        TextView tv_time;
        TextView tv_number;
        TextView tv_love;
        TextView tv_order_type;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_cityname = itemView.findViewById(R.id.tv_cityname);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_number = itemView.findViewById(R.id.tv_number);
            tv_love = itemView.findViewById(R.id.tv_love);
            tv_order_type = itemView.findViewById(R.id.tv_order_type);

        }
    }
}

//Context context;
//    ArrayList<Bean.HotInfoBean> list;
//
//    public MyAdapter(Context context, ArrayList<Bean.HotInfoBean> list) {
//        this.context = context;
//        this.list = list;
//    }
//    @Override
//    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view=View.inflate(context,R.layout.item,null);
//        ViewHolder viewholder=new ViewHolder(view);
//        return viewholder;
//    }
//    @Override
//    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
//        Glide.with(context).load(list.get(position).getFigure()).error(R.mipmap.d5).into(holder.image);
//        holder.textview.setText(list.get(position).getCover_price());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = list.get(position).getName();
//                String price = list.get(position).getCover_price();
//                String image = list.get(position).getFigure();
//                Intent intent=new Intent(context,Main3Activity.class);
//                intent.putExtra("name",name);
//                intent.putExtra("price",price);
//                intent.putExtra("image",image);
//                context.startActivity(intent);
//            }
//        });
//    }
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView image;
//        TextView textview;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            image= (ImageView) itemView.findViewById(R.id.item_image);
//            textview= (TextView) itemView.findViewById(R.id.item_text);
//        }
//    }
