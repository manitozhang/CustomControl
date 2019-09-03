package com.zhang.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/3 10:21 AM
 * <p>
 * 路径
 */
public class PathView extends View {

    private Paint paint;

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画一个三角形
        paint.setColor(Color.BLACK);
        Path path = new Path();
        path.moveTo(10, 10);
        path.lineTo(10, 100);
        path.lineTo(300, 100);
        path.close();
        canvas.drawPath(path, paint);

        Path path1 = new Path();
        path1.moveTo(350, 350);
        RectF rectF = new RectF(200, 350, 300, 450);
        path1.arcTo(rectF, 0, 90);
        canvas.drawPath(path1, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rectF, paint);
    }
}
