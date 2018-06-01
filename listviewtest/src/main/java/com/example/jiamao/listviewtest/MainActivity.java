package com.example.jiamao.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MsgInfo>msglists;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView= findViewById(R.id.list_view);

        initDatas();
        MListViewAdapter mListViewAdapter=new MListViewAdapter(this,msglists);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("clicked", "onItemClick: " );
                Toast.makeText(MainActivity.this,"click the listview: "+position+" id= "+id,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(mListViewAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e("scroll", "onScrollStateChanged: "+scrollState );
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                Log.e("scroll", "onScroll: "+ firstVisibleItem+" visibleItemCount: "+visibleItemCount+" totalItemCount "
                +totalItemCount);
            }
        });



//        listView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//            }
//        });
    }

    void initDatas(){
        msglists=new ArrayList<>();

        MsgInfo info1=new MsgInfo();
        info1.setIcon_id(R.mipmap.ic_launcher);
        info1.setView_type(1);
        info1.setMessage("hello");
        msglists.add(info1);

        MsgInfo info2=new MsgInfo();
        info2.setIcon_id(R.mipmap.ic_launcher);
        info2.setView_type(2);
        info2.setMessage("hello");
        msglists.add(info2);

        MsgInfo info3=new MsgInfo();
        info3.setIcon_id(R.mipmap.ic_launcher);
        info3.setView_type(1);
        info3.setMessage("hello");
        msglists.add(info3);

        MsgInfo info4=new MsgInfo();
        info4.setIcon_id(R.mipmap.ic_launcher);
        info4.setView_type(2);
        info4.setMessage("hello");
        msglists.add(info4);

        MsgInfo info5=new MsgInfo();
        info5.setIcon_id(R.mipmap.ic_launcher);
        info5.setView_type(1);
        info5.setMessage("hello");
        msglists.add(info5);

        MsgInfo info6=new MsgInfo();
        info6.setIcon_id(R.mipmap.ic_launcher);
        info6.setView_type(1);
        info6.setMessage("hello");
        msglists.add(info6);

        MsgInfo info7=new MsgInfo();
        info7.setIcon_id(R.mipmap.ic_launcher);
        info7.setView_type(2);
        info7.setMessage("hello");
        msglists.add(info7);

        MsgInfo info15=new MsgInfo();
        info15.setIcon_id(R.mipmap.ic_launcher);
        info15.setView_type(1);
        info15.setMessage("hello");
        msglists.add(info15);

        MsgInfo info16=new MsgInfo();
        info16.setIcon_id(R.mipmap.ic_launcher);
        info16.setView_type(1);
        info16.setMessage("hello");
        msglists.add(info16);

        MsgInfo info17=new MsgInfo();
        info17.setIcon_id(R.mipmap.ic_launcher);
        info17.setView_type(2);
        info17.setMessage("hello");
        msglists.add(info17);

        MsgInfo info115=new MsgInfo();
        info115.setIcon_id(R.mipmap.ic_launcher);
        info115.setView_type(1);
        info115.setMessage("hello");
        msglists.add(info115);

        MsgInfo info116=new MsgInfo();
        info116.setIcon_id(R.mipmap.ic_launcher);
        info116.setView_type(1);
        info116.setMessage("hello");
        msglists.add(info116);

        MsgInfo info117=new MsgInfo();
        info117.setIcon_id(R.mipmap.ic_launcher);
        info117.setView_type(2);
        info117.setMessage("hello");
        msglists.add(info117);

    }
}
