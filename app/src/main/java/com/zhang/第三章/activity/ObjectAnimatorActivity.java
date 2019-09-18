package com.zhang.第三章.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.R;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView tvAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        initView();
    }

    private void initView() {
        btnStart = findViewById(R.id.btn_start);
        tvAnim = findViewById(R.id.tv_anim);
        btnStart.setOnClickListener(v -> {
//            doAlphaAnim();
            doRotationAnim();
        });
    }

    /**
     * 执行一个渐变的动画
     */
    private void doAlphaAnim(){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tvAnim, "alpha", 1, 0, 1);
        alpha.setDuration(3000);
        alpha.start();
    }

    /**
     * 执行一个旋转的动画
     */
    private void doRotationAnim(){
        ObjectAnimator rotation = ObjectAnimator.ofFloat(tvAnim, "rotation", 0, 180, 0);
        rotation.setDuration(5000);
        rotation.start();
    }

}
