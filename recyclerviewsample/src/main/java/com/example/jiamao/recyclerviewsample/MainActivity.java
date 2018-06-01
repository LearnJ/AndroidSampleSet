package com.example.jiamao.recyclerviewsample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<ItemInfo>itemList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        initDatas();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecycleAdapter myAdapter=new RecycleAdapter(itemList);
        recyclerView.scrollToPosition(1);
        recyclerView.addItemDecoration(new CustomItemDecoration());
        recyclerView.setAdapter(myAdapter);
        View headView= LayoutInflater.from(this).inflate(R.layout.head_view_layout,recyclerView,false);
        myAdapter.setHeaderView(headView);

        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setTitle("测试");
                progressDialog.setMessage("内容");
                progressDialog.setButton(DialogInterface.BUTTON1, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"点击了取消",Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.show();
                Toast.makeText(MainActivity.this,"点击了headerView",Toast.LENGTH_SHORT).show();
            }
        });
        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(myAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(recyclerView);

    }
    void initDatas(){
        for (int i=0;i<40;i++){

            ItemInfo info=new ItemInfo();
            info.setImgid(R.mipmap.ic_launcher);
            info.setTitle("测试"+i);
            itemList.add(info);

        }

    }




    class Madapter extends ArrayAdapter<ItemInfo>{
        private int resourceid;


        public Madapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ItemInfo[] objects) {
            super(context, resource, textViewResourceId, objects);
        }
    }
}
