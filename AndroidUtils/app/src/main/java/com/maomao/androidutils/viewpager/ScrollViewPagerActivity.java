package com.maomao.androidutils.viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.maomao.androidutils.R;

import java.lang.reflect.Field;

public class ScrollViewPagerActivity extends AppCompatActivity {

    private static final String TAG = "ScrollViewPagerActivity";

    private ViewPager mViewPager;
    private int[] mImgIds;
    private FixedSpeedScroller scroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_pager);

        mImgIds = new int[]{R.drawable.model1, R.drawable.model2, R.drawable.model3, R.drawable
                .model4};

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(3);
        setViewPagerSpeed(250);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(ScrollViewPagerActivity.this);
                imageView.setImageResource(mImgIds[ position % mImgIds.length]);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                container.addView(imageView);
               // mViewPager.setObjectForPosition(imageView, position);
                return imageView;
            }
        });


    }

    /**
     * 设置ViewPager切换速度
     *
     * @param duration
     */
    private void setViewPagerSpeed(int duration) {
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            scroller = new FixedSpeedScroller(ScrollViewPagerActivity.this, new AccelerateInterpolator());
            field.set(mViewPager, scroller);
            scroller.setDuration(duration);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
