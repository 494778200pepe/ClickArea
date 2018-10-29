package com.jcoder.clickarea;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MenuViewItem extends FrameLayout {

    private int width = -1;
    private int height = -1;
    private Bitmap bitmap;

    public MenuViewItem(Context context) {
        super(context);
    }

    public MenuViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MenuViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != MotionEvent.ACTION_DOWN) {
            return super.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (width == -1 || height == -1) {
            Drawable drawable = ((StateListDrawable) getBackground()).getCurrent();
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            width = getWidth();
            height = getHeight();
        }
        if (null == bitmap || x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }
        // 关键点：当前点的像素值，与透明进行对比
        int pixel = bitmap.getPixel(x, y);
        if (Color.TRANSPARENT == pixel) {
            return false;
        }
        boolean result = super.onTouchEvent(event);
        Log.d("pepe", "result = " + result);
        return result;
    }
}
