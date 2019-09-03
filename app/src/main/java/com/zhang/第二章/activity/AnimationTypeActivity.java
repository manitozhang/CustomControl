package com.zhang.第二章.activity;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.R;

public class AnimationTypeActivity extends AppCompatActivity {

    private Button btnScale;
    private Button btnTranslation;
    private Button btnRotation;
    private Button btnAlpha;
    private Button btnAnimSet;
    private TextView tvAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_type);
        initView();
    }

    private void initView() {
        btnScale = findViewById(R.id.btn_scale);
        btnTranslation = findViewById(R.id.btn_translation);
        btnRotation = findViewById(R.id.btn_rotation);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnAnimSet = findViewById(R.id.btn_anim_set);
        tvAnim = findViewById(R.id.tv_execute_anim);
        btnScale.setOnClickListener(v -> {
            //缩放
            tvAnim.startAnimation(loadAnim(R.anim.anim_scale));
        });
        btnTranslation.setOnClickListener(v -> {
            //移动
            Animation animation = loadAnim(R.anim.anim_transaction);
//            animation.setInterpolator(new BounceInterpolator());
//            animation.setInterpolator(new OvershootInterpolator());
//            animation.setInterpolator(new AnticipateOvershootInterpolator());
            animation.setInterpolator(new CycleInterpolator(1));
            tvAnim.startAnimation(animation);
        });
        btnRotation.setOnClickListener(v -> {
            //旋转
            Animation animation = loadAnim(R.anim.anim_rotation);
            animation.setInterpolator(new BounceInterpolator());
            tvAnim.startAnimation(animation);
        });
        btnAlpha.setOnClickListener(v -> {
            //渐变
            tvAnim.startAnimation(loadAnim(R.anim.anim_alpha));
        });
        btnAnimSet.setOnClickListener(v -> {
            //动画集合
            tvAnim.startAnimation(loadAnim(R.anim.anim_set));
        });
    }

    /**
     * 加载动画
     *
     * @param animId
     * @return
     */
    private Animation loadAnim(@AnimRes int animId) {
        return AnimationUtils.loadAnimation(AnimationTypeActivity.this, animId);
    }

}
