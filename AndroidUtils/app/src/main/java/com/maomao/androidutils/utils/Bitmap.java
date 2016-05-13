package com.maomao.androidutils.utils;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * Created by MaoTong on 2016/5/13.
 * QQ:974291433
 */
public class Bitmap {
    public static android.graphics.Bitmap drawableToBitmap(Drawable drawable) {


        android.graphics.Bitmap bitmap = android.graphics.Bitmap
                .createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        drawable.getOpacity() != PixelFormat.OPAQUE ? android.graphics.Bitmap.Config.ARGB_8888
                                : android.graphics.Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        // canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
