package com.maomao.androidutils.recyclerview.base;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Mao on 2016/5/15.
 */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener{

    private GestureDetectorCompat mGestureDetector;
    private RecyclerView mRecyclerView;

    public OnRecyclerItemClickListener(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
        this.mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext() , new ItemTouchHelpGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public  abstract void onItemClick(RecyclerView.ViewHolder vh);
    public  abstract void onLongClick(RecyclerView.ViewHolder vh);

    private class ItemTouchHelpGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View child = mRecyclerView.findChildViewUnder(e.getX(),e.getY());

            if (child != null){
                RecyclerView.ViewHolder vh = mRecyclerView.getChildViewHolder(child);
                onItemClick(vh);
            }

            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            View child = mRecyclerView.findChildViewUnder(e.getX(),e.getY());
            if (child != null){
                RecyclerView.ViewHolder vh = mRecyclerView.getChildViewHolder(child);
                onLongClick(vh);
            }
        }
    }
}
