package com.first.manoj.braintrainer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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

public class Main6CActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView banner6c;
    private PublisherInterstitialAd backint,main6cint;

    Bundle bundle;
    int getLevel, getAddH, getAddL, getMultH, getMultL;
    int intSign, p, q, r, s, a, b, c, m, n;
    String pString, qString, rString, sString, ans1, ans2, ans3,levelType;
    StringBuilder sf;
    Random rand;
    TextView question1, question2, question3, question4, question5,level, type,secs,option,result;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;

    Button buttons[];

    Button sound_button, music_button, main_menu_button, game_menu_button, restart_button, resume_button, pause_button, cancel;

    int right,total=15,sec,lost;
    Timer timer;
    Dialog dialog,alertDialog;

    Animation f1;

    Animation a1, a2, a3, a4, a5, b1, b2, b3, b4, b5;

    char signDefault, sign, getType;

    SharedPreferences shared,sharedTime,background;
    MediaPlayer marima,click,correct,incorrect;


    boolean addlevel1=false,addlevel2=false,addlevel3=false,
            sublevel1=false,sublevel2=false,sublevel3=false,
            mullevel1=false,mullevel2=false,mullevel3=false,
            divlevel1=false,divlevel2=false,divlevel3=false,
            mixlevel1=false,mixlevel2=false,mixlevel3=false,sound,music;

    int     addBest0,addBest1,addBest2,addBest3,
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
        setContentView(R.layout.activity_main6c);

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

        banner6c= (AdView) findViewById(R.id.banner6c);
        AdRequest request=new AdRequest.Builder().build();
        banner6c.loadAd(request);
        main6cint=new PublisherInterstitialAd(this);
        main6cint.setAdUnitId("ca-app-pub-1042832531270687/5854371224");
        main6cint.loadAd(new PublisherAdRequest.Builder().build());

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

        correct=MediaPlayer.create(this,R.raw.right);
        incorrect=MediaPlayer.create(this,R.raw.wrong);


        bundle=getIntent().getExtras();

        shared=getSharedPreferences("3level",MODE_PRIVATE);

        sharedTime=getSharedPreferences("3best",MODE_PRIVATE);

        addBest0=sharedTime.getInt("3addbest0",9999);
        addBest1=sharedTime.getInt("3addbest1",9999);
        addBest2=sharedTime.getInt("3addbest2",9999);
        addBest3=sharedTime.getInt("3addbest3",9999);
        subBest0=sharedTime.getInt("3subbest0",9999);
        subBest1=sharedTime.getInt("3subbest1",9999);
        subBest2=sharedTime.getInt("3subbest2",9999);
        subBest3=sharedTime.getInt("3subbest3",9999);
        mulBest0=sharedTime.getInt("3mulbest0",9999);
        mulBest1=sharedTime.getInt("3mulbest1",9999);
        mulBest2=sharedTime.getInt("3mulbest2",9999);
        mulBest3=sharedTime.getInt("3mulbest3",9999);
        divBest0=sharedTime.getInt("3divbest0",9999);
        divBest1=sharedTime.getInt("3divbest1",9999);
        divBest2=sharedTime.getInt("3divbest2",9999);
        divBest3=sharedTime.getInt("3divbest3",9999);
        mixBest0=sharedTime.getInt("3mixbest0",9999);
        mixBest1=sharedTime.getInt("3mixbest1",9999);
        mixBest2=sharedTime.getInt("3mixbest2",9999);
        mixBest3=sharedTime.getInt("3mixbest3",9999);


        addlevel1=shared.getBoolean("3addlevel1",false);
        addlevel2=shared.getBoolean("3addlevel2",false);
        addlevel3=shared.getBoolean("3addlevel3",false);
        sublevel1=shared.getBoolean("3sublevel1",false);
        sublevel2=shared.getBoolean("3sublevel2",false);
        sublevel3=shared.getBoolean("3sublevel3",false);
        mullevel1=shared.getBoolean("3mullevel1",false);
        mullevel2=shared.getBoolean("3mullevel2",false);
        mullevel3=shared.getBoolean("3mullevel3",false);
        divlevel1=shared.getBoolean("3divlevel1",false);
        divlevel2=shared.getBoolean("3divlevel2",false);
        divlevel3=shared.getBoolean("3divlevel3",false);
        mixlevel1=shared.getBoolean("3mixlevel1",false);
        mixlevel2=shared.getBoolean("3mixlevel2",false);
        mixlevel3=shared.getBoolean("3mixlevel3",false);

        levelType=bundle.getString("levelType");

        buttons = new Button[]{button0, button3, button2, button3,button4,button5,button6,button7,button8,button9,button10,button11};
        pause_button= (Button) findViewById(R.id.pause_button);


        secs = (TextView) findViewById(R.id.secs);
        sec = 0;
        lost = 0;

        rand = new Random();
        bundle = getIntent().getExtras();

        sf = new StringBuilder("");


        result = (TextView) findViewById(R.id.result);
        option= (TextView) findViewById(R.id.options);


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

        buttons[0]= (Button) findViewById(R.id.button0);
        buttons[1]= (Button) findViewById(R.id.button1);
        buttons[2]= (Button) findViewById(R.id.button2);
        buttons[3]= (Button) findViewById(R.id.button3);
        buttons[4]= (Button) findViewById(R.id.button4);
        buttons[5]= (Button) findViewById(R.id.button5);
        buttons[6]= (Button) findViewById(R.id.button6);
        buttons[7]= (Button) findViewById(R.id.button7);
        buttons[8]= (Button) findViewById(R.id.button8);
        buttons[9]= (Button) findViewById(R.id.button9);
        buttons[10]=(Button) findViewById(R.id.button10);
        buttons[11]=(Button) findViewById(R.id.button11);

        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttons[10].setOnClickListener(this);
        buttons[11].setOnClickListener(this);

        pause_button = (Button) findViewById(R.id.pause_button);
        dialog = new Dialog(this);

        f1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        b1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u1);
        b2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u2);
        b3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u3);
        b4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u4);
        b5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u5);

        if (getType == '+')
            type.setText("ADDITION");
        else if (getType == '-')
            type.setText("SUBTRACTION");
        else if (getType == '×')
            type.setText("MULTIPLICATION");
        else if (getType == '÷')
            type.setText("DIVIDE");
        else
            type.setText("RANDOM");

        if (getLevel == 0)
            level.setText("BEGINNER");
        else if (getLevel == 1)
            level.setText("INTERMEDIATE");
        else if (getLevel == 2)
            level.setText("ADVANCE");
        else if (getLevel == 1)
            level.setText("EXPERT");


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You Will Lose All Your Progress");
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (lost == 1) {
                    marima.stop();
                    if (backint.isLoaded()) {
                        backint.show();
                    }
                    else{
                        startActivity(new Intent(Main6CActivity.this, Main2Activity.class));
                    }

                    backint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main6CActivity.this, Main2Activity.class));
                        }
                    });
                }
                else if (lost == 2){
                    if (main6cint.isLoaded()) {
                        main6cint.show();
                    }
                    else{
                        startActivity(new Intent(Main6CActivity.this, Main6AActivity.class));
                    }

                    main6cint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main6CActivity.this, Main6AActivity.class));
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

        f1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
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
                create();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now();
                dialog.show();
            }
        });



        create();
    }

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
                lost = 1;
                alertDialog.show();
                dialog.dismiss();
            }
        });
        game_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lost = 2;
                alertDialog.show();
                dialog.dismiss();
            }
        });
        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lost = 3;
                alertDialog.show();
                dialog.dismiss();

            }
        });
        resume_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                timerTask();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                timerTask();
            }
        });

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

    public void onBackPressed() {
        now();
        dialog.show();
    }

    public void create() {

        if(right==total){
            intent=new Intent(Main6CActivity.this,Main3DActivity.class);
            intent.putExtra("level",getLevel);
            intent.putExtra("type",getType);
            intent.putExtra("levelType",levelType);
            intent.putExtra("your",sec);
            boolean yes=false;

            switch(levelType){
                case "add":

                    if(getLevel==0){
                        yes=shared.getBoolean("3addlevel1",false);
                        shared.edit().putBoolean("3addlevel1",true).commit();
                        intent.putExtra("best",addBest0);
                        if(sec<addBest0)
                            sharedTime.edit().putInt("3addbest0",sec);
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("3addlevel2",false);
                        shared.edit().putBoolean("3addlevel2",true).commit();
                        intent.putExtra("best",addBest1);
                        if(sec<addBest1)
                            sharedTime.edit().putInt("3addbest1",sec);
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("3addlevel3",false);
                        shared.edit().putBoolean("3addlevel3",true).commit();
                        intent.putExtra("best",addBest2);
                        if(sec<addBest2)
                            sharedTime.edit().putInt("3addbest2",sec);
                    }
                    if(getLevel==3){
                        intent.putExtra("best",addBest3);
                        if(sec<addBest3)
                            sharedTime.edit().putInt("3addbest3",sec);
                    }
                    break;
                case "sub":
                    if(getLevel==0){
                        yes=shared.getBoolean("3sublevel1",false);
                        shared.edit().putBoolean("3sublevel1",true).commit();
                        intent.putExtra("best",subBest0);
                        if(sec<subBest0)
                            sharedTime.edit().putInt("3subbest0",sec);
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("3sublevel2",false);
                        shared.edit().putBoolean("3sublevel2",true).commit();
                        intent.putExtra("best",subBest1);
                        if(sec<subBest1)
                            sharedTime.edit().putInt("3subbest1",sec);
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("3sublevel3",false);
                        shared.edit().putBoolean("3sublevel3",true).commit();
                        intent.putExtra("best",subBest2);
                        if(sec<subBest2)
                            sharedTime.edit().putInt("3subbest2",sec);
                    }
                    if(getLevel==3){
                        intent.putExtra("best",subBest3);
                        if(sec<subBest3)
                            sharedTime.edit().putInt("3subbest3",sec);
                    }

                    break;

                case "mul":
                    if(getLevel==0){
                        yes=shared.getBoolean("3mullevel1",false);
                        shared.edit().putBoolean("3mullevel1",true).commit();
                        intent.putExtra("best",mulBest0);
                        if(sec<mulBest0)
                            sharedTime.edit().putInt("3mulbest0",sec);
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("3mullevel2",false);
                        shared.edit().putBoolean("3mullevel2",true).commit();
                        intent.putExtra("best",mulBest1);
                        if(sec<mulBest1)
                            sharedTime.edit().putInt("3mulbest1",sec);
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("3mullevel3",false);
                        shared.edit().putBoolean("3mullevel3",true).commit();
                        intent.putExtra("best",mulBest2);
                        if(sec<mulBest2)
                            sharedTime.edit().putInt("3mulbest2",sec);
                    }
                    if(getLevel==3){
                        intent.putExtra("best",mulBest3);
                        if(sec<mulBest3)
                            sharedTime.edit().putInt("3mulbest3",sec);
                    }

                    break;
                case "div":
                    if(getLevel==0){
                        yes=shared.getBoolean("3divlevel1",false);
                        shared.edit().putBoolean("3divlevel1",true).commit();
                        intent.putExtra("best",divBest0);
                        if(sec<divBest0)
                            sharedTime.edit().putInt("3divbest0",sec);
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("3divlevel2",false);
                        shared.edit().putBoolean("3divlevel2",true).commit();
                        intent.putExtra("best",divBest1);
                        if(sec<divBest1)
                            sharedTime.edit().putInt("3divbest1",sec);
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("3divlevel3",false);
                        shared.edit().putBoolean("3divlevel3",true).commit();
                        intent.putExtra("best",divBest2);
                        if(sec<divBest2)
                            sharedTime.edit().putInt("3divbest2",sec);
                    }
                    if(getLevel==3){
                        intent.putExtra("best",divBest3);
                        if(sec<divBest3)
                            sharedTime.edit().putInt("3divbest3",sec);
                    }

                    break;
                case "mix":
                    if(getLevel==0){
                        yes=shared.getBoolean("3mixlevel1",false);
                        shared.edit().putBoolean("3mixlevel1",true).commit();
                        intent.putExtra("best",mixBest0);
                        if(sec<mixBest0)
                            sharedTime.edit().putInt("3mixbest0",sec);
                    }
                    if(getLevel==1){
                        yes=shared.getBoolean("3mixlevel2",false);
                        shared.edit().putBoolean("3mixlevel2",true).commit();
                        intent.putExtra("best",mixBest1);
                        if(sec<mixBest1)
                            sharedTime.edit().putInt("3mixbest1",sec);
                    }
                    if(getLevel==2){
                        yes=shared.getBoolean("3mixlevel3",false);
                        shared.edit().putBoolean("3mixlevel3",true).commit();
                        intent.putExtra("best",mixBest2);
                        if(sec<mixBest2)
                            sharedTime.edit().putInt("3mixbest2",sec);
                    }
                    if(getLevel==3){
                        intent.putExtra("best",mixBest3);
                        if(sec<mixBest3)
                            sharedTime.edit().putInt("3mixbest3",sec);
                    }

                    break;
            }

            intent.putExtra("yes",yes);
            intent.putExtra("act","Main6CActivity");
            intent.putExtra("onback","Main6AActivity");

            marima.stop();
            if (ad!=null) {
                ad.show();
            }
            else{
                startActivity(intent);
            }




        }
        timerTask();

        for (int i = 0; i < 12; i++)
            buttons[i].setEnabled(true);
        if (p == 0)
            option.setText("0/15");
        else
            option.setText(String.valueOf(right + "/" + total));

        if (right / total == 1) {

        }


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
            question1.setText("");
            question1.setBackgroundResource(R.drawable.opwrong);
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
            s = rand.nextInt(2);
            if (s == 1) {
                question2.setBackgroundResource(0);
                question4.setText("");
                question4.setBackgroundResource(R.drawable.opwrong);
                question2.setText(qString);
                question3.setText(String.valueOf(sign));
            }
            if (s == 0) {
                question4.setBackgroundResource(0);
                question2.setText("");
                question2.setBackgroundResource(R.drawable.opwrong);
                question3.setText(String.valueOf(sign));
                question4.setText(rString);
            }

            if (sign == '+')
                ans1 = String.valueOf(q + r);
            else if (sign == '-')
                ans1 = String.valueOf(q - r);
            else if (sign == '×')
                ans1 = String.valueOf(q * r);
            else if (sign == '÷')
                ans1 = String.valueOf(q / r);
        }
        result.setText(ans1);


    }

    @Override
    public void onClick(View v) {
        if (getLevel == 3) {
            switch (v.getId()) {
                case R.id.button0:
                    sf.append("0");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button1:
                    sf.append("1");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button2:
                    sf.append("2");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button3:
                    sf.append("3");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button4:
                    sf.append("4");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button5:
                    sf.append("5");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button6:
                    sf.append("6");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button7:
                    sf.append("7");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button8:
                    sf.append("8");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button9:
                    sf.append("9");
                    question1.setText(String.valueOf(sf));
                    getAnswer();
                    break;
                case R.id.button10:
                    sf.append("-");
                    question1.setText(String.valueOf(sf));
                    break;
                case R.id.button11:
                    question1.setText(String.valueOf(sf));
                    if (sf.length() > 0)
                        sf.deleteCharAt(sf.length() - 1);
                    break;
            }
        } else {
            if (s == 0) {
                switch (v.getId()) {
                    case R.id.button0:
                        sf.append("0");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button1:
                        sf.append("1");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button2:
                        sf.append("2");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button3:
                        sf.append("3");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button4:
                        sf.append("4");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button5:
                        sf.append("5");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button6:
                        sf.append("6");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button7:
                        sf.append("7");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button8:
                        sf.append("8");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button9:
                        sf.append("9");
                        question2.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button10:
                        sf.append("-");
                        question2.setText(String.valueOf(sf));
                        break;
                    case R.id.button11:
                        question2.setText(String.valueOf(sf));
                        if (sf.length() > 0)
                            sf.deleteCharAt(sf.length() - 1);
                        break;
                }
            } else if (s == 1) {
                switch (v.getId()) {
                    case R.id.button0:
                        sf.append("0");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button1:
                        sf.append("1");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button2:
                        sf.append("2");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button3:
                        sf.append("3");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button4:
                        sf.append("4");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button5:
                        sf.append("5");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button6:
                        sf.append("6");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button7:
                        sf.append("7");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button8:
                        sf.append("8");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button9:
                        sf.append("9");
                        question4.setText(String.valueOf(sf));
                        getAnswer();
                        break;
                    case R.id.button10:
                        sf.append("-");
                        question4.setText(String.valueOf(sf));
                        break;
                    case R.id.button11:
                        question4.setText(String.valueOf(sf));
                        if (sf.length() > 0)
                            sf.deleteCharAt(sf.length() - 1);
                        break;
                }
            }
        }
    }

    public void getAnswer() {
        if (getLevel == 3) {
            if (question1.getText().toString().equals(pString)) {
                if(sound)
                    correct.start();
                question1.setBackgroundResource(R.drawable.opright);
                sf.delete(0,sf.length());
                timer.cancel();
                right++;
                question1.startAnimation(f1);
                question2.startAnimation(f1);
                question3.startAnimation(f1);
                question4.startAnimation(f1);
                question5.startAnimation(f1);
                f1.setFillAfter(true);
                for(int i=0;i<12;i++)
                    buttons[i].setEnabled(false);
            }
        }
        else {
            if (s == 0) {
                if (question2.getText().toString().equals(qString)) {
                    if(sound)
                        correct.start();
                    question2.setBackgroundResource(R.drawable.opright);
                    sf.delete(0,sf.length());
                    timer.cancel();
                    right++;
                    question1.startAnimation(f1);
                    question2.startAnimation(f1);
                    question3.startAnimation(f1);
                    question4.startAnimation(f1);
                    question5.startAnimation(f1);
                    f1.setFillAfter(true);
                    for(int i=0;i<12;i++)
                        buttons[i].setEnabled(false);
                }
            } else if (s == 1) {
                if (question4.getText().toString().equals(rString)) {
                    if(sound)
                        correct.start();
                    question4.setBackgroundResource(R.drawable.opright);
                    sf.delete(0,sf.length());
                    timer.cancel();
                    right++;
                    question1.startAnimation(f1);
                    question2.startAnimation(f1);
                    question3.startAnimation(f1);
                    question4.startAnimation(f1);
                    question5.startAnimation(f1);
                    f1.setFillAfter(true);
                    for(int i=0;i<12;i++)
                        buttons[i].setEnabled(false);
                }
            }
        }
    }

}
