package com.first.manoj.braintrainer;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main4AActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private Button add,sub,mult,div,mix;

    private AdView banner4a;

    final static char ADD='+';
    final static char SUB='-';
    final static char MULT='×';
    final static char DIV='÷';
    final static char MIX='?';

    SharedPreferences shared=null;

    MediaPlayer smooth,click;
    SharedPreferences background;
    boolean sound=false,music=false;
    Button menu,share,sound_button,music_button,cancel;
    Dialog soundDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4a);

        banner4a= (AdView) findViewById(R.id.banner4a);
        AdRequest request=new AdRequest.Builder().build();
        banner4a.loadAd(request);


        shared=getSharedPreferences("1level",MODE_PRIVATE);

        soundDialog=new Dialog(this);

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
        if(music)
            smooth.start();

        add= (Button) findViewById(R.id.add);
        sub= (Button) findViewById(R.id.sub);
        mult= (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        mix= (Button) findViewById(R.id.mix);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        mix.setOnClickListener(this);

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
        Intent in=new Intent(Main4AActivity.this,Main4BActivity.class);
        sound=background.getBoolean("sound",true);

        if(sound)
            click.start();
        switch (v.getId()){
            case R.id.add:
                in.putExtra("type",ADD);
                in.putExtra("levelType","add");
                startActivity(in);
                break;
            case R.id.sub:
                in.putExtra("type",SUB);
                in.putExtra("levelType","sub");
                startActivity(in);
                break;
            case R.id.mult:
                in.putExtra("type",MULT);
                in.putExtra("levelType","mul");
                startActivity(in);
                break;
            case R.id.div:
                in.putExtra("type",DIV);
                in.putExtra("levelType","div");
                startActivity(in);
                break;
            case R.id.mix:
                in.putExtra("type",MIX);
                in.putExtra("levelType","mix");
                startActivity(in);
                break;
        }


    }

    public void onBackPressed() {

        if(sound)
            click.start();
        startActivity(new Intent(this,Main2Activity.class));
    }
}
