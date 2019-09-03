package com.zhang.第一章.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/8/23 4:11 PM
 * 基本图形绘制
 */
public class DrawView extends View {

    private final Paint paint;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setStrokeWidth(50);//设置画笔宽度
        /**
         * Paint.Style.STROKE: 只描边(圆的半径➕画笔/2)
         * Paint.Style.FILL: 填充(圆的半径, setStrokeWidth此时不生效)
         * Paint.Style.FILL_AND_STROKE: 填充(圆的半径➕画笔/2)
         */
        paint.setStyle(Paint.Style.STROKE);//设置画笔样式
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画布背景
        canvas.drawColor(Color.YELLOW);

        //在屏幕中间显示一个半径为150 的圆环
        paint.setColor(Color.RED);//设置画笔颜色
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 150, paint);
        //在圆环里面再画一个实心圆
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        //内心圆的半径 = 大圆半径-(画笔宽度/2)
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 125, paint);

        //画一条直线
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 50, getWidth(), 50, paint);

        //画一个点
        paint.setStrokeWidth(20);
        canvas.drawPoint(100, 200, paint);

        //画一个边框的Rect矩形
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        Rect rect = new Rect(150, 300, 500, 450);
        canvas.drawRect(rect, paint);

        //画一个带边框切充满RectF矩形
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.GREEN);
        RectF rectF = new RectF(550f, 300f, 750f, 450f);
        canvas.drawRect(rectF, paint);
    }
}
