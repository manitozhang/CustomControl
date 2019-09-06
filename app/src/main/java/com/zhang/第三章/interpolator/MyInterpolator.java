package com.zhang.第三章.interpolator;

import android.animation.TimeInterpolator;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/4 3:56 PM
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        //input只与动画的时间有关系
        return 1 - input;
    }
}
