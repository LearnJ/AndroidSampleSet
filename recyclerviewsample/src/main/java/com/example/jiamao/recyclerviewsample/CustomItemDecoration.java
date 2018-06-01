package com.example.jiamao.recyclerviewsample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jiamao on 2018/6/1.
 */

public class CustomItemDecoration extends RecyclerView.ItemDecoration {

    private static final int HEAD_VIEW_TYPE=1;
    private boolean hasHeadView=false;
    Paint mPaint;
    public CustomItemDecoration() {
        super();
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);

    }

    /**
     *在itemView绘制之前绘制，所以要通过getItemOffsets设置好距离，留出空间，防止被后绘得的itemView覆盖掉
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
//        int childCount = parent.getChildCount();
//        for ( int i = 0; i < childCount; i++ ) {
//            View view = parent.getChildAt(i);
//            int index = parent.getChildAdapterPosition(view);
//            float top = view.getBottom();
//            float extra=view.getHeight()/2;
//            c.drawCircle(50, top+extra,20,mPaint);
//        }
    }

    /**
     * 在itemVie上面绘制，根据设计，使用canvas进行绘制即可
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();//当前可见的Item数，并不一定是全部
        for ( int i = 0; i < childCount; i++ ) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);//获取adpter中对应的位置，获取item类型要使用它
            if (parent.getAdapter().getItemViewType(index)==HEAD_VIEW_TYPE)//headView不绘制
                continue;
            float top = view.getTop();
            float left=view.getLeft();
            float right = view.getRight();
            float bottom=view.getBottom();
            float extra=view.getHeight()/2;
            c.drawCircle(left-20, top+extra,20,mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setTextSize(15);
            mPaint.setStrokeWidth(1);
            Rect rect=new Rect();
            mPaint.getTextBounds(i+"",0,(i+"").length(),rect);

            c.drawText(i+"",left-20-rect.width()/2,top+extra+rect.height()/2,mPaint);
            c.drawRect(left-10,top-10,right+10,bottom+10,mPaint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position=parent.getChildAdapterPosition(view);

        if (parent.getAdapter().getItemViewType(position)!=HEAD_VIEW_TYPE)
            {
                outRect.top = 30;
                outRect.left=30;
        }
    }
}
