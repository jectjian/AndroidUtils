package com.maomao.androidutils.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maomao.androidutils.R;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void functionKey(View view)
    {
        Intent intent = new Intent(this, DialogMainActivity.class);
        startActivity(intent);
    }
}
