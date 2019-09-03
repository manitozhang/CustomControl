package com.zhang.第一章.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/3 11:28 AM
 * <p>
 * 区域
 */
public class RegionView extends View {

    private final Paint paint;

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        Region region = new Region(50, 50, 200, 150);
        drawRegion(canvas, region, paint);
    }

    /**
     * 画一个区域
     *
     * @param canvas: 画布
     * @param region: 区域
     * @param paint:  画笔🖌
     */
    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }

}
