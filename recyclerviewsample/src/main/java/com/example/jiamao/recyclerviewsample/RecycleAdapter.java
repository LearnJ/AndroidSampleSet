package com.example.jiamao.recyclerviewsample;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by jiamao on 2017/12/28.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> implements ItemTouchHelperAdapter {


    private List<ItemInfo>itemLists;
    private View headView;
    private final int HEAD_VIEW_TYPE=1;
    private final int NORMAL_ITEM_TYPE=2;

    public RecycleAdapter(List<ItemInfo> itemLists) {
        this.itemLists = itemLists;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView textView;

        public ViewHolder(View view){
            super(view);
            if (view!=headView) {
                image = view.findViewById(R.id.image);
                textView = view.findViewById(R.id.text);
            }
        }
    }
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==HEAD_VIEW_TYPE)
            return new ViewHolder(headView);
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
       ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEAD_VIEW_TYPE)
            return;
        try {
            ItemInfo info = itemLists.get(getRealPosition(position));
            holder.textView.setText(info.getTitle());
            holder.image.setImageResource(info.getImgid());
        }catch (Exception e){
            Log.i("jm", "jm--onBindViewHolder: "+position);
        }

    }

    private int getRealPosition(int position){
        if (headView!=null){
            return position-1;
        }

        return position;
    }

    @Override
    public int getItemCount() {
        return headView==null?itemLists.size():itemLists.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (headView!=null&&(position==0)){
            return HEAD_VIEW_TYPE;
        }
        return NORMAL_ITEM_TYPE;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        if (getItemViewType(toPosition)==HEAD_VIEW_TYPE) //headView不可交换
            return;
        Collections.swap(itemLists,getRealPosition(fromPosition),getRealPosition(toPosition));
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
        //移除数据
        itemLists.remove(getRealPosition(position));
        notifyItemRemoved(position);
    }

    public void setHeaderView(View view){
        headView=view;
        notifyDataSetChanged();
    }

    public View getHeaderView(){
       return headView;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == HEAD_VIEW_TYPE
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(holder.getLayoutPosition() == 0);
        }

    }
}
