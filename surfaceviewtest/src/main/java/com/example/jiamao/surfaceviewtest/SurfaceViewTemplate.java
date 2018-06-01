package com.example.jiamao.surfaceviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by jiamao on 2018/1/2.
 */

public class SurfaceViewTemplate extends SurfaceView implements SurfaceHolder.Callback,Runnable {


    private SurfaceHolder mHolder;
    private Canvas mcanvas;
    private boolean isdrawing;

    private Paint mpaint;
    private int x=10;
    private int y;
    private Path path;
    {int x=10;}
    public SurfaceViewTemplate(Context context) {
        super(context);
        initView();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        path=new Path();

        isdrawing=true;
        mpaint=new Paint();
        mpaint.setColor(Color.BLUE);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(20f);
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        isdrawing=false;
    }

    @Override
    public void run() {

        while(isdrawing){
            draw();
        }

    }

   private void draw(){

        try {

            mcanvas=mHolder.lockCanvas();

            x++;
            y=(int)(100*Math.sin(2*x*Math.PI/180)+400);
            path.lineTo(x,y);
            //draw sth
            //mcanvas.drawColor(Color.WHITE);
            mcanvas.drawPath(path,mpaint);

        }catch(Exception e){

        }finally{
            if (mcanvas!=null)
            mHolder.unlockCanvasAndPost(mcanvas);
        }

    }

    private void initView(){

       int x=0;
        mHolder=getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
        x++;
    }

    public void setPaintColor(int color){
        mpaint.setColor(color);
    }
}
