package com.zhang.第三章.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/11 3:32 PM
 * <p>
 * 球自由落体的动画
 * 因为涉及到xy坐标,所以使用point
 */
public class FallBallEvaluator implements TypeEvaluator<Point> {

    Point point = new Point();

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        point.x = (int)(startValue.x +  fraction * (endValue.x - startValue.x));
        if (fraction * 2 <= 1) {//前一半时间
            point.y = (int) (startValue.y + fraction * 2 * (endValue.y - startValue.y));
        } else {//后一半时间,一直是最后的y坐标,横着滚动
            point.y = endValue.y;
        }
        return point;
    }
}
