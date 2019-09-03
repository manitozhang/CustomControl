package com.zhang.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/3 11:47 AM
 * <p>
 * 1.4画布
 */
public class CanvasView extends View {

    private final Paint paint;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(36);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStyle(Paint.Style.STROKE);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        paint.setColor(Color.BLACK);
        Rect rect = new Rect(0, 0, 400, 200);
        //绘制平移之前的矩形
        canvas.drawRect(rect, paint);
        canvas.translate(100, 100);
        paint.setColor(Color.RED);
        //绘制平移之后的矩形
        canvas.drawRect(rect, paint);
        //绘制平移之后的文字
        canvas.drawText("测试平移后的原点坐标位置", 0, 0, paint);
        //此项平移说明canvas画布与屏幕显示不是一个概念

        //保存当前画布大小,整屏
        canvas.save();

        canvas.clipRect(new Rect(300,300,600,600));
        canvas.drawColor(Color.RED);

    }
}
