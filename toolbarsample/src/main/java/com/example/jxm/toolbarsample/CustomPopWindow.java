package com.example.jxm.toolbarsample;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by jiamao on 2018/5/30.
 */

public class CustomPopWindow {

    public static void showPop(Activity context){

        View view=LayoutInflater.from(context).inflate(R.layout.custom_pop_layout,null);
        PopupWindow popupWindow=new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());//必须设置背景点击外部才会自动消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        final View rootView=((ViewGroup)context.findViewById(android.R.id.content)).getChildAt(0);
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
    }

}
