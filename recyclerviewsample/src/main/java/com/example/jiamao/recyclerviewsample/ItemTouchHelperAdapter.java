package com.example.jiamao.recyclerviewsample;

/**
 * Created by jiamao on 2018/5/30.
 */

public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}
