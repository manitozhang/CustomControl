package com.zhang.第一章;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第一章.activity.CanvasActivity;
import com.zhang.第一章.activity.DrawActivity;
import com.zhang.第一章.activity.PathActivity;
import com.zhang.第一章.activity.RegionActivity;

public class FirstActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_first;
    }


    /**
     * 初始化跳转
     */
    @Override
    public void initView() {
        startIntent(R.id.btn_draw, DrawActivity.class);
        startIntent(R.id.btn_path, PathActivity.class);
        startIntent(R.id.btn_region, RegionActivity.class);
        startIntent(R.id.btn_canvas, CanvasActivity.class);
    }
}
