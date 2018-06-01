package com.example.jiamao.glidetest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class MainActivity extends AppCompatActivity {

    private Button loadBtn;
    private ImageView imageView;
    private Button playBtn;
    private Button playBtn2;
    private Button playBtn3;
    private Button playBtn4;
    private Button cancelBtn;

    private Button playBtn5;
    AnimatorSet animatorSet;

    final SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            // do something with the bitmap
            // for demonstration purposes, let's just set it to an ImageView
            Log.d("glide", "onResourceReady: " + bitmap);
            System.out.println("jm---onclick----setbitmap");
            Toast.makeText(MainActivity.this, "get the bitmap", Toast.LENGTH_SHORT).show();
            imageView.setImageBitmap(bitmap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadBtn=findViewById(R.id.load);
        imageView=findViewById(R.id.display);
        playBtn=findViewById(R.id.play);
        playBtn2=findViewById(R.id.play2);
        playBtn3=findViewById(R.id.play3);
        playBtn4=findViewById(R.id.play4);
        cancelBtn=findViewById(R.id.cancel);
        playBtn5=findViewById(R.id.play5);

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(MainActivity.this)
                        .load("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg")
                        .crossFade(1000)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.drawable.error)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(target);
                Log.e("jiazai", "onClick: " );
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ObjectAnimator anim=ObjectAnimator.ofFloat(imageView,"alpha",0f,1f);
                         anim.setDuration(1000);
                         anim.setInterpolator(new AccelerateInterpolator());
                         anim.addListener(new Animator.AnimatorListener() {
                             @Override
                             public void onAnimationStart(Animator animation) {
                                 Log.d("ObjectAnimator", "onAnimationStart: ");

                             }

                             @Override
                             public void onAnimationEnd(Animator animation) {
                                 Log.d("ObjectAnimator", "onAnimationEnd: ");

                             }

                             @Override
                             public void onAnimationCancel(Animator animation) {
                                 Log.d("ObjectAnimator", "onAnimationCancel: ");

                             }

                             @Override
                             public void onAnimationRepeat(Animator animation) {
                                 Log.d("ObjectAnimator", "onAnimationRepeat: ");

                             }
                         });
                         anim.setRepeatCount(-1);
                         anim.setRepeatMode(ValueAnimator.REVERSE);

                         anim.start();
            }
        });


        playBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder pvh=PropertyValuesHolder.ofFloat("x",0f,100);
                PropertyValuesHolder pvh1=PropertyValuesHolder.ofFloat("y",0f,100);

                ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(imageView,pvh,pvh1);
                animator.setDuration(2000).start();
            }
        });

        playBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet=new AnimatorSet();

                ObjectAnimator anim = ObjectAnimator .ofFloat(imageView, "rotationX", 0f, 180f);
                anim.setDuration(2000);
                ObjectAnimator anim2 = ObjectAnimator .ofFloat(imageView, "rotationX", 180f, 0f);
                anim2.setDuration(2000);
                ObjectAnimator anim3 = ObjectAnimator .ofFloat(imageView, "rotationY", 0f, 180f);
                anim3.setDuration(2000);
                ObjectAnimator anim4 = ObjectAnimator .ofFloat(imageView, "rotationY", 180f, 0f);
                anim4.setDuration(2000);

                animatorSet.play(anim).with(anim3).with(anim4);
                animatorSet.play(anim2).after(anim3);
                animatorSet.start();



            }
        });



        playBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator animator=ObjectAnimator.ofInt(playBtn4,"backgroundColor", Color.RED,Color.BLUE);
                animator.setDuration(2000);

                animator.setEvaluator(new ArgbEvaluator());
                animator.start();


                RotateAnimation ra=new RotateAnimation(0,60,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                ra.setDuration(2000);
                ra.setFillAfter(true);
                playBtn3.startAnimation(ra);

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //animatorSet.cancel();

                if (animatorSet.isRunning()){
                    animatorSet.pause();
                }else{
                    animatorSet.reverse();
                }


                ValueAnimator vm=ValueAnimator.ofFloat(1,500);
                vm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float length =(float)animation.getAnimatedValue();

                        playBtn.setTranslationX(length);


                        playBtn2.setText("当前值："+length+"  "+ Build.BRAND);
                    }
                });
                vm.setDuration(2000);
                vm.start();

            }
        });


        playBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator= AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animatortest);

                animator.setTarget(playBtn5);


                animator.start();
            }
        });

    }
}
