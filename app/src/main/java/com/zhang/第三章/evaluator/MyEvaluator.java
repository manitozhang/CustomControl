package com.zhang.第三章.evaluator;

import android.animation.TypeEvaluator;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/4 5:40 PM
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        //整体多200px
        return (int) (200 + startInt + fraction * (endValue - startValue));
    }
}
