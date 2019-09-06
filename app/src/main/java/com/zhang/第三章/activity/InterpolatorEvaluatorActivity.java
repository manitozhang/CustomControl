package com.zhang.第三章.activity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第三章.interpolator.MyInterpolator;

public class InterpolatorEvaluatorActivity extends BaseActivity {

    private Button btnInterpolator;
    private TextView tvAnim;
    private Button btnEvaluator;

    @Override
    public int initLayout() {
        return R.layout.activity_interpolator_evaluator;
    }

    @Override
    public void initView() {
        btnInterpolator = findViewById(R.id.btn_interpolator);
        btnEvaluator = findViewById(R.id.btn_evaluator);
        tvAnim = findViewById(R.id.tv_anim);
        btnInterpolator.setOnClickListener(v -> {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
            valueAnimator.setDuration(5000);
            valueAnimator.setInterpolator(new MyInterpolator());
            valueAnimator.addUpdateListener(animation -> {
                int animatedValue = (Integer) animation.getAnimatedValue();
                logger(animatedValue);
                tvAnim.layout(animatedValue, animatedValue, animatedValue + tvAnim.getWidth(), animatedValue + tvAnim.getHeight());
            });
            valueAnimator.start();
        });
        btnEvaluator.setOnClickListener(v -> {
//            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
            valueAnimator.addUpdateListener((animation -> {
                int animatedValue = (Integer) animation.getAnimatedValue();
//                tvAnim.layout(animatedValue, animatedValue, animatedValue + tvAnim.getWidth(), animatedValue + tvAnim.getHeight());
                tvAnim.setBackgroundColor(animatedValue);
            }));
            valueAnimator.setDuration(2000);
//            valueAnimator.setInterpolator(new BounceInterpolator());
//            valueAnimator.setEvaluator(new MyEvaluator());
//            valueAnimator.setEvaluator(new ReverseEvaluator());
//            valueAnimator.setEvaluator(new TestReverseEvaluator());
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.start();
        });
    }
}
