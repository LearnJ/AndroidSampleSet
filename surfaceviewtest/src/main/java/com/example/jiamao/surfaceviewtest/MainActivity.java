package com.example.jiamao.surfaceviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button loadBtn;
    private ImageView imageView;
    private SurfaceViewTemplate surfaceViewTemplate;
    private boolean change=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surfaceViewTemplate=new SurfaceViewTemplate(this);
        setContentView(surfaceViewTemplate);


        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (change) {
                    surfaceViewTemplate.setPaintColor(Color.RED);
                    change=false;
                }else{
                    change=true;
                    surfaceViewTemplate.setPaintColor(Color.YELLOW);
                }
            }
        },1000,1000);


    }
}
