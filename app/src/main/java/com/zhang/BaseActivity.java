package com.zhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
    }

    public abstract int initLayout();

    public void initView() {

    }

    public void startIntent(@IdRes int id, Class<?> cls) {
        findViewById(id).setOnClickListener(v -> {
            startActivity(new Intent(this, cls));
        });
    }

    public void logger(Object logMsg) {
        Log.i("BaseActivity", String.valueOf(logMsg));
    }

}
