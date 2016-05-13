package com.maomao.androidutils.materialdesign.sharedelement;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.maomao.androidutils.R;
import com.maomao.androidutils.utils.Bitmap;

/**
 * 最低API21
 * 注意修改了style文件
 * 同样可以在item点击的时候使用。
 * 具体可参考 https://github.com/ytumaotong1992/Material-Animations 开源库
 */
public class ShareElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);
        final ImageView blueIconImageView = (ImageView) findViewById(R.id.small_blue_icon);
        blueIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShareElementActivity.this , ShareElementOtherActivity.class);
                i.putExtra(getString(R.string.square_blue_name) , Bitmap.drawableToBitmap
                        (blueIconImageView.getDrawable()));
                View sharedView = blueIconImageView;
                String transitionName = getString(R.string.square_blue_name);
                ActivityOptions transitionActivityOptions = ActivityOptions
                        .makeSceneTransitionAnimation(ShareElementActivity.this,sharedView ,
                                transitionName);
                startActivity(i , transitionActivityOptions.toBundle());
            }
        });
    }
}
