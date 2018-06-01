package com.example.jiamao.viewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    ViewFlipper mflipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    
        mflipper=findViewById(R.id.fllipper);

        View a= LayoutInflater.from(this).inflate(R.layout.a,null);
        View b= LayoutInflater.from(this).inflate(R.layout.b,null);
        View c= LayoutInflater.from(this).inflate(R.layout.c,null);

        mflipper.addView(a) ;
        mflipper.addView(b) ;
        mflipper.addView(c) ;

        mflipper.setInAnimation(this, R.anim.in);
        mflipper.setOutAnimation(this, R.anim.out);
        mflipper.startFlipping();
    }
}
