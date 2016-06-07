package com.maomao.androidutils.imooc.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.maomao.androidutils.R;
import com.maomao.androidutils.imooc.progressbar.view.HorizontalProgressbarWithProgress;
import com.maomao.androidutils.imooc.progressbar.view.RoundProgressBarWithProgress;

public class ProgressBarActivity extends AppCompatActivity {

    private static final int MSG_UPDATE = 0X110;
    private HorizontalProgressbarWithProgress mHProgress;
    private RoundProgressBarWithProgress mRProgress;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int progress = mHProgress.getProgress();
            mHProgress.setProgress(++progress);
            mRProgress.setProgress(++progress);
            if (progress >= 100){
                mHandler.removeMessages(MSG_UPDATE);
            }
            mHandler.sendEmptyMessageDelayed(MSG_UPDATE , 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        mHProgress = (HorizontalProgressbarWithProgress) findViewById(R.id.id_progress01);
        mRProgress = (RoundProgressBarWithProgress) findViewById(R.id.id_progress02);
        mHandler.sendEmptyMessageDelayed(MSG_UPDATE , 100);
    }
}
