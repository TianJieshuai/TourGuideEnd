package com.silent.fiveghost.guide.ui.home.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.home.adapters.MyPagerAdapter;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragment;
import com.silent.fiveghost.guide.ui.home.fragments.Homepage.MyChildFragmentTwo;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TextView tv_travel;
    private TextView tv_passenger;
    private FrameLayout mFragment;
    private MyChildFragment myChildFragment;
    private MyChildFragmentTwo myChildFragmentTwo;
    private FragmentTransaction msg;
    private boolean isVisible = false;
    private ViewPager mViewPager;
    private List<ImageView> mImageViewList;
    private int[] images={R.mipmap.ic_launcher,R.drawable.aaa2,R.mipmap.ic_launcher,R.drawable.aaa1};
    private int currentPosition=1;
    private int dotPosition=0;
    private int prePosition=0;
    private LinearLayout mLinearLayoutDot;
    private List<ImageView> mImageViewDotList;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                mViewPager.setCurrentItem(currentPosition,false);
            }
        }
    };


    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_homepage);
    }

    @Override
    protected void run() {

    }

    protected void initView() {

        mViewPager= (ViewPager) findViewById(R.id.vp_banner);
        mLinearLayoutDot= (LinearLayout) findViewById(R.id.ll_main_dot);
        tv_travel = (TextView) findViewById(R.id.tv_travel);
        tv_passenger = (TextView) findViewById(R.id.tv_passenger);
         mFragment = (FrameLayout) findViewById(R.id.mFragment);

        //动态添加Fragment ,获取Fragment 管理器
        msg = getChildFragmentManager(). beginTransaction();
        //开启Fragment事物
        myChildFragment = new MyChildFragment();
        msg.add(R.id.mFragment, myChildFragment);
        msg.commit();

        tv_passenger.setOnClickListener(this);
        tv_travel.setOnClickListener(this);

        initDatae();

        setDot();

        setViewPager();

        autoPlay();


    }
    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        hideAll(transaction);
        switch (view.getId()) {
            case R.id.tv_passenger:
                tv_passenger.setBackgroundColor(0xff232730);
                tv_passenger.setTextColor(0xff00cd96);
                tv_travel.setBackgroundColor(0xffffffff);
                tv_travel.setTextColor(0xff424242);
                if(myChildFragment == null){
                    myChildFragment = new MyChildFragment();
                    transaction.add(R.id.mFragment,myChildFragment);
                }
                transaction.show(myChildFragment);
                transaction.commit();
                break;
            case R.id.tv_travel:
                tv_travel.setBackgroundColor(0xff232730);
                tv_travel.setTextColor(0xff00cd96);
                tv_passenger.setBackgroundColor(0xffffffff);
                tv_passenger.setTextColor(0xff424242);
                if(myChildFragmentTwo == null){
                    myChildFragmentTwo = new MyChildFragmentTwo();
                    transaction.add(R.id.mFragment,myChildFragmentTwo);
                }
                transaction.show(myChildFragmentTwo);
                transaction.commit();
                break;
        }

    }
    private void hideAll(FragmentTransaction transaction) {
        if (myChildFragment != null) {
            transaction.hide(myChildFragment);
        }
        if (myChildFragmentTwo != null) {
            transaction.hide(myChildFragmentTwo);
        }
    }
    private void initDatae() {
        mImageViewList=new ArrayList<>();
        mImageViewDotList=new ArrayList();
        ImageView imageView;
        for(int i=0;i<images.length+2;i++){
            if(i==0){   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView=new ImageView(getActivity());
                imageView.setBackgroundResource(images[images.length-1]);
                mImageViewList.add(imageView);
            }else if(i==images.length+1){   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView=new ImageView(getActivity());
                imageView.setBackgroundResource(images[0]);
                mImageViewList.add(imageView);
            }else{  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView=new ImageView(getActivity());
                imageView.setBackgroundResource(images[i-1]);
                mImageViewList.add(imageView);
            }
        }
    }

    //  设置轮播小圆点
    private void setDot() {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(15,15);
        params.rightMargin=20;
        //  for循环创建images.length个ImageView（小圆点）
        for(int i=0;i<images.length;i++){
            ImageView  imageViewDot=new ImageView(getActivity());
            imageViewDot.setLayoutParams(params);
            //  设置小圆点的背景为暗红图片
            imageViewDot.setBackgroundResource(R.drawable.red_dot_night);
            mLinearLayoutDot.addView(imageViewDot);
            mImageViewDotList.add(imageViewDot);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList.get(dotPosition).setBackgroundResource(R.drawable.red_dot);
    }

    private void setViewPager() {
        MyPagerAdapter adapter=new MyPagerAdapter(mImageViewList);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(currentPosition);
        //页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition=images.length;
                    dotPosition=images.length-1;
                }else if(position==images.length+1){    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition=1;
                    dotPosition=0;
                }else{
                    currentPosition=position;
                    dotPosition=position-1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList.get(prePosition).setBackgroundResource(R.drawable.red_dot_night);
                mImageViewDotList.get(dotPosition).setBackgroundResource(R.drawable.red_dot);
                prePosition=dotPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if(state==ViewPager.SCROLL_STATE_IDLE){
                    mViewPager.setCurrentItem(currentPosition,false);
                }
            }
        });
    }
    //  设置自动播放
    private void autoPlay() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                while(true){
                    SystemClock.sleep(3000);
                    currentPosition++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if (isVisibleToUser) {
            isVisible = true;
        } else {
            isVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
