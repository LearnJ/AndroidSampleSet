package com.example.jiamao.activitytest;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG="lifetest_MainActivity";
    private Button switchBtn;
    private Spinner mSpinner;
    private List<SpinnerData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchBtn=findViewById(R.id.jump);
        mSpinner=findViewById(R.id.spinner);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("mj.test.jump2activity");
                intent.addCategory("mj.test.category");
                startActivity(intent);
            }
        });


        initData();

        mSpinner.setAdapter(new MSpinnerAdapter(list,this));

        mSpinner.setSelection(list.size()-1);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: ");
    }



    void initData(){

        list=new ArrayList<>();
        for(int i=0;i<6;i++){
            SpinnerData data=new SpinnerData();
            data.setImgId(R.mipmap.ic_launcher);
            data.setStr("item "+i);
            list.add(data);

        }
        SpinnerData data=new SpinnerData();
        data.setImgId(R.mipmap.ic_launcher);
        data.setStr("默认提示");
        list.add(data);


    }


}
