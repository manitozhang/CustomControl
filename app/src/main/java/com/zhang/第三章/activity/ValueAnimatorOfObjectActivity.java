package com.zhang.第三章.activity;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第三章.evaluator.FallBallEvaluator;
import com.zhang.第三章.evaluator.Letterevaluator;

public class ValueAnimatorOfObjectActivity extends BaseActivity {
    private Button btnStart;
    private TextView tvLetter;
    private ImageView ivBall;
    private Button btnStartBall;

    @Override
    public int initLayout() {
        return R.layout.activity_value_animator_of_object;
    }

    @Override
    public void initView() {
        super.initView();
        btnStart = findViewById(R.id.btn_start);
        btnStartBall = findViewById(R.id.btn_start_ball);
        tvLetter = findViewById(R.id.tv_letter);
        ivBall = findViewById(R.id.iv_fall_ball);
        btnStart.setOnClickListener(v -> {
            doAnim();
        });
        btnStartBall.setOnClickListener(v -> {
            doBallAnim();
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

    private void doBallAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new FallBallEvaluator(), new Point(0, btnStartBall.getBottom()), new Point(500, btnStartBall.getBottom()+500));
        valueAnimator.addUpdateListener((animation -> {
            Point animPoint = (Point) animation.getAnimatedValue();
            ivBall.layout(animPoint.x, animPoint.y, ivBall.getWidth() + animPoint.x, ivBall.getHeight() + animPoint.y);
        }));
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

}
