package com.silent.fiveghost.guide.ui.route_details;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.home.adapters.Details_Adapter;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DetailsRoute extends BaseActivity implements OnBannerListener {

    private RecyclerView detailsRoute_recyxml;
    private ScrollView scroll_details;
    private Banner banner;


    protected void initView() {
        detailsRoute_recyxml = (RecyclerView) findViewById(R.id.detailsRoute_recyxml);
        banner = findViewById(R.id.details_banner);
    }

    @Override
    protected void init() {
        addBodyView(R.layout.activity_details_route);
    }

    @Override
    protected void run() {
        initNetBanner();
        initListview();
        //警高：scrollTo 在run方法最后一行运行
        scroll_details.smoothScrollTo(0, 100);
    }

    // ListView 条目数据初始化
    private void initListview() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1000" + i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailsRoute_recyxml.setLayoutManager(linearLayoutManager);

        Details_Adapter details_adapter = new Details_Adapter(this, list);
        detailsRoute_recyxml.setAdapter(details_adapter);
        scroll_details = findViewById(R.id.scroll_details);
    }


    // 轮播图的操作
    private void initNetBanner() {
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("http://img4.imgtn.bdimg.com/it/u=1381275758,221092922&fm=27&gp=0.jpg");
        imgesUrl.add("http://img2.imgtn.bdimg.com/it/u=4190824348,796637354&fm=27&gp=0.jpg");
        imgesUrl.add("http://img2.imgtn.bdimg.com/it/u=2646737679,779098055&fm=27&gp=0.jpg");

        banner.setImages(imgesUrl)
                .setImageLoader(new MyLoader())
                .setDelayTime(3000)
                .isAutoPlay(true)
                .setOnBannerListener(this)
                .start();
    }
    //轮播图点击事件
    @Override
    public void OnBannerClick(int position) {
        switch (position){
            case 0:
                Toast.makeText(this, "第一条", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(this, "第一条", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "第一条", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
