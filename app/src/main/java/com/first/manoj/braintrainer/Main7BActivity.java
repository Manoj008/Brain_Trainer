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

public class Main7BActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView banner7b;
    private PublisherInterstitialAd backint, main7bint;

    Bundle bundle;
    int getLevel, getAddH, getAddL, getMultH, getMultL;
    int intSign, p, q, r, s, t, u, a, b, c, m, n;
    String pString, qString, rString, sString, tString, uString, ans1, ans2, levelType;
    Random rand;
    TextView question1, question2, question3, question4, question5, question7, question8, question9, question10, question11, ans, level, option, type, secs, result;
    Button button1, button2, button3;
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
    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7b);

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

        banner7b = (AdView) findViewById(R.id.banner7b);
        AdRequest request = new AdRequest.Builder().build();
        banner7b.loadAd(request);

        main7bint = new PublisherInterstitialAd(this);
        main7bint.setAdUnitId("ca-app-pub-1042832531270687/5854371224");
        main7bint.loadAd(new PublisherAdRequest.Builder().build());

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


        shared = getSharedPreferences("4level", MODE_PRIVATE);

        sharedTime = getSharedPreferences("4best", MODE_PRIVATE);

        addBest0 = sharedTime.getInt("4addbest0", 9999);
        addBest1 = sharedTime.getInt("4addbest1", 9999);
        addBest2 = sharedTime.getInt("4addbest2", 9999);
        addBest3 = sharedTime.getInt("4addbest3", 9999);


        addlevel1 = shared.getBoolean("4addlevel1", false);
        addlevel2 = shared.getBoolean("4addlevel2", false);
        addlevel3 = shared.getBoolean("4addlevel3", false);

        levelType = bundle.getString("levelType");


        dialog = new Dialog(this);

        buttons = new Button[]{button1, button2, button3};

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


        question1 = (TextView) findViewById(R.id.question1);
        question2 = (TextView) findViewById(R.id.question2);
        question3 = (TextView) findViewById(R.id.question3);
        question4 = (TextView) findViewById(R.id.question4);
        question5 = (TextView) findViewById(R.id.question5);
        question7 = (TextView) findViewById(R.id.question7);
        question8 = (TextView) findViewById(R.id.question8);
        question9 = (TextView) findViewById(R.id.question9);
        question10 = (TextView) findViewById(R.id.question10);
        question11 = (TextView) findViewById(R.id.question11);
        ans = (TextView) findViewById(R.id.ans);
        level = (TextView) findViewById(R.id.level);
        type = (TextView) findViewById(R.id.type);

        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        pause_button = (Button) findViewById(R.id.pause_button);

        for (int i = 0; i < 3; i++)
            buttons[i].setOnClickListener(this);

        buttons[0].setText("\u003c");
        buttons[2].setText("\u003e");

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
                question7.startAnimation(f2);
                question8.startAnimation(f2);
                question9.startAnimation(f2);
                question10.startAnimation(f2);
                question11.startAnimation(f2);
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
                question7.startAnimation(u1);
                question8.startAnimation(u2);
                question9.startAnimation(u3);
                question10.startAnimation(u4);
                question11.startAnimation(u5);
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
                        startActivity(new Intent(Main7BActivity.this, Main2Activity.class));
                    }

                    backint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main7BActivity.this, Main2Activity.class));
                        }
                    });
                } else if (lost == 2) {
                    if (main7bint.isLoaded()) {
                        main7bint.show();
                    } else {
                        startActivity(new Intent(Main7BActivity.this, Main7AActivity.class));
                    }

                    main7bint.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(Main7BActivity.this, Main7AActivity.class));
                        }
                    });
                } else if (lost == 3)

                {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        });
        builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener()

        {
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

        if (right >= total) {
            intent = new Intent(Main7BActivity.this, Main3DActivity.class);
            intent.putExtra("level", getLevel);
            intent.putExtra("type", getType);
            intent.putExtra("levelType", levelType);
            intent.putExtra("your", sec);
            boolean yes = false;

            if (getLevel == 0) {
                shared.edit().putBoolean("4addlevel1", true).commit();
                yes = shared.getBoolean("4addlevel1", false);
                intent.putExtra("best", addBest0);
                if (sec < addBest0)
                    sharedTime.edit().putInt("4addbest0", sec).commit();
            }
            if (getLevel == 1) {
                shared.edit().putBoolean("4addlevel2", true).commit();
                yes = shared.getBoolean("4addlevel2", false);
                intent.putExtra("best", addBest1);
                if (sec < addBest1)
                    sharedTime.edit().putInt("4addbest1", sec).commit();
            }
            if (getLevel == 2) {
                shared.edit().putBoolean("4addlevel3", true).commit();
                yes = shared.getBoolean("4addlevel3", false);
                intent.putExtra("best", addBest2);
                if (sec < addBest2)
                    sharedTime.edit().putInt("4addbest2", sec).commit();
            }
            if (getLevel == 3) {
                intent.putExtra("best", addBest3);
                if (sec < addBest3)
                    sharedTime.edit().putInt("4addbest3", sec).commit();
            }

            intent.putExtra("yes", yes);
            intent.putExtra("act", "Main7BActivity");
            intent.putExtra("onback", "Main7AActivity");
            if (ad!=null) {
                ad.show();
            } else {
                startActivity(intent);
            }

            main7bint.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {

                }
            });

        }
        timerTask();

        for (int i = 0; i < 3; i++)
            buttons[i].setEnabled(true);
        if (p == 0)
            option.setText("0/15");
        else
            option.setText(String.valueOf(right + "/" + total));

        if (right / total == 1) {

        }

        if (getLevel == 0) {
            sign = '+';
        } else if (getLevel == 1) {
            intSign = rand.nextInt(2);
            if (intSign == 0)
                sign = '+';
            else if (intSign == 1)
                sign = '-';
        } else if (getLevel > 1) {
            intSign = rand.nextInt(4);
            if (intSign == 0)
                sign = '+';
            else if (intSign == 1)
                sign = '-';
            else if (intSign == 2)
                sign = '×';
            else if (intSign == 3)
                sign = '÷';
        }

        intSign = rand.nextInt(2);
        if (intSign == 0)
            signDefault = '+';
        else if (intSign == 1)
            signDefault = '-';

        p = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
        s = rand.nextInt(getAddH + 1 - getAddL) + getAddL;


        a = rand.nextInt(2);
        m = rand.nextInt(4);
        n = rand.nextInt(2);

        if (sign == '+')

        {
            q = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            r = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            t = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            u = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
        } else if (sign == '-')

        {
            q = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            r = rand.nextInt(q + 1 - getAddL) + getAddL;
            t = rand.nextInt(getAddH + 1 - getAddL) + getAddL;
            u = rand.nextInt(q + 1 - getAddL) + getAddL;
        } else if (sign == '÷')

        {
            r = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            q = (rand.nextInt(getMultH + 1 - 2) + 2) * r;
            u = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            t = (rand.nextInt(getMultH + 1 - 2) + 2) * u;
        } else

        {
            q = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            r = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            t = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
            u = rand.nextInt(getMultH + 1 - getMultL) + getMultL;
        }

        pString = String.valueOf(p);
        qString = String.valueOf(q);
        rString = String.valueOf(r);
        sString = String.valueOf(s);
        tString = String.valueOf(t);
        uString = String.valueOf(u);

        if (getLevel > 0 && getLevel < 3) {
            if (a == 1) {
                b = rand.nextInt(2);
                c = rand.nextInt(2);

                if (b == 1) {
                    q = -q;
                    t = -t;
                    qString = "(" + q + ")";
                    tString = "(" + t + ")";
                }
                if (c == 1) {
                    r = -r;
                    u = -u;
                    rString = "(" + r + ")";
                    uString = "(" + u + ")";
                }
            }
        }

        ans.setBackgroundResource(R.drawable.opwrong);
        ans.setText("");

        if (getLevel == 3) {
            question1.setText(pString);
            question2.setText(String.valueOf(signDefault));
            question3.setText("(" + qString);
            question4.setText(String.valueOf(sign));
            question5.setText(rString + ")");

            question7.setText(sString);
            question8.setText(String.valueOf(signDefault));
            question9.setText("(" + tString);
            question10.setText(String.valueOf(sign));
            question11.setText(uString + ")");


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

            if (sign == '+')
                ans2 = String.valueOf(t + u);
            else if (sign == '-')
                ans2 = String.valueOf(t - u);
            else if (sign == '×')
                ans2 = String.valueOf(t * u);
            else if (sign == '÷')
                ans2 = String.valueOf(t / u);

            if (signDefault == '+')
                ans2 = String.valueOf(s + Integer.parseInt(ans2));
            else if (signDefault == '-') {
                ans2 = String.valueOf(s - Integer.parseInt(ans2));
            }

        } else {

            question2.setText(qString);
            question3.setText(String.valueOf(sign));
            question4.setText(rString);

            question8.setText(tString);
            question9.setText(String.valueOf(sign));
            question10.setText(uString);

            if (sign == '+')
                ans1 = String.valueOf(q + r);
            else if (sign == '-')
                ans1 = String.valueOf(q - r);
            else if (sign == '×')
                ans1 = String.valueOf(q * r);
            else if (sign == '÷')
                ans1 = String.valueOf(q / r);

            if (sign == '+')
                ans2 = String.valueOf(t + u);
            else if (sign == '-')
                ans2 = String.valueOf(t - u);
            else if (sign == '×')
                ans2 = String.valueOf(t * u);
            else if (sign == '÷')
                ans2 = String.valueOf(t / u);
        }
    }

    @Override
    public void onClick(View v) {
        timer.cancel();
        for (int i = 0; i < 3; i++)
            buttons[i].setEnabled(false);
        switch (v.getId()) {
            case R.id.button1:
                ans.setText("<");
                if (Integer.parseInt(ans1) < Integer.parseInt(ans2)) {
                    ans.setBackgroundResource(R.drawable.opright);
                    correct();
                } else {
                    incorrect();
                }
                break;
            case R.id.button2:
                ans.setText("=");
                if (Integer.parseInt(ans1) == Integer.parseInt(ans2)) {
                    ans.setBackgroundResource(R.drawable.opright);
                    correct();
                } else {
                    incorrect();
                }
                break;
            case R.id.button3:
                ans.setText(">");
                if (Integer.parseInt(ans1) > Integer.parseInt(ans2)) {
                    ans.setBackgroundResource(R.drawable.opright);
                    correct();
                } else {
                    incorrect();
                }
        }

    }


    public void correct() {
        if (sound)
            correct.start();
        question1.startAnimation(f1);
        question2.startAnimation(f1);
        question3.startAnimation(f1);
        question4.startAnimation(f1);
        question5.startAnimation(f1);
        question7.startAnimation(f1);
        question8.startAnimation(f1);
        question9.startAnimation(f1);
        question10.startAnimation(f1);
        question11.startAnimation(f1);
        f1.setFillAfter(true);
        right++;
    }

    public void incorrect() {
        if (sound)
            incorrect.start();
        question1.startAnimation(b1);
        question2.startAnimation(b2);
        question3.startAnimation(b3);
        question4.startAnimation(b4);
        question5.startAnimation(b5);
        question7.startAnimation(b1);
        question8.startAnimation(b2);
        question9.startAnimation(b3);
        question10.startAnimation(b4);
        question11.startAnimation(b5);
        b1.setFillAfter(true);
        b2.setFillAfter(true);
        b3.setFillAfter(true);
        b4.setFillAfter(true);
        b5.setFillAfter(true);
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
