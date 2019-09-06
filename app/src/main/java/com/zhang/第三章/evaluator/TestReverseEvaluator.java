package com.zhang.第三章.evaluator;

import android.animation.TypeEvaluator;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/6 6:15 PM
 */
public class TestReverseEvaluator implements TypeEvaluator<Integer> {
    /**
     * ValueAnimator(0,400)
     *
     * @param fraction:   0-1的一个进度
     * @param startValue: 0
     * @param endValue:   400
     * @return
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int) (endValue - (fraction * (endValue - startValue)));
    }
}
