package com.zhang.第三章;

import com.zhang.BaseActivity;
import com.zhang.R;
import com.zhang.第三章.activity.BoundLoadingActivity;
import com.zhang.第三章.activity.ValueAnimatorBaseActivity;

public class ThridActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_thrid;
    }

    @Override
    public void initView() {
        super.initView();
        startIntent(R.id.btn_valueanimator_base, ValueAnimatorBaseActivity.class);
        startIntent(R.id.btn_bound_loading, BoundLoadingActivity.class);
    }
}
