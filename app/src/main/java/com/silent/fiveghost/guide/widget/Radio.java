package com.silent.fiveghost.guide.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

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

public class Radio extends android.support.v7.widget.AppCompatRadioButton {

    private Bitmap bitmap;
    private int bitmapWidth, bitmapHeight;
    private int measuredWidth;
    private int measuredHeight;
    private Paint paint;
    private Point p1, p2, p3, p4, p5, p6;
    private Rect bitmapRect;
    private Path mPath;

    public Radio(Context context) {
        this(context, null, 0);
    }

    public Radio(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Radio(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != null)
            if (drawable instanceof BitmapDrawable) {
                Bitmap bm = ((BitmapDrawable) drawable).getBitmap();
                setImageBitmap(bm);
                init();
            }
    }

    public void init() {
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0xff424242);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // 开始点
        p1 = new Point(0, 0);
        // 圆左边线
        p2 = new Point(measuredWidth / 2 - bitmapWidth, 0);
        // 圆右边线
        p3 = new Point(measuredWidth / 2 + bitmapWidth, 0);
        // 右点
        p4 = new Point(measuredWidth, 0);
        // 右下点
        p5 = new Point(measuredWidth, measuredHeight);
        // 左下点
        p6 = new Point(0, measuredHeight);
        // 画圆区域
        bitmapRect = new Rect(p2.x, p2.y - bitmapHeight, p3.x, p3.y + bitmapHeight);
        mPath = new Path();
        // 重绘
        invalidate();
    }

    public void setImageBitmap(Bitmap bm) {
        bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);

        canvas.drawRoundRect(rectF, 50, 50, paint);
        canvas.drawBitmap(bm, rect, rect, paint);
        bitmapWidth = bitmap.getWidth() / 2;
        bitmapHeight = bitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            mPath.moveTo(p1.x, p1.y);
            mPath.lineTo(p2.x, p2.y);
            mPath.arcTo(new RectF(bitmapRect), 180, 180);
            mPath.lineTo(p4.x, p4.y);
            mPath.lineTo(p5.x, p5.y);
            mPath.lineTo(p6.x, p6.y);
            mPath.lineTo(p1.x, p1.y);
            canvas.drawPath(mPath, paint);
            canvas.drawRoundRect(new RectF(bitmapRect), 0, 0, paint);
        }
    }
}
