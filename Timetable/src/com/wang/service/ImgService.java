package com.wang.service;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * @author 作者 mengyangwang E-mail:wangmengyang101@gmail.com
 * @version 创建时间：9 Apr 2014 10:50:15
 * @类说明
 */
public class ImgService {
	public static Bitmap createFramedPhoto(int x, int y, Bitmap image, float outerRadiusRat) {  
        //根据源文件新建一个darwable对象  
        Drawable imageDrawable = new BitmapDrawable(image);  
  
        // 新建一个新的输出图片  
        Bitmap output = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);  
        Canvas canvas = new Canvas(output);  
  
        // 新建一个矩形  
        RectF outerRect = new RectF(0, 0, x, y);  
  
        // 产生一个红色的圆角矩形  
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);  
        paint.setColor(Color.RED);  
        canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);  
  
  
        // 将源图片绘制到这个圆角矩形上  
        //详解见http://lipeng88213.iteye.com/blog/1189452  
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));  
        imageDrawable.setBounds(0, 0, x, y);  
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);  
        imageDrawable.draw(canvas);  
        canvas.restore();  
  
        return output;  
    } }
