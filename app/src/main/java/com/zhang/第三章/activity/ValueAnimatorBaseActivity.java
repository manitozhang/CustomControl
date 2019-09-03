package com.zhang.第三章.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.R;

public class ValueAnimatorBaseActivity extends AppCompatActivity {

    private Button btnScale;
    private Button btnTranslation;
    private Button btnRotation;
    private Button btnAlpha;
    private Button btnAnimSet;
    private TextView tvExecuteAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_base);
        initView();
    }

    private void initView() {
        btnScale = findViewById(R.id.btn_scale);
        btnTranslation = findViewById(R.id.btn_translation);
        btnRotation = findViewById(R.id.btn_rotation);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnAnimSet = findViewById(R.id.btn_anim_set);
        tvExecuteAnim = findViewById(R.id.tv_execute_anim);
        btnTranslation.setOnClickListener(v -> {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
            valueAnimator.setDuration(2000);
            valueAnimator.setInterpolator(new BounceInterpolator());
            valueAnimator.addUpdateListener(animation -> {
                int value = (Integer) animation.getAnimatedValue();
                tvExecuteAnim.layout(value
                        , value, value + tvExecuteAnim.getWidth()
                        , value + tvExecuteAnim.getHeight());
            });
            valueAnimator.start();
        });
        btnScale.setOnClickListener(v -> {
            try {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 400f, 50f, 300f);
                doAnimator(valueAnimator);
            } catch (Exception e) {
                e.getMessage();
            }
        });
    }

    private void doAnimator(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.addUpdateListener(animation -> {
            Float animatedValue = (Float) animation.getAnimatedValue();
            int value = animatedValue.intValue();
            tvExecuteAnim.layout(value
                    , value, value + tvExecuteAnim.getWidth()
                    , value + tvExecuteAnim.getHeight());
        });
        valueAnimator.start();
    }

}
