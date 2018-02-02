package com.silent.fiveghost.guide.ui.order;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/8/22.
 * 1、自定义类，继承BitmapTransformation
 * 2、重写方法
 * 3、在transform方法中，进行圆的绘制
 *      1、获取原图片的宽高
 *      2、获取需要裁剪的宽高：求原图片的最小边长
 *      3、获取裁剪的原始点位置x,y
 *      4、进行裁剪
 *      5、创建透明的bitmap
 *      6、创建画布
 *      7、使用画笔将裁剪后的图片，以圆的形式绘制到画布上
 *      8、透明bitmap就变成了圆形图片
 *
 *      使用：
 *           Glide.with(this).load("http://cdn.duitang.com/uploads/item/201610/10/20161010205532_KvsQM.jpeg").bitmapTransform(new CircleBitmapTransformation(ResultActivity.this)).into(imageView);
 */
public class CircleBitmapTransformation extends BitmapTransformation {
    public CircleBitmapTransformation(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        //进行绘制圆形Bitmap
        return getBitmap(toTransform);
    }
    public Bitmap getBitmap(Bitmap bitmap){
        if(bitmap==null)
            return null;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        int x = (width-min)/2;
        int y = (height-min)/2;
        //是根据原Bitmap，以x,y开始，裁剪min宽，min高的Bitmap出来
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, x, y, min, min);
        //创建min宽，min高的一个透明的Bitmap对象
        Bitmap bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setShader(new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        int R = min/2;
        canvas.drawCircle(R,R,R,paint);
        return bitmap2;
    }


//    @Override
//    public String getId() {
//        return getClass().getSimpleName();
//    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }
}
