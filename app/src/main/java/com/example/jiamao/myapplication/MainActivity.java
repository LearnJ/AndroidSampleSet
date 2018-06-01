package com.example.jiamao.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notic= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification=new NotificationCompat.Builder(MainActivity.this,"1").setContentText("tongzhhi")
                        .setContentTitle("title").setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setAutoCancel(true)
                        .build();
                notic.notify(1,notification);
                Log.e("notifiv", "onClick: 发送通知");

            }
        });

        Log.d("TAG", "onCreate: ");

    }
}
