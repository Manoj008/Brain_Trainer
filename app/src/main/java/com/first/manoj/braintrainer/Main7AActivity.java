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

public class Main7AActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private AdView banner7a;
    boolean addlevel1,addlevel2,addlevel3;
    Button beginner,intermediate,advance,expert;
    SharedPreferences shared;

    MediaPlayer smooth,click;
    SharedPreferences background;
    boolean sound=false,music=false;
    Button menu,share,sound_button,music_button,cancel;
    Dialog soundDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7a);

        banner7a= (AdView) findViewById(R.id.banner7a);
        AdRequest request=new AdRequest.Builder().build();
        banner7a.loadAd(request);


        shared=getSharedPreferences("4level",MODE_PRIVATE);

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

        addlevel1=shared.getBoolean("4addlevel1",false);
        addlevel2=shared.getBoolean("4addlevel2",false);
        addlevel3=shared.getBoolean("4addlevel3",false);

        beginner=(Button)findViewById(R.id.beginner);
        intermediate=(Button)findViewById(R.id.intermediate);
        advance=(Button)findViewById(R.id.advance);
        expert=(Button)findViewById(R.id.expert);

        beginner.setOnClickListener(this);
        intermediate.setOnClickListener(this);
        advance.setOnClickListener(this);
        expert.setOnClickListener(this);

        intermediate.setEnabled(false);
        advance.setEnabled(false);
        expert.setEnabled(false);

        if(addlevel1){
            intermediate.setEnabled(true);
            intermediate.setText("INTERMEDIATE");
            intermediate.setBackgroundResource(R.drawable.medium);
        }
        if(addlevel2){
            advance.setEnabled(true);
            advance.setText("ADVANCE");
            advance.setBackgroundResource(R.drawable.hard);
        }
        if(addlevel3){
            expert.setEnabled(true);
            expert.setText("EXPERT");
            expert.setBackgroundResource(R.drawable.type);
        }

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
        Intent i=new Intent(Main7AActivity.this,Main7BActivity.class);
        sound=background.getBoolean("sound",true);

        if(sound)
            click.start();
        switch (v.getId()){
            case R.id.beginner:
                i.putExtra("level",0);
                i.putExtra("addH",10);
                i.putExtra("addL",0);
                i.putExtra("multH",5);
                i.putExtra("multL",2);
                startActivity(i);
                break;
            case R.id.intermediate:
                i.putExtra("level",1);
                i.putExtra("addH",25);
                i.putExtra("addL",10);
                i.putExtra("multH",10);
                i.putExtra("multL",6);
                startActivity(i);
                break;
            case R.id.advance:
                i.putExtra("level",2);
                i.putExtra("addH",50);
                i.putExtra("addL",26);
                i.putExtra("multH",17);
                i.putExtra("multL",11);
                startActivity(i);
                break;
            case R.id.expert:
                i.putExtra("level",3);
                i.putExtra("addH",200);
                i.putExtra("addL",51);
                i.putExtra("multH",25);
                i.putExtra("multL",18);
                startActivity(i);
                break;
        }
    }

    public void onBackPressed() {
        if(sound)
            click.start();
        startActivity(new Intent(this,Main2Activity.class));
    }
}
