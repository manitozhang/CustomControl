package com.zhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import com.zhang.activity.CanvasActivity;
import com.zhang.activity.DrawActivity;
import com.zhang.activity.PathActivity;
import com.zhang.activity.RegionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIntent();
    }

    /**
     * 初始化跳转
     */
    private void initIntent() {
        startIntent(R.id.btn_draw, DrawActivity.class);
        startIntent(R.id.btn_path, PathActivity.class);
        startIntent(R.id.btn_region, RegionActivity.class);
        startIntent(R.id.btn_canvas, CanvasActivity.class);
    }


    private void startIntent(@IdRes int id, Class<?> cls) {
        findViewById(id).setOnClickListener(v -> {//基本图形绘制
            startActivity(new Intent(MainActivity.this, cls));
        });
    }
}
