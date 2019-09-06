package com.zhang.第三章.evaluator;

import android.animation.TypeEvaluator;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/6 7:22 PM
 * <p>
 * 字母估值器
 */
public class Letterevaluator implements TypeEvaluator<Character> {
    /**
     * @param fraction:   0-1
     * @param startValue: A   65 = (int)A
     * @param endValue:   Z   90 = (int)Z
     * @return
     */
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int) startValue;//65
        int endInt = (int) endValue;//90
        /**
         * startInt: 65开始
         * fraction: 0-1, endInt: 90, startInt: 65
         * resultInt: 65+((0-1)*25)
         * (char) resultInt: 将ascii码转为对应的字母
         */
        int resultInt = (int) (startInt + (fraction * (endInt - startInt)));
        return (char) resultInt;
    }
}
