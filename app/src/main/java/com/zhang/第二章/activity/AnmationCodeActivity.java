package com.zhang.第二章.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.R;

public class AnmationCodeActivity extends AppCompatActivity {

    private Button btnScale;
    private Button btnTranslation;
    private Button btnRotation;
    private Button btnAlpha;
    private Button btnAnimSet;
    private TextView tvExecuteAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmation_code);
        initView();
    }

    private void initView() {
        btnScale = findViewById(R.id.btn_scale);
        btnTranslation = findViewById(R.id.btn_translation);
        btnRotation = findViewById(R.id.btn_rotation);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnAnimSet = findViewById(R.id.btn_anim_set);
        tvExecuteAnim = findViewById(R.id.tv_execute_anim);
        //缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        //移动
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 10, Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 200);
        translateAnimation.setDuration(2000);
        //旋转
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        //渐变
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1);
        alphaAnimation.setDuration(2000);

        btnScale.setOnClickListener(v -> {
            //缩放
            tvExecuteAnim.startAnimation(scaleAnimation);
        });
        btnTranslation.setOnClickListener(v -> {
            //移动
            tvExecuteAnim.startAnimation(translateAnimation);
        });
        btnRotation.setOnClickListener(v -> {
            //旋转
            tvExecuteAnim.startAnimation(rotateAnimation);
        });
        btnAlpha.setOnClickListener(v -> {
            //渐变
            tvExecuteAnim.startAnimation(alphaAnimation);
        });
        btnAnimSet.setOnClickListener(v -> {
            //动画集合
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(3000);
            animationSet.setFillAfter(true);
            tvExecuteAnim.startAnimation(animationSet);
        });
    }
}
