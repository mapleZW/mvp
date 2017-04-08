package com.mvp.view.activity.base_activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by HJFei on 2017/2/7.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
       // MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
       // MobclickAgent.onPause(this);
    }
}
