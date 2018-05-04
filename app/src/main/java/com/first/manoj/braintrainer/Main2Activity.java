package com.first.manoj.braintrainer;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private Button select_one,write_missing_numbers,write_missing_operator,write_the_result,compare_the_numbers,tables;
    private AdView banner2;

    private PublisherInterstitialAd backint;

    SharedPreferences shared;
    MediaPlayer smooth,click;
    SharedPreferences background;
    boolean sound=false,music=false;
    Button menu,share,sound_button,music_button,cancel,best;
    Dialog soundDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Animation my= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.manoj);


        AdRequest request=new AdRequest.Builder().build();
        banner2.loadAd(request);

        backint=new PublisherInterstitialAd(this);
        backint.setAdUnitId("ca-app-pub-1042832531270687/9745869994");
        backint.loadAd(new PublisherAdRequest.Builder().build());

        soundDialog=new Dialog(this);

        best= (Button) findViewById(R.id.best);
        best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,Main9Activity.class));
            }
        });

        best.startAnimation(my);

        background=getSharedPreferences("background",MODE_PRIVATE);
        sound=background.getBoolean("sound",true);
        music=background.getBoolean("music",true);

        now();

        smooth=MediaPlayer.create(getApplicationContext(),R.raw.smooth);
        click=MediaPlayer.create(getApplicationContext(),R.raw.click);
        smooth.setLooping(true);
        menu= (Button) findViewById(R.id.menu);
        share= (Button) findViewById(R.id.share);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.first.manoj.braintrainer");
                intent.putExtra(Intent.EXTRA_SUBJECT,"BRAIN TRAINER");
                Intent chooser=Intent.createChooser(intent,"share BRAIN TRAINER");
                startActivity(chooser);
            }
        });

        if(music) {
            smooth.start();
            music_button.setBackgroundResource(R.drawable.music_button);
        }
        else if(music==false){
            music_button.setBackgroundResource(R.drawable.no_sound_button);
        }

        if(sound){
            sound_button.setBackgroundResource(R.drawable.sound_button);
        }
        else{
            music_button.setBackgroundResource(R.drawable.no_sound_button);
        }

        select_one= (Button) findViewById(R.id.select_one);
        write_missing_numbers= (Button) findViewById(R.id.write_missing_number);
        write_missing_operator= (Button) findViewById(R.id.write_missing_operator);
        write_the_result= (Button) findViewById(R.id.write_the_result);
        compare_the_numbers= (Button) findViewById(R.id.compare_the_numbers);
        tables= (Button) findViewById(R.id.tables);


        select_one.setOnClickListener(this);
        write_missing_operator.setOnClickListener(this);
        write_missing_numbers.setOnClickListener(this);
        write_the_result.setOnClickListener(this);
        compare_the_numbers.setOnClickListener(this);
        tables.setOnClickListener(this);


    }

    public void now() {
        soundDialog.setContentView(R.layout.sound);
        soundDialog.setCancelable(false);
        sound_button = (Button) soundDialog.findViewById(R.id.sound_button);
        music_button = (Button) soundDialog.findViewById(R.id.music_button);
        cancel = (Button) soundDialog.findViewById(R.id.cancel);

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
                    smooth.pause();
                    music=background.edit().putBoolean("music",false).commit();
                }
                else{
                    music_button.setBackgroundResource(R.drawable.music_button);
                    smooth.start();
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
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundDialog.dismiss();
            }
        });

    }


    public void showPopup(View v) {
        PopupMenu mymenu = new PopupMenu(this, v);
        mymenu.setOnMenuItemClickListener(this);
        mymenu.inflate(R.menu.mymenu);
        mymenu.show();
    }

    public boolean onMenuItemClick(MenuItem item) {
        now();
        switch (item.getItemId()) {
            case R.id.sounds:
                soundDialog.show();
                return true;
            case R.id.rate:
                if (sound)
                    click.start();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.first.manoj.braintrainer"));
                Intent chooser=Intent.createChooser(intent,"BRAIN TRAINER");
                startActivity(chooser);
                return true;
        }
        return false;
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(smooth.isPlaying())
            smooth.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(music)
            smooth.start();
    }

    @Override
    public void onClick(View v) {
        sound=background.getBoolean("sound",true);
        if(sound)
            click.start();
        switch (v.getId()){
            case R.id.select_one:
                startActivity(new Intent(Main2Activity.this,Main3AActivity.class));
                break;

            case R.id.write_the_result:
                startActivity(new Intent(Main2Activity.this,Main4AActivity.class));
                break;

            case R.id.write_missing_operator:
                startActivity(new Intent(Main2Activity.this,Main5AActivity.class));
                break;

            case R.id.write_missing_number:
                startActivity(new Intent(Main2Activity.this,Main6AActivity.class));
                break;

            case R.id.compare_the_numbers:
                startActivity(new Intent(Main2Activity.this,Main7AActivity.class));
                break;

            case R.id.tables:
                startActivity(new Intent(Main2Activity.this,Main8AActivity.class));
                break;
        }
    }



    @Override
    public void onBackPressed()
    {
        if(sound)
            click.start();
        if (backint.isLoaded()) {
            backint.show();
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            }
            else
                finish();
        }

        backint.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }
                else
                    finish();
            }
        });
    }
}
