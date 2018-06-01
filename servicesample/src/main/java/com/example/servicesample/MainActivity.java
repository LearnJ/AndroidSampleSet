package com.example.servicesample;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startService;
    Button stopService;
    Button bindService;
    Button unbindService;
    Button play;
    Button pause;
    MyService.Mbinder mbinder;
    public String tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService =findViewById(R.id.send1);
        startService =findViewById(R.id.send2);
        startService =findViewById(R.id.send3);
        startService =findViewById(R.id.send4);
        play =findViewById(R.id.play);
        pause =findViewById(R.id.pause);


        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else {
            Log.d(tag, "onCreate: 没有授权");
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send1:
                Intent message=new Intent();
                message.setAction("android.intent.action.myBroadcast");
                message.addCategory("android.intent.category.LAUNCHER");
                sendBroadcast(message);

                Intent start=new Intent(MainActivity.this,MyService.class);
                startService(start);

                break;
            case R.id.send2:
                Intent stop=new Intent(MainActivity.this,MyService.class);
                stopService(stop);

                break;
            case R.id.send3:
                Intent bind=new Intent(MainActivity.this,MyService.class);
                bindService(bind,connection,BIND_AUTO_CREATE);

                break;
            case R.id.send4:
                unbindService(connection);
                break;

            case R.id.play:
               
                mbinder.start();
                break;
            case R.id.pause:
                mbinder.stop();
                break;

        }
    }

    ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(tag, "onServiceConnected: ");
            mbinder=(MyService.Mbinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(tag, "onServiceDisconnected: ");
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case  1:
                if (grantResults.length>0&&grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"拒绝将无法使用",Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
