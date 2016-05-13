package com.maomao.androidutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.maomao.androidutils.materialdesign.sharedelement.ShareElementActivity;
import com.maomao.androidutils.recyclerview.base.RecyclerViewActivity;

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

    private void startActivity(Class<?> cls){
        startActivity(new Intent(MainActivity.this , cls));
    }
}
