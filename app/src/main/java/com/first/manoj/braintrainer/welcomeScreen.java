package com.first.manoj.braintrainer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class welcomeScreen extends AppCompatActivity {

    ImageView addd,subb,mull,divv;
    TextView text,manoj;

    MediaPlayer flyby;
    MediaPlayer name;

    boolean music=false,yes=true;
    SharedPreferences background;

    public welcomeScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        background=getSharedPreferences("background",MODE_PRIVATE);
        music=background.getBoolean("music",true);

        addd=(ImageView)findViewById(R.id.addd);
        subb=(ImageView)findViewById(R.id.subb);
        mull=(ImageView)findViewById(R.id.mull);
        divv=(ImageView)findViewById(R.id.divv);
        text=(TextView)findViewById(R.id.text);
        manoj=(TextView)findViewById(R.id.manoj);

        flyby=MediaPlayer.create(this,R.raw.flyby);
        flyby.setLooping(true);
        name=MediaPlayer.create(this,R.raw.name);

        Animation animationLT= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right);
        Animation animationRT= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_down);
        Animation animationL= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left);
        Animation animationU= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_up);
        final Animation name_my= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.name);
        Animation my= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.manoj);



        addd.startAnimation(animationLT);
        if(music)
            flyby.start();
        animationLT.setFillAfter(true);

        subb.startAnimation(animationRT);

        animationRT.setFillAfter(true);

        mull.startAnimation(animationL);
        animationL.setFillAfter(true);

        divv.startAnimation(animationU);
        animationU.setFillAfter(true);

        text.startAnimation(name_my);
        name_my.setFillAfter(true);

        manoj.startAnimation(my);


        Runnable r=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait(3900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(music)
                        if(yes)
                        name.start();
                }
            }
        };
        Thread t=new Thread(r);
        t.start();


        animationL.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flyby.stop();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        name_my.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        flyby.release();
        yes=false;
        finishAffinity();
    }
}
