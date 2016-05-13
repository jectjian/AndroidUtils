package com.maomao.androidutils.materialdesign.sharedelement;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.maomao.androidutils.R;

public class ShareElementOtherActivity extends AppCompatActivity {
    private   ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_other);

        Bitmap bundle = getIntent().getParcelableExtra(getString(R.string.square_blue_name));
        mImageView = (ImageView) findViewById(R.id.big_blue_icon);
        mImageView.setImageBitmap(bundle);
    }
}
