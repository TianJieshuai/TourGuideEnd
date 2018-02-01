package com.silent.fiveghost.guide.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.silent.fiveghost.guide.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by shuaiJie on 2018/1/30.
 * .                       .::::.
 * .                    .::::::::.
 * .                   :::::::::::
 * .                ..:::::::::::'   女
 * .              '::::::::::::'      神
 * .                .:::::::::       保
 * .               '::::::::::..      佑
 * .               .::::::::::::::.  代
 * .              `:::::::::::::::::  码
 * .              ::::``::::::::::'  无   .:::.
 * .             ::::'   ':::::' debug .::::::::.
 * .            .:::'      ::::     .:::::::'.::::.
 * .          .:::'       :::::  .:::::::::'  ':::::.
 * .         .::'        :::::.:::::::::'       ':::::.
 * .        .::'         ::::::::::::::'          ``::::.
 * .    ...:::           ::::::::::::'                ``::.
 * .   ```` ':.          ':::::::::'                    ::::..
 * .                      '.:::::'                     ':'````..
 * .
 * 作    者：shuaiJie
 * 创建时间：2018/1/30 16:14
 * 电子邮箱：510889082@qq.com
 */

@SuppressLint("AppCompatCustomView")
public class Radio extends RadioButton {
    private PointF p1, p2, p3, p4, p5, p6;
    private RectF bitmapRect;
    private int width;
    private int height;
    private Path mPath;
    private Paint mPaint;

    private float circleDiameter;
    private Bitmap bitmapDrawable;
    private boolean isCircle;
    private CharSequence text;
    private Drawable background;

    public Radio(Context context) {
        this(context, null, 0);
    }

    public Radio(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Radio(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @SuppressLint("NewApi")
    public Radio(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        AutoUtils.autoSize(this);
        initView(context, attrs, defStyleAttr, defStyleRes);
    }

    @SuppressLint("NewApi")
    private void initView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Radio, defStyleAttr, defStyleRes);
        text = getText();
        mPaint = new Paint();
        background = getBackground();
        for (int x = 0; x < typedArray.getIndexCount(); x++) {
            int index = typedArray.getIndex(x);
            switch (index) {
                case R.styleable.Radio_circleDiameter:
                    circleDiameter = typedArray.getDimensionPixelSize(index, -1) / 2;
                    break;
                case R.styleable.Radio_circleIcon:
                    Drawable drawable = context.getDrawable(typedArray.getResourceId(index, 0));
                    if (drawable instanceof BitmapDrawable) {
                        this.bitmapDrawable = ((BitmapDrawable) drawable).getBitmap();
                    }
                    break;
                case R.styleable.Radio_isCircle:
                    isCircle = typedArray.getBoolean(index, false);
                    break;
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec); //获取宽的模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec); // 获取高的模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec); //获取宽的尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec); //获取高的尺寸

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = 200;
        }
        //保存丈量结果
        setMeasuredDimension(width, height);
    }

    public void setBitmap(Bitmap bm) {

    }

    @SuppressLint({"DrawAllocation", "NewApi"})
    @Override
    protected void onDraw(Canvas canvas) {
        // 设置下方形状画笔样式
        mPaint.reset();
        mPaint.setColor(0xffffffff);
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStyle(Paint.Style.FILL);

        // 计算下方形状控制点和图片绘制区域
        p1 = new PointF(0, height / 2);
        p2 = new PointF(width / 2 - circleDiameter, height / 2);
        p3 = new PointF(width / 2 + circleDiameter, height / 2);
        p4 = new PointF(width, height / 2);
        p5 = new PointF(width, height);
        p6 = new PointF(0, height);
        bitmapRect = new RectF(p2.x, p2.y - circleDiameter, p3.x, p3.y + circleDiameter);

        // 连接控制点和绘制图片
        mPath = new Path();
        mPath.moveTo(p4.x, p4.y);
        mPath.lineTo(p3.x, p3.y);
        if (isCircle) {
            mPath.arcTo(new RectF(bitmapRect), 0, 180);
        } else {
            mPath.lineTo(p2.x, p2.y);
        }
        mPath.lineTo(p1.x, p1.y);
        mPath.lineTo(p6.x, p6.y);
        mPath.lineTo(p5.x, p5.y);
        mPath.lineTo(p4.x, p4.y);
        canvas.drawPath(mPath, mPaint);
        if (isCircle) {
            mPaint.setColor(0xffffffff);
            canvas.drawBitmap(bitmapDrawable, null, bitmapRect, mPaint);
        }
        // 设置下方字体画笔样式
        mPaint.reset();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(getTextSize());
        mPaint.setTextAlign(Paint.Align.CENTER);
        // 计算图片和底部中间值
        float v = height - bitmapRect.bottom;
        v = bitmapRect.bottom + v / 2;
        // 获取字体高度信息 实现垂直居中
        Rect rect = new Rect();
        mPaint.getTextBounds(text.toString(), 0, text.length(), rect);//获取字符串的宽高信息，具体信息存放在rect矩形中
        int textheight = Math.abs(rect.top) / 2;
        v += textheight - rect.bottom;
        // 写字
        canvas.drawText(text, 0, text.length(), width / 2, v, mPaint);
    }
}
