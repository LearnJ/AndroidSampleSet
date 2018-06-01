package com.example.jxm.viewpagersample;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by jiamao on 2018/5/30.
 */

public class MViewPagerAdapter extends PagerAdapter {


    private int[] resIds;
    private Activity context;

    public MViewPagerAdapter(int[] resIds, Activity context) {
        this.resIds = resIds;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        view.setImageResource(resIds[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
