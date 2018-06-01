package com.example.servicesample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MyService extends Service {

    private String tag="myservice";
    private MediaPlayer player=new MediaPlayer();
    private Mbinder mbinder=new Mbinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(tag, "onBind: ");
        return mbinder;
    }


    @Override
    public void onCreate() {
        Log.d(tag, "onCreate: ");
        super.onCreate();
        try {
            File file=new File(Environment.getExternalStorageDirectory(),"music.mp3");
            player.setDataSource(file.getPath());
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "onDestroy: ");
        super.onDestroy();
    }

    class Mbinder extends Binder {

        public void start(){
            player.start();
        }
        public void stop(){
            player.stop();
        }

    }

}
