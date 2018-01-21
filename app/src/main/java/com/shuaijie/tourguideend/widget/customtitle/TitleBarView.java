package com.shuaijie.tourguideend.widget.customtitle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shuaijie.tourguideend.R;

/**
 * 认真的人到最后都是难过 2017/12/21.
 * 自定义的TitleBar控件
 */

public class TitleBarView extends LinearLayout {
    private View view;
    private ImageView iv_left;//左侧图标
    private ImageView iv_right;//右侧图标
    private TextView tv_left;//左侧文本
    private TextView tv_right;//右侧文本
    private TextView tv_title;//中间文本

    public TitleBarView(Context context) {
        this(context, null, 0);
    }


    public TitleBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        view = View.inflate(context, R.layout.view_titlebar, this);
        iv_left = (ImageView) view.findViewById(R.id.iv_left);
        iv_right = (ImageView) view.findViewById(R.id.iv_right);
        tv_left = (TextView) view.findViewById(R.id.tv_left);
        tv_right = (TextView) view.findViewById(R.id.tv_right);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarView);
        iv_left.setVisibility(typedArray.getInt(R.styleable.TitleBarView_left_icon_visibility, View.VISIBLE));
        tv_right.setVisibility(typedArray.getInt(R.styleable.TitleBarView_left_text_visibility, View.VISIBLE));
        tv_title.setVisibility(typedArray.getInt(R.styleable.TitleBarView_center_text_visibility, View.VISIBLE));
        iv_right.setVisibility(typedArray.getInt(R.styleable.TitleBarView_right_icon_visibility, View.VISIBLE));
        tv_left.setVisibility(typedArray.getInt(R.styleable.TitleBarView_right_text_visibility, View.VISIBLE));
    }

    //设置左侧imageView控件的显示与隐藏
    public void setLeftImageisible(int Visiblity) {
        iv_left.setVisibility(Visiblity);
    }

    //设置右侧imageView控件的显示与隐藏
    public void setRightImageisible(int Visiblity) {
        iv_right.setVisibility(Visiblity);
    }

    //设置左侧imageView控件的
    public void setLeftImageRes(int drawable) {
        iv_left.setImageResource(drawable);
    }

    //设置右侧imageView控件的显示与隐藏
    public void setRightImageRes(int drawable) {
        iv_right.setImageResource(drawable);
    }


    //设置左侧文本控件控件的显示与隐藏
    public void setLeftTextisible(int Visiblity) {
        tv_left.setVisibility(Visiblity);
    }

    //设置左侧文本控件的显示与隐藏
    public void setRightTextisible(int Visiblity) {
        tv_left.setVisibility(Visiblity);
    }

    //设置左侧文本的内容
    public void setLeftTextView(String content) {
        tv_left.setText(content);
    }

    //设置右侧文本的内容
    public void setRightTextView(String content) {
        tv_right.setText(content);
    }

    //设置标题文本的内容
    public void setTitleTextView(String content) {
        tv_title.setText(content);
    }
}