package com.first.manoj.braintrainer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main3CActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView banner3c;
    private PublisherInterstitialAd backint,main3cint;

    Bundle bundle;
    Button sound_button, music_button, main_menu_button, game_menu_button, restart_button, resume_button, pause_button, cancel;
    int getLevel, getAddH, getAddL, getMultH, getMultL;
    int intSign, p, q, r, s, a, b, c, m, n;
    int right=0, total = 15, sec, lost,bestTime=9999;
    String pString, qString, rString, sString, ans1, ans2, ans3,levelType;
    char signDefault, sign, getType;
    Random rand;
    boolean yes = false;
    TextView question1, question2, question3, question4, question5, level, type, option, secs;
    Button button0, button1, button2, button3;
    Button buttons[];

    Timer timer;

    Dialog dialog,alertDialog;

    LinearLayout solution;

    Animation f1;

    Animation a1, a2, a3, a4, a5, b1, b2, b3, b4, b5;

    SharedPreferences shared,sharedTime,background;
    MediaPlayer marima,click,correct,incorrect;

    boolean addlevel1=false,addlevel2=false,addlevel3=false,
            sublevel1=false,sublevel2=false,sublevel3=false,
            mullevel1=false,mullevel2=false,mullevel3=false,
            divlevel1=false,divlevel2=false,divlevel3=false,
            mixlevel1=false,mixlevel2=false,mixlevel3=false,sound,music;

    int addBest0,addBest1,addBest2,addBest3,
        subBest0,subBest1,subBest2,subBest3,
        mulBest0,mulBest1,mulBest2,mulBest3,
        divBest0,divBest1,divBest2,divBest3,
        mixBest0,mixBest1,mixBest2,mixBest3;


    AdColonyInterstitialListener listener;
    AdColonyAdOptions options;
    AdColonyInterstitial ad;
    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3c);
        listener = new AdColonyInterstitialListener() {
            @Override
            public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
                ad=adColonyInterstitial;
            }
            @Override
            public void onClosed(AdColonyInterstitial ad) {
                startActivity(intent);
            }
        };

/** Set reward listener for your app to be alerted of reward events */

        AdColonyAppOptions appOptions = new AdColonyAppOptions()
                .setUserID("userid");

/** Pass options with user id set with configure */
        AdColony.configure(this, appOptions, "app4c5e42af01f84312b8", "vz69df3a3b6c2e47adaf");

        AdColony.setRewardListener(new AdColonyRewardListener() {
            @Override
            public void onReward(AdColonyReward adColonyReward) {

            }
        });


        options = new AdColonyAdOptions();

        AdColony.requestInterstitial("vz69df3a3b6c2e47adaf", listener);

        banner3c= (AdView) findViewById(R.id.banner3c);
        AdRequest request=new AdRequest.Builder().build();
        banner3c.loadAd(request);

        main3cint=new PublisherInterstitialAd(this);
        main3cint.setAdUnitId("ca-app-pub-1042832531270687/5854371224");
        main3cint.loadAd(new PublisherAdRequest.Builder().build());

        backint=new PublisherInterstitialAd(this);
        backint.setAdUnitId("ca-app-pub-1042832531270687/7119706652");
        backint.loadAd(new PublisherAdRequest.Builder().build());

        marima=MediaPlayer.create(this,R.raw.marima);
        marima.setLooping(true);
        click=MediaPlayer.create(this,R.raw.click);
        background=getSharedPreferences("background",MODE_PRIVATE);

        music=background.getBoolean("music",true);
        sound=background.getBoolean("sound",true);
        if(music)
            marima.start();

        bundle=getIntent().getExtras();

        correct=MediaPlayer.create(this,R.raw.right);
        incorrect=MediaPlayer.create(this,R.raw.wrong);



        shared=getSharedPreferences("0level",MODE_PRIVATE);
        sharedTime=getSharedPreferences("0best",MODE_PRIVATE);




        addBest0=sharedTime.getInt("0addbest0",9999);
        addBest1=sharedTime.getInt("0addbest1",9999);
        addBest2=sharedTime.getInt("0addbest2",9999);
        addBest3=sharedTime.getInt("0addbest3",9999);
        subBest0=sharedTime.getInt("0subbest0",9999);
        subBest1=sharedTime.getInt("0subbest1",9999);
        subBest2=sharedTime.getInt("0subbest2",9999);
        subBest3=sharedTime.getInt("0subbest3",9999);
        mulBest0=sharedTime.getInt("0mulbest0",9999);
        mulBest1=sharedTime.getInt("0mulbest1",9999);
        mulBest2=sharedTime.getInt("0mulbest2",9999);
        mulBest3=sharedTime.getInt("0mulbest3",9999);
        divBest0=sharedTime.getInt("0divbest0",9999);
        divBest1=sharedTime.getInt("0divbest1",9999);
        divBest2=sharedTime.getInt("0divbest2",9999);
        divBest3=sharedTime.getInt("0divbest3",9999);
        mixBest0=sharedTime.getInt("0mixbest0",9999);
        mixBest1=sharedTime.getInt("0mixbest1",9999);
        mixBest2=sharedTime.getInt("0mixbest2",9999);
        mixBest3=sharedTime.getInt("0mixbest3",9999);

        addlevel1=shared.getBoolean("0addlevel1",false);
        addlevel2=shared.getBoolean("0addlevel2",false);
        addlevel3=shared.getBoolean("0addlevel3",false);
        sublevel1=shared.getBoolean("0sublevel1",false);
        sublevel2=shared.getBoolean("0sublevel2",false);
        sublevel3=shared.getBoolean("0sublevel3",false);
        mullevel1=shared.getBoolean("0mullevel1",false);
        mullevel2=shared.getBoolean("0mullevel2",false);
        mullevel3=shared.getBoolean("0mullevel3",false);
        divlevel1=shared.getBoolean("0divlevel1",false);
        divlevel2=shared.getBoolean("0divlevel2",false);
        divlevel3=shared.getBoolean("0divlevel3",false);
        mixlevel1=shared.getBoolean("0mixlevel1",false);
        mixlevel2=shared.getBoolean("0mixlevel2",false);
        mixlevel3=shared.getBoolean("0mixlevel3",false);



        levelType=bundle.getString("levelType");
        getLevel = bundle.getInt("level", 0);
        getAddH = bundle.getInt("addH", 0);
        getAddL = bundle.getInt("addL", 0);
        getMultH = bundle.getInt("multH", 0);
        getMultL = bundle.getInt("multL", 0);
        getType = bundle.getChar("type", '?');

        secs = (TextView) findViewById(R.id.secs);
        sec = 0;
        lost = 0;

        option = (TextView) findViewById(R.id.option);

        solution = (LinearLayout) findViewById(R.id.solution);

        buttons = new Button[]{button0,button1,button2,button3};
        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);


        rand = new Random();
        bundle = getIntent().getExtras();

        getLevel = bundle.getInt("level", 0);
        getAddH = bundle.getInt("addH", 0);
        getAddL = bundle.getInt("addL", 0);
        getMultH = bundle.getInt("multH", 0);
        getMultL = bundle.getInt("multL", 0);

        getType = bundle.getChar("type", '?');

        question1 = (TextView) findViewById(R.id.question1);
        question2 = (TextView) findViewById(R.id.question2);
        question3 = (TextView) findViewById(R.id.question3);
        question4 = (TextView) findViewById(R.id.question4);
        question5 = (TextView) findViewById(R.id.question5);
        level = (TextView) findViewById(R.id.level);
        type = (TextView) findViewById(R.id.type);

        pause_button = (Button) findViewById(R.id.pause_button);
        dialog = new Dialog(this);

        for(int i=0;i<4;i++)
            buttons[i].setOnClickListener(this);


        f1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        b1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t1);
        b2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t2);
        b3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t3);
        b4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t4);
        b5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t5);

        a1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.q1);
        a2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.q2);
        a3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.q3);
        a4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.q4);
        a5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.q5);



        f1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                question1.startAnimation(a1);
                question2.startAnimation(a2);
                question3.startAnimation(a3);
                question4.startAnimation(a4);
                question5.startAnimation(a5);
                a1.setFillAfter(true);
                a2.setFillAfter(true);
                a3.setFillAfter(true);
                a4.setFillAfter(true);
                a5.setFillAfter(true);
                create();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        b5.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                question1.startAnimation(a1);
                question2.startAnimation(a2);
                question3.startAnimation(a3);
                question4.startAnimation(a4);
                question5.startAnimation(a5);
                a1.setFillAfter(true);
                a2.setFillAfter(true);
                a3.setFillAfter(true);
                a4.setFillAfter(true);
                a5.setFillAfter(true);
                create();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        create();

        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now();
                dialog.show();
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You Will Lose All Your Progress");
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (lost == 1){
                    marima.stop();
                    if (backint.isLoaded()) {
                        backint.show();
                    }
                    else{
                        startActivity(new Intent(Main3CActivity.this, Main2Activity.class));
                    }

                    backint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main3CActivity.this, Main2Activity.class));
                        }
                    });
                }

                else if (lost == 2){
                    marima.stop();
                    if (main3cint.isLoaded()) {
                        main3cint.show();
                    }
                    else{
                        startActivity(new Intent(Main3CActivity.this, Main3AActivity.class));
                    }

                    main3cint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main3CActivity.this, Main3AActivity.class));
                        }
                    });
                }

                else if (lost == 3) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        });
        builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog1, int which) {

                dialog.show();
            }
        });
        builder.setCancelable(false);
        alertDialog=builder.create();

        now();
    }

    public void now() {
        timer.cancel();
        dialog.setContentView(R.layout.sounds_layout);
        dialog.setCancelable(false);
        sound_button = (Button) dialog.findViewById(R.id.sound_button);
        music_button = (Button) dialog.findViewById(R.id.music_button);
        main_menu_button = (Button) dialog.findViewById(R.id.main_menu_button);
        game_menu_button = (Button) dialog.findViewById(R.id.game_menu_button);
        restart_button = (Button) dialog.findViewById(R.id.restart_button);
        resume_button = (Button) dialog.findViewById(R.id.resume_button);
        cancel = (Button) dialog.findViewById(R.id.cancel);

        music=background.getBoolean("music",true);
        if(music) {
            music_button.setBackgroundResource(R.drawable.music_button);
        }
        else{
            music_button.setBackgroundResource(R.drawable.no_sound_button);
        }

        sound=background.getBoolean("sound",true);
        if(sound) {
            sound_button.setBackgroundResource(R.drawable.sound_button);
        }
        else {
            sound_button.setBackgroundResource(R.drawable.no_sound_button);
        }


        music_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                music=background.getBoolean("music",true);
                if(music) {
                    music_button.setBackgroundResource(R.drawable.no_sound_button);
                    marima.pause();
                    music=background.edit().putBoolean("music",false).commit();
                }
                else{
                    music_button.setBackgroundResource(R.drawable.music_button);
                    marima.start();
                    music=background.edit().putBoolean("music",true).commit();
                }

            }
        });
        sound_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound=background.getBoolean("sound",true);
                if(sound) {
                    sound=background.edit().putBoolean("sound",false).commit();
                    sound_button.setBackgroundResource(R.drawable.no_sound_button);
                }
                else {
                    sound=background.edit().putBoolean("sound",true).commit();
                    sound_button.setBackgroundResource(R.drawable.sound_button);
                }
            }
        });
        main_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound)
                    click.start();
                lost = 1;
                alertDialog.show();
                dialog.dismiss();
            }
        });
        game_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound)
                    click.start();
                lost = 2;
                alertDialog.show();
                dialog.dismiss();
            }
        });
        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound)
                    click.start();
                lost = 3;
                alertDialog.show();
                dialog.dismiss();

            }
        });
        resume_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound)
                    click.start();
                dialog.dismiss();
                timerTask();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound)
                    click.start();
                dialog.dismiss();
                timerTask();
            }
        });

    }

    @Override
    public void onBackPressed() {
        now();
        dialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(marima.isPlaying())
            marima.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(music)
            marima.start();
    }

    public void create() {

        if(right==total){
            intent=new Intent(Main3CActivity.this,Main3DActivity.class);
            intent.putExtra("level",getLevel);
            intent.putExtra("type",getType);
            intent.putExtra("levelType",levelType);
            intent.putExtra("your",sec);
            boolean yes=false;



            switch(levelType){
                case "add":

                    if(getLevel==0){
                        yes=shared.getBoolean("0addlevel1",false);
                        shared.edit().putBoolean("0addlevel1",true).commit();
                        intent.putExtra("best",addBest0);
                        if(sec<addBest0)

                            sharedTime.edit().putInt("0addbest0",sec).commit();
                    }
                    else if(getLevel==1){
                        yes=shared.getBoolean("0addlevel2",false);
                        shared.edit().putBoolean("0addlevel2",true).commit();
                        intent.putExtra("best",addBest1);
                        if(sec<addBest1)
                            sharedTime.edit().putInt("0addbest1",sec).commit();
                    }
                    else if(getLevel==2){
                        yes=shared.getBoolean("0addlevel3",false);
                        shared.edit().putBoolean("0addlevel3",true).commit();
                        intent.putExtra("best",addBest2);
                        if(sec<addBest2)
                            sharedTime.edit().putInt("0addbest2",sec).commit();
                    }
                    else if(getLevel==3){
                        intent.putExtra("best",addBest3);
                        if(sec<addBest3)
                            sharedTime.edit().putInt("0addbest3",sec).commit();
                    }
                    break;
                case "sub":
                    if(getLevel==0){
                        yes=shared.getBoolean("0sublevel1",false);
                        shared.edit().putBoolean("0sublevel1",true).commit();
                        intent.putExtra("best",subBest0);
                        if(sec<subBest0)
                            sharedTime.edit().putInt("0subbest0",sec).commit();
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("0sublevel2",false);
                        shared.edit().putBoolean("0sublevel2",true).commit();
                        intent.putExtra("best",subBest1);
                        if(sec<subBest1)
                            sharedTime.edit().putInt("0subbest1",sec).commit();
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("0sublevel3",false);
                        shared.edit().putBoolean("0sublevel3",true).commit();

                        intent.putExtra("best",subBest2);
                        if(sec<subBest2)
                            sharedTime.edit().putInt("0subbest2",sec).commit();
                    }
                    if(getLevel==3){
                        intent.putExtra("best",subBest3);
                        if(sec<subBest3)
                            sharedTime.edit().putInt("0subbest3",sec).commit();
                    }

                    break;

                case "mul":
                    if(getLevel==0){
                        yes=shared.getBoolean("0mullevel1",false);
                        shared.edit().putBoolean("0mullevel1",true).commit();
                        intent.putExtra("best",mulBest0);
                        if(sec<mulBest0)
                            sharedTime.edit().putInt("0mulbest0",sec).commit();
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("0mullevel2",false);
                        shared.edit().putBoolean("0mullevel2",true).commit();

                        intent.putExtra("best",mulBest1);
                        if(sec<mulBest1)
                            sharedTime.edit().putInt("0mulbest1",sec).commit();
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("0mullevel3",false);
                        shared.edit().putBoolean("0mullevel3",true).commit();

                        intent.putExtra("best",mulBest2);
                        if(sec<mulBest2)
                            sharedTime.edit().putInt("0mulbest2",sec).commit();
                    }
                    if(getLevel==3){
                        intent.putExtra("best",mulBest3);
                        if(sec<mulBest3)
                            sharedTime.edit().putInt("0mulbest3",sec).commit();
                    }

                    break;
                case "div":
                    if(getLevel==0){
                        yes=shared.getBoolean("0divlevel1",false);
                        shared.edit().putBoolean("0divlevel1",true).commit();
                        intent.putExtra("best",divBest0);
                        if(sec<divBest0)
                            sharedTime.edit().putInt("0divbest0",sec).commit();
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("0divlevel2",false);
                        shared.edit().putBoolean("0divlevel2",true).commit();
                        intent.putExtra("best",divBest1);
                        if(sec<divBest1)
                            sharedTime.edit().putInt("0divbest1",sec).commit();
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("0divlevel3",false);
                        shared.edit().putBoolean("0divlevel3",true).commit();
                        intent.putExtra("best",divBest2);
                        if(sec<divBest2)
                            sharedTime.edit().putInt("0divbest2",sec).commit();
                    }
                    if(getLevel==3){
                        intent.putExtra("best",divBest3);
                        if(sec<divBest3)
                            sharedTime.edit().putInt("0divbest3",sec).commit();
                    }

                    break;
                case "mix":
                    if(getLevel==0){
                        yes=shared.getBoolean("0mixlevel1",false);
                        shared.edit().putBoolean("0mixlevel1",true).commit();
                        intent.putExtra("best",mixBest0);
                        if(sec<mixBest0)
                            sharedTime.edit().putInt("0mixbest0",sec).commit();
                    }
                    else if(getLevel==1){
                        yes=shared.getBoolean("0mixlevel2",false);
                        shared.edit().putBoolean("0mixlevel2",true).commit();
                        intent.putExtra("best",mixBest1);
                        if(sec<mixBest1)
                            sharedTime.edit().putInt("0mixbest1",sec).commit();
                    }
                    else if(getLevel==2){
                        yes=shared.getBoolean("0mixlevel3",false);
                        shared.edit().putBoolean("0mixlevel3",true).commit();
                        intent.putExtra("best",mixBest2);
                        if(sec<mixBest2)
                            sharedTime.edit().putInt("0mixbest2",sec).commit();
                    }
                    else if(getLevel==3){
                        intent.putExtra("best",mixBest3);
                        if(sec<mixBest3)
                            sharedTime.edit().putInt("0mixbest3",sec).commit();
                    }

                    break;
            }
            intent.putExtra("yes",yes);
            intent.putExtra("act","Main3CActivity");
            intent.putExtra("onback","Main3AActivity");

            marima.stop();

            if (ad!=null) {
                ad.show();
            }
            else{
                startActivity(intent);
            }

        }

        timerTask();

        for (int i = 0; i < 4; i++)
            buttons[i].setEnabled(true);
        if (p == 0)
            option.setText(String.valueOf(right + "/" + total));
        else
            option.setText(String.valueOf(right + "/" + total));


        solution.setBackgroundResource(0);

        if (getType == '?') {
            type.setText("RANDOM");
            System.out.println("yes");
            intSign = rand.nextInt(4);
            if (intSign == 0)
                sign = '+';
            else if (intSign == 1)
                sign = '-';
            else if (intSign == 2)
                sign = '×';
            else if (intSign == 3)
                sign = '÷';
        } else
            sign = getType;

        if (getType == '+')
            type.setText("ADDITION");
        else if (getType == '-')
            type.setText("SUBTRACTION");
        else if (getType == '×')
            type.setText("MULTIPLICATION");
        else if (getType == '÷')
            type.setText("DIVIDE");

        if (getLevel == 0)
            level.setText("BEGINNER");
        else if (getLevel == 1)
            level.setText("INTERMEDIATE");
        else if (getLevel == 2)
            level.setText("ADVANCE");
        else if (getLevel == 1)
            level.setText("EXPERT");

        intSign = rand.nextInt(2);
        if (intSign == 0)
            signDefault = '+';
        else if (intSign == 1)
            signDefault = '-';

        p = rand.nextInt(getAddH + 1 - getAddL) + getAddL;


        a = rand.nextInt(2);
        m = rand.nextInt(4);
        n = rand.nextInt(2);

        if (sign == '+') {
            q = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            r = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
        } else if (sign == '-') {
            q = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            r = rand.nextInt(q + 1 - getAddL) + getAddL;
        } else if (sign == '÷') {
            r = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            q = (rand.nextInt(getMultH + 1 - 2) + 2) * r;
        } else {
            q = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            r = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
        }

        pString = String.valueOf(p);
        qString = String.valueOf(q);
        rString = String.valueOf(r);

        if (getLevel > 0) {
            if (a == 1) {
                b = rand.nextInt(2);
                c = rand.nextInt(2);

                if (b == 1) {
                    q = -q;
                    qString = "(" + q + ")";
                }
                if (c == 1) {
                    r = -r;
                    rString = "(" + r + ")";
                }
            }
        }

        if (getLevel == 3) {
            question1.setText(pString);
            question2.setText(String.valueOf(signDefault));
            question3.setText("(" + qString);
            question4.setText(String.valueOf(sign));
            question5.setText(rString + ")");

            if (sign == '+')
                ans1 = String.valueOf(q + r);
            else if (sign == '-')
                ans1 = String.valueOf(q - r);
            else if (sign == '×')
                ans1 = String.valueOf(q * r);
            else if (sign == '÷')
                ans1 = String.valueOf(q / r);

            if (signDefault == '+')
                ans1 = String.valueOf(p + Integer.parseInt(ans1));
            else if (signDefault == '-') {
                ans1 = String.valueOf(p - Integer.parseInt(ans1));
            }

        } else {
            question2.setText(qString);
            question3.setText(String.valueOf(sign));
            question4.setText(rString);

            if (sign == '+')
                ans1 = String.valueOf(q + r);
            else if (sign == '-')
                ans1 = String.valueOf(q - r);
            else if (sign == '×')
                ans1 = String.valueOf(q * r);
            else if (sign == '÷')
                ans1 = String.valueOf(q / r);
        }

        for (int i = 0; i < 4; i++) {
            if (i == m) {
                buttons[i].setText(ans1);
            } else {
                buttons[i].setText(generate());
                for (int j = 0; j < i; j++) {
                    if (buttons[j].getText().toString() == (buttons[i].getText().toString()) && i >= 0) {
                        Log.v("yes", "happening");
                        i--;
                        continue;
                    }
                }
            }
        }

    }

    public String generate() {
        s = rand.nextInt(12) + 1;
        if (n == 0) {
            s = Integer.parseInt(ans1) + s;
        } else if (n == 1) {
            s = Integer.parseInt(ans1) - s;
        }
        sString = String.valueOf(s);
        return sString;
    }

    @Override
    public void onClick(View v) {
        timer.cancel();
        for (int i = 0; i < 4; i++)
            buttons[i].setEnabled(false);
        int a = Integer.parseInt((String) v.getTag());
        if (a == m) {
            if(sound)
                correct.start();
            right++;
            question1.startAnimation(f1);
            question2.startAnimation(f1);
            question3.startAnimation(f1);
            question4.startAnimation(f1);
            question5.startAnimation(f1);
            f1.setFillAfter(true);
            solution.setBackgroundResource(R.drawable.correct);
        } else {
            if(sound)
                incorrect.start();
            question1.startAnimation(b1);
            question2.startAnimation(b2);
            question3.startAnimation(b3);
            question4.startAnimation(b4);
            question5.startAnimation(b5);
            b1.setFillAfter(true);
            b2.setFillAfter(true);
            b3.setFillAfter(true);
            b4.setFillAfter(true);
            b5.setFillAfter(true);
            solution.setBackgroundResource(R.drawable.incorrect);
        }
    }


    public void timerTask(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sec = sec + 1;
                        secs.setText(String.valueOf(sec + " s"));

                    }
                });
            }
        }, 1000, 1000);

    }

}
