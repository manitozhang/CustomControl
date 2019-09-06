package com.zhang.第三章.evaluator;

import android.animation.TypeEvaluator;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/5 11:43 AM
 * 一个倒叙的自定义估值器
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {
    /**
     * @param fraction:   将动画分为0-1的一个进度
     *                    ValueAnimator(0,400)
     * @param startValue: 开始值:0
     * @param endValue:   结束值:400
     * @return 如果ValueAnimator(0, 400, 100, 200, 500, 350, 250)是多个参数的
     * 则startValue和endValue分别是变化的,为 (0,400)->(400,100)->(100,200)->(200,500)->(500,350)->(350,250)
     * fraction还是0-1
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        /**
         * (endValue - startValue): 400-0
         * fraction * (endValue - startValue): 0*400 --> 1*0  相乘是为了慢慢进度,不是直接执行他们的相减
         * (endValue - fraction * (endValue - startValue))↓↓↓
         * --> (400-(0*400 --> 1*0))  --> (400-0-->400-400) --> (400-->0)
         */
        return (int) (endValue - fraction * (endValue - startValue));
    }
}
