package com.wmct.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ZHYu on 2017/5/13.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected abstract void initView();

    protected void openActivity(Class mClass) {
        Intent intent = new Intent();
        intent.setClass(this, mClass);
        startActivity(intent);
    }

}
