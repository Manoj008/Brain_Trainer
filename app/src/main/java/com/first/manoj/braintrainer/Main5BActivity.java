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

public class Main5BActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView banner5b;
    private PublisherInterstitialAd backint, main5bint;
    Bundle bundle;
    int getLevel, getAddH, getAddL, getMultH, getMultL;
    int intSign, p, q, r, a, b, c, m, n;
    String pString, qString, rString, ans1, levelType;
    Random rand;
    TextView question3, question4;
    TextView question1, question5, level, type, result, question2, secs, option;
    Button button0, button1, button2, button3;
    Button sound_button, music_button, main_menu_button, game_menu_button, restart_button, resume_button, pause_button, cancel;

    Button buttons[];
    char signDefault, sign, getType;
    int right, sec, lost, total = 15;

    Timer timer;

    Dialog dialog, alertDialog;

    Animation f1, f2;

    Animation b1, b2, b3, b4, b5, u1, u2, u3, u4, u5;

    SharedPreferences shared, sharedTime, background;
    MediaPlayer marima, click, correct, incorrect;

    boolean addlevel1 = false, addlevel2 = false, addlevel3 = false, sound, music;

    int addBest0, addBest1, addBest2, addBest3;


    AdColonyInterstitialListener listener;
    AdColonyAdOptions options;
    AdColonyInterstitial ad;

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5b);

        listener = new AdColonyInterstitialListener() {
            @Override
            public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
                ad = adColonyInterstitial;
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

        banner5b = (AdView) findViewById(R.id.banner5b);
        AdRequest request = new AdRequest.Builder().build();
        banner5b.loadAd(request);

        main5bint = new PublisherInterstitialAd(this);
        main5bint.setAdUnitId("ca-app-pub-1042832531270687/5854371224");
        main5bint.loadAd(new PublisherAdRequest.Builder().build());

        backint = new PublisherInterstitialAd(this);
        backint.setAdUnitId("ca-app-pub-1042832531270687/7119706652");
        backint.loadAd(new PublisherAdRequest.Builder().build());

        marima = MediaPlayer.create(this, R.raw.marima);
        marima.setLooping(true);
        click = MediaPlayer.create(this, R.raw.click);
        background = getSharedPreferences("background", MODE_PRIVATE);

        music = background.getBoolean("music", true);
        sound = background.getBoolean("sound", true);
        if (music)
            marima.start();

        correct = MediaPlayer.create(this, R.raw.right);
        incorrect = MediaPlayer.create(this, R.raw.wrong);


        bundle = getIntent().getExtras();

        shared = getSharedPreferences("2level", MODE_PRIVATE);

        sharedTime = getSharedPreferences("2best", MODE_PRIVATE);

        addBest0 = sharedTime.getInt("2addbest0", 9999);
        addBest1 = sharedTime.getInt("2addbest1", 9999);
        addBest2 = sharedTime.getInt("2addbest2", 9999);
        addBest3 = sharedTime.getInt("2addbest3", 9999);

        addlevel1 = shared.getBoolean("2addlevel1", false);
        addlevel2 = shared.getBoolean("2addlevel2", false);
        addlevel3 = shared.getBoolean("2addlevel3", false);

        levelType = bundle.getString("levelType");

        dialog = new Dialog(this);

        buttons = new Button[]{button0, button1, button2, button3};

        secs = (TextView) findViewById(R.id.secs);
        sec = 0;
        lost = 0;

        option = (TextView) findViewById(R.id.option);


        rand = new Random();
        bundle = getIntent().getExtras();

        result = (TextView) findViewById(R.id.result);


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

        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);

        pause_button = (Button) findViewById(R.id.pause_button);

        for (int i = 0; i < 4; i++)
            buttons[i].setOnClickListener(this);

        f1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        f2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade2);
        b1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t1);
        b2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t2);
        b3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t3);
        b4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t4);
        b5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.t5);
        u1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u1);
        u2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u2);
        u3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u3);
        u4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u4);
        u5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.u5);


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

        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now();
                dialog.show();
            }
        });

        f1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                question1.startAnimation(f2);
                question2.startAnimation(f2);
                question3.startAnimation(f2);
                question4.startAnimation(f2);
                question5.startAnimation(f2);
                f2.setFillAfter(true);
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
                question1.startAnimation(u1);
                question2.startAnimation(u2);
                question3.startAnimation(u3);
                question4.startAnimation(u4);
                question5.startAnimation(u5);
                u1.setFillAfter(true);
                u2.setFillAfter(true);
                u3.setFillAfter(true);
                u4.setFillAfter(true);
                u5.setFillAfter(true);
                create();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You Will Lose All Your Progress");
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (lost == 1) {
                    marima.stop();
                    if (backint.isLoaded()) {
                        backint.show();
                    } else {
                        startActivity(new Intent(Main5BActivity.this, Main2Activity.class));
                    }

                    backint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main5BActivity.this, Main2Activity.class));
                        }
                    });
                } else if (lost == 2) {
                    marima.stop();
                    if (main5bint.isLoaded()) {
                        main5bint.show();
                    } else {
                        startActivity(new Intent(Main5BActivity.this, Main5AActivity.class));
                    }

                    main5bint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main5BActivity.this, Main5AActivity.class));
                        }
                    });
                } else if (lost == 3) {
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
        alertDialog = builder.create();

        create();

    }

    protected void onPause() {
        super.onPause();
        if (marima.isPlaying())
            marima.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (music)
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

        music = background.getBoolean("music", true);
        if (music) {
            music_button.setBackgroundResource(R.drawable.music_button);
        } else {
            music_button.setBackgroundResource(R.drawable.no_sound_button);
        }

        sound = background.getBoolean("sound", true);
        if (sound) {
            sound_button.setBackgroundResource(R.drawable.sound_button);
        } else {
            sound_button.setBackgroundResource(R.drawable.no_sound_button);
        }


        music_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                music = background.getBoolean("music", true);
                if (music) {
                    music_button.setBackgroundResource(R.drawable.no_sound_button);
                    marima.pause();
                    music = background.edit().putBoolean("music", false).commit();
                } else {
                    music_button.setBackgroundResource(R.drawable.music_button);
                    marima.start();
                    music = background.edit().putBoolean("music", true).commit();
                }

            }
        });
        sound_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound = background.getBoolean("sound", true);
                if (sound) {
                    sound = background.edit().putBoolean("sound", false).commit();
                    sound_button.setBackgroundResource(R.drawable.no_sound_button);
                } else {
                    sound = background.edit().putBoolean("sound", true).commit();
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

    public void onBackPressed() {
        now();
        dialog.show();
    }


    public void create() {

        if (right == total) {
            intent = new Intent(Main5BActivity.this, Main3DActivity.class);
            intent.putExtra("level", getLevel);
            intent.putExtra("type", getType);
            intent.putExtra("levelType", levelType);
            intent.putExtra("your", sec);
            boolean yes = false;

            if (getLevel == 0) {
                yes = shared.getBoolean("2addlevel1", false);
                shared.edit().putBoolean("2addlevel1", true).commit();
                intent.putExtra("best", addBest0);
                if (sec < addBest0)
                    sharedTime.edit().putInt("2addbest0", sec).commit();
            }
            if (getLevel == 1) {
                yes = shared.getBoolean("2addlevel2", false);
                shared.edit().putBoolean("2addlevel2", true).commit();
                intent.putExtra("best", addBest1);
                if (sec < addBest1)
                    sharedTime.edit().putInt("2addbest1", sec).commit();
            }
            if (getLevel == 2) {
                yes = shared.getBoolean("2addlevel3", false);
                shared.edit().putBoolean("2addlevel3", true).commit();
                intent.putExtra("best", addBest2);
                if (sec < addBest2)
                    sharedTime.edit().putInt("2addbest2", sec).commit();
            }
            if (getLevel == 3) {
                intent.putExtra("best", addBest3);
                if (sec < addBest3)
                    sharedTime.edit().putInt("2addbest3", sec).commit();
            }

            intent.putExtra("yes", yes);
            intent.putExtra("act", "Main5BActivity");
            intent.putExtra("onback", "Main5AActivity");

            marima.stop();
            if (ad!=null) {
                ad.show();
            } else {
                startActivity(intent);
            }

        }
        timerTask();

        for (int i = 0; i < 4; i++)
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

            question2.setLayoutParams(new LinearLayout.LayoutParams(100, 150));

            question4.setText("");
            question4.setBackgroundResource(R.drawable.opwrong);
            question1.setText(pString);
            question2.setText(String.valueOf(signDefault));
            question3.setText("(" + qString);
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
            question3.setEnabled(false);
            question3.setText("");
            question3.setBackgroundResource(R.drawable.opwrong);
            question2.setText(qString);
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

        result.setText(ans1);


    }

    @Override
    public void onClick(View v) {
        timer.cancel();
        if (getLevel != 3) {
            switch (v.getId()) {
                case R.id.button0:
                    question3.setText("+");
                    getAnswer();
                    break;
                case R.id.button1:
                    question3.setText("×");
                    getAnswer();
                    break;
                case R.id.button2:
                    question3.setText("÷");
                    getAnswer();
                    break;
                case R.id.button3:
                    question3.setText("-");
                    getAnswer();
                    break;
                case R.id.button4:
                    question3.setText("");
                    getAnswer();
                    break;
            }
        } else if (getLevel == 3) {
            switch (v.getId()) {
                case R.id.button0:
                    question4.setText("+");
                    getAnswer();
                    break;
                case R.id.button1:
                    question4.setText("×");
                    getAnswer();
                    break;
                case R.id.button2:
                    question4.setText("÷");
                    getAnswer();
                    break;
                case R.id.button3:
                    question4.setText("-");
                    getAnswer();
                    break;
                case R.id.button4:
                    question4.setText("");
                    getAnswer();
                    break;
            }
        }
    }

    public void getAnswer() {
        if (getLevel == 3) {
            if (question4.getText().toString().equals((String.valueOf(sign)))) {
                if (sound)
                    correct.start();
                question4.setBackgroundResource(R.drawable.right);
                question1.startAnimation(f1);
                question2.startAnimation(f1);
                question3.startAnimation(f1);
                question4.startAnimation(f1);
                question5.startAnimation(f1);
                f1.setFillAfter(true);
                right++;
            } else {
                if (sound)
                    incorrect.start();
                question1.startAnimation(b1);
                question2.startAnimation(b2);
                question3.startAnimation(b3);
                question4.startAnimation(b4);
                question5.startAnimation(b5);
            }

        } else {
            if (question3.getText().toString().equals(String.valueOf(sign))) {
                if (sound)
                    correct.start();
                question3.setBackgroundResource(R.drawable.right);
                question1.startAnimation(f1);
                question2.startAnimation(f1);
                question3.startAnimation(f1);
                question4.startAnimation(f1);
                question5.startAnimation(f1);
                f1.setFillAfter(true);
                right++;
            } else {
                if (sound)
                    incorrect.start();
                question1.startAnimation(b1);
                question2.startAnimation(b2);
                question3.startAnimation(b3);
                question4.startAnimation(b4);
                question5.startAnimation(b5);

            }

        }

        b1.setFillAfter(true);
        b2.setFillAfter(true);
        b3.setFillAfter(true);
        b4.setFillAfter(true);
        b5.setFillAfter(true);

        for (int i = 0; i < 4; i++)
            buttons[i].setEnabled(false);
    }

    public void timerTask() {
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
