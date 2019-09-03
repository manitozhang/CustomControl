package com.zhang.第二章;

import android.widget.Button;
import android.widget.Toast;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第二章.activity.AnimSampleActivity;
import com.zhang.第二章.activity.AnimationTypeActivity;
import com.zhang.第二章.activity.AnmationCodeActivity;

public class SecondActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_second;
    }

    @Override
    public void initView() {
        super.initView();
        startIntent(R.id.btn_animation_type, AnimationTypeActivity.class);
        startIntent(R.id.btn_animation_code, AnmationCodeActivity.class);
        Button btnInterpolator = findViewById(R.id.btn_interpolator);
        btnInterpolator.setOnClickListener(v -> Toast.makeText(this, "查看2.1中的移动", Toast.LENGTH_SHORT).show());
        startIntent(R.id.btn_anim_sample, AnimSampleActivity.class);
    }
}
