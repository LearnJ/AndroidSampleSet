package com.example.jxm.viewpagersample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] imgIds={R.mipmap.img2, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6,R.mipmap.img2, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6};
    private MViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha = DEFAULT_MIN_ALPHA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.viewPager);
        viewPagerAdapter=new MViewPagerAdapter(imgIds,this);
        //设置Page间间距
        viewPager.setPageMargin(20);
        //设置缓存的页面数量
        viewPager.setOffscreenPageLimit(3);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {//position:0表示正中页，1表示右边，-1表示左边的
                Log.i("jm", "jm---transformPage:name "+page.getId()+" position="+position);
                if (position < -1)
                {
                    page.setAlpha(mMinAlpha);
                } else if (position <= 1)
                { // [-1,1]

                    if (position < 0) //[0，-1]
                    {
                        float factor = mMinAlpha + (1 - mMinAlpha) * (1 + position);
                        page.setAlpha(factor);
                    } else//[1，0]
                    {
                        float factor = mMinAlpha + (1 - mMinAlpha) * (1 - position);
                        page.setAlpha(factor);
                    }
                } else
                { // (1,+Infinity]
                    page.setAlpha(mMinAlpha);
                }
            }
        });

        //viewPager.setPageTransformer(false,new CustomPagerTransform());
        viewPager.setAdapter(viewPagerAdapter);



    }
}
