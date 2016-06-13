package com.maomao.androidutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.maomao.androidutils.dialog.DialogActivity;
import com.maomao.androidutils.imooc.progressbar.ProgressBarActivity;
import com.maomao.androidutils.imooc.wuziqi.WuziqiActivity;
import com.maomao.androidutils.materialdesign.sharedelement.ShareElementActivity;
import com.maomao.androidutils.recyclerview.base.RecyclerViewActivity;
import com.maomao.androidutils.theme.SplashActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startRecyclerViewActivity(View view){
        startActivity(RecyclerViewActivity.class);
    }

    public void startShareElementActivity(View view){
        startActivity(ShareElementActivity.class);
    }

    public void startProgressBarActivity(View view){
        startActivity(ProgressBarActivity.class);
    }

    public void startWuziqiActivity(View view){
        startActivity(WuziqiActivity.class);
    }

    public void startThemeActivity(View view){
        startActivity(SplashActivity.class);
    }

    public void startDialogActivity(View view){
        startActivity(DialogActivity.class);
    }

    private void startActivity(Class<?> cls){
        startActivity(new Intent(MainActivity.this , cls));
    }
}
