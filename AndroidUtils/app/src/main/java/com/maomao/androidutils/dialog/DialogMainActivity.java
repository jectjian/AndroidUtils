package com.maomao.androidutils.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.maomao.androidutils.R;

public class DialogMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        finish();
        return true;
    }

    public void tip(View view)
    {
        Toast.makeText(this, "点击弹出框外部关闭窗口", Toast.LENGTH_SHORT).show();
    }
}
