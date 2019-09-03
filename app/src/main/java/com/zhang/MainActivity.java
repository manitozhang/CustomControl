package com.zhang;

import com.zhang.第一章.FirstActivity;
import com.zhang.第三章.ThridActivity;
import com.zhang.第二章.SecondActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        startIntent(R.id.btn_first, FirstActivity.class);
        startIntent(R.id.btn_second, SecondActivity.class);
        startIntent(R.id.btn_thrid, ThridActivity.class);
    }
}
