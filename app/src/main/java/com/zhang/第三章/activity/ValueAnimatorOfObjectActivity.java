package com.zhang.第三章.activity;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第三章.evaluator.Letterevaluator;

public class ValueAnimatorOfObjectActivity extends BaseActivity {
    private Button btnStart;
    private TextView tvLetter;

    @Override
    public int initLayout() {
        return R.layout.activity_value_animator_of_object;
    }

    @Override
    public void initView() {
        super.initView();
        btnStart = findViewById(R.id.btn_start);
        tvLetter = findViewById(R.id.tv_letter);
        btnStart.setOnClickListener(v -> {
            doAnim();
        });
    }

    private void doAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new Letterevaluator(), new Character('A'), new Character('Z'));
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener((animation -> {
            tvLetter.setText(String.valueOf(animation.getAnimatedValue()));
        }));
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.start();
    }

}
