package com.maomao.androidutils.theme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.maomao.androidutils.R;

/**
 * 使用theme方式控制activity转场动画
 */
public class SplashActivity extends Activity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, ThemeActivity.class);
                startActivity(intent);
                finish();
            }
        } , 1000);
    }
}
