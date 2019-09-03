package com.zhang.第二章.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.zhang.R;

public class AnimSampleActivity extends AppCompatActivity {

    private ImageView ivSmallToBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_sample);
        initView();
    }

    private void initView() {
        ivSmallToBig = findViewById(R.id.iv_small_to_big);
        //做一个放大的镜头由远到近的效果
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.5f, 1, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(5000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        ivSmallToBig.startAnimation(scaleAnimation);
    }
}
