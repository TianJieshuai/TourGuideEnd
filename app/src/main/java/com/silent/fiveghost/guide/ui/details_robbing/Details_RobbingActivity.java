package com.silent.fiveghost.guide.ui.details_robbing;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 路线详情
 */
public class Details_RobbingActivity extends BaseActivity implements OnBannerListener, View.OnClickListener {

    private TextView robbing_toolbar;
    private Banner banner;
    private LinearLayout isTheme;
    private Button submit;

    protected void initView() {
        robbing_toolbar = (TextView) findViewById(R.id.robbing_toolbar);
        isTheme = findViewById(R.id.isTheme);
        robbing_toolbar.setText("详情");
        submit = findViewById(R.id.submit);
        boolean isThere = getIntent().getBooleanExtra("IsThere", false);
        if (isThere) {
            submit.setVisibility(View.GONE);
            isTheme.setVisibility(View.VISIBLE);
        }
        banner = findViewById(R.id.detailsrobbing_banner);

    }

    @Override
    protected void init() {
        addBodyView(R.layout.activity_details__robbing);
    }

    @Override
    protected void run() {
        initNetBanner();
    }


    private void initNetBanner() {
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("https://upload-images.jianshu.io/upload_images/2909883-9ee6e59600664dc2.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/700");
        imgesUrl.add("https://upload-images.jianshu.io/upload_images/1217754-c67cdc6cdf97c9f3?imageMogr2/auto-orient/");
        imgesUrl.add("https://upload-images.jianshu.io/upload_images/1217754-1f881ace95103fa8?imageMogr2/auto-orient/strip%7CimageView2/2/w/700");
        banner.setImages(imgesUrl)
                .setImageLoader(new myLoader())
                .setDelayTime(3000)
                .isAutoPlay(true)
                .setOnBannerListener(this)
                .start();
    }


    @Override
    public void OnBannerClick(int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "第一条", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(this, "第二条", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "第三条", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish_toolbar:
                finish();
                break;
        }
    }

    //轮播图图片加载器
    private class myLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }


}