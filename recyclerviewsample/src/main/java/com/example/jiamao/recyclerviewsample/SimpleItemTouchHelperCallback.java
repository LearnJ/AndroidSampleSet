package com.example.jiamao.recyclerviewsample;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by jiamao on 2018/5/30.
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback{

    private ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter adapter){
        mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //head view 不可滑动，拖动
        if (recyclerView.getAdapter().getItemViewType(viewHolder.getAdapterPosition())==1){
            return 0;
        }

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDissmiss(viewHolder.getAdapterPosition());
    }

//    @Override
//    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//
//        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//            final float alpha = 1 - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
//            //viewHolder.itemView.setAlpha(alpha);
//            //viewHolder.itemView.setTranslationX(dX);
//        }
//
//    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            final float alpha = 1 - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
        }
    }
}