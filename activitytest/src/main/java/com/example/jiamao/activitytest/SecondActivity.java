package com.example.jiamao.activitytest;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jiamao on 2018/1/5.
 */

public class SecondActivity extends AppCompatActivity {

    private String TAG="lifetest_SecondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Log.e(TAG, "onCreate: " );
        ActivityInfo info= null;
        try {
            info = this.getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            String axtivity_msg=info.metaData.getString("ActivityMetaTest");
            System.out.println("ActivityMetaTest=:"+axtivity_msg);

            ApplicationInfo info2 = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            int msg=info2.metaData.getInt("ApplicationMetaTest");
            System.out.println("ApplicationMetaTest:"+msg);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
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
}