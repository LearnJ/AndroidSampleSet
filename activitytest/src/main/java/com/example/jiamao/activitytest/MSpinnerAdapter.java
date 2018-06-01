package com.example.jiamao.activitytest;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiamao on 2018/1/5.
 */

public class MSpinnerAdapter extends BaseAdapter {

    private List<SpinnerData>list;

    private Context context;

    public MSpinnerAdapter(List<SpinnerData> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size()-1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SpinnerData info=list.get(position);
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.spinner_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.drop_image);
        imageView.setImageResource(info.getImgId());
        TextView textView=convertView.findViewById(R.id.drop_text);
        textView.setText(info.getStr());



        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ImageView view=new ImageView(context);
        view.setImageResource(R.mipmap.ic_launcher);

        return view ;
    }


    class MySpinnerAdapter2 implements SpinnerAdapter{

        //下来列表的view
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        //点击前的spinner view
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
