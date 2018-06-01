package com.example.jiamao.listviewtest;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by jiamao on 2018/1/2.
 */

public class MListViewAdapter extends BaseAdapter {

    private List<MsgInfo> msglist;

    private Context context;

    public MListViewAdapter(Context context,List<MsgInfo> msdlist) {
        this.context=context;
        this.msglist = msdlist;
    }

    @Override
    public int getCount() {
        return msglist.size();
    }

    @Override
    public Object getItem(int position) {
        return msglist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        MsgInfo info=msglist.get(position);
        if (convertView==null){

            viewHolder=new ViewHolder();

            if (info.getView_type()==1) {
                convertView=LayoutInflater.from(context).inflate(R.layout.left, null);
            }else{
                convertView=LayoutInflater.from(context).inflate(R.layout.right, null);
            }

            viewHolder.textView=convertView.findViewById(R.id.text);
            viewHolder.imageView=convertView.findViewById(R.id.image);
            viewHolder.button=convertView.findViewById(R.id.click);
            convertView.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(info.getMessage());
        viewHolder.imageView.setImageResource(info.getIcon_id());
//        viewHolder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "click the button", Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    private final class ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public Button button;

    }

}
