package com.zhang.第三章.weight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.zhang.R;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2019/9/3 6:30 PM
 */
@SuppressLint("AppCompatCustomView")
public class LoadingImageView extends ImageView {

    private int mTop;
    private int imgIndex = 0;
    private int imgCount = 3;

    public LoadingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAnim();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;
        Log.i("aaaaa", mTop + "");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400, 0);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setDuration(20000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener((animation -> {
            int animatedValue = (Integer) animation.getAnimatedValue();
            Log.i("aaaaaanimatedValue", animatedValue + "");
            Log.i("aaaaamTop", mTop + "");
            Log.i("mTop - animatedValue", mTop - animatedValue + "");
            setTop(mTop - animatedValue);
        }));
        //监听动画的开始结束
        valueAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                setImageDrawable(getResources().getDrawable(R.drawable.pic_1));
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                imgIndex++;
                switch (imgIndex % imgCount) {
                    case 0:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_1));
                        break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_2));
                        break;
                    case 2:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_3));
                        break;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        valueAnimator.start();

    }

}
