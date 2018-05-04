package com.first.manoj.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main3DActivity extends AppCompatActivity {

    private AdView banner3d;

    Button retry,next,share;
    Bundle bundle;
    String levelType,act,onback;
    int level,yourTime,bestTime;
    char getType;
    boolean yes=false;

    TextView your,best,unlock,nexttext,newlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3d);



        banner3d= (AdView) findViewById(R.id.banner3d);
        AdRequest request=new AdRequest.Builder().build();
        banner3d.loadAd(request);


        bundle=getIntent().getExtras();

        your= (TextView) findViewById(R.id.your);
        best= (TextView) findViewById(R.id.best);
        nexttext= (TextView) findViewById(R.id.nexttext);

        levelType=bundle.getString("levelType");

        retry= (Button) findViewById(R.id.retry);
        next= (Button) findViewById(R.id.next);
        unlock= (TextView) findViewById(R.id.unlock);
        newlevel= (TextView) findViewById(R.id.newlevel);
        share= (Button) findViewById(R.id.share);

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

        level=bundle.getInt("level");
        getType=bundle.getChar("type");
        yourTime=bundle.getInt("your");
        bestTime=bundle.getInt("best",99999);
        yes=bundle.getBoolean("yes",false);
        act=bundle.getString("act");
        onback=bundle.getString("onback");


        if(yes==false) {
            unlock.setVisibility(View.VISIBLE);
            newlevel.setVisibility(View.VISIBLE);
        }
        else{
            unlock.setVisibility(View.INVISIBLE);
            newlevel.setVisibility(View.INVISIBLE);
        }

        if(level==3){
            next.setVisibility(View.GONE);
            nexttext.setVisibility(View.GONE);
        }
        else{
            next.setVisibility(View.VISIBLE);
            nexttext.setVisibility(View.VISIBLE);
        }

        your.setText(String.valueOf(yourTime+" s"));
        best.setText(String.valueOf(bestTime+" s"));

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= null;
                try {
                    i = new Intent(Main3DActivity.this,Class.forName("com.first.manoj.braintrainer."+act));

                switch (level){
                    case 0:
                        i.putExtra("level",0);
                        i.putExtra("addH",26);
                        i.putExtra("addL",1);
                        i.putExtra("multH",10);
                        i.putExtra("multL",2);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                    case 1:
                        i.putExtra("level",1);
                        i.putExtra("addH",100);
                        i.putExtra("addL",26);
                        i.putExtra("multH",16);
                        i.putExtra("multL",5);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                    case 2:
                        i.putExtra("level",2);
                        i.putExtra("addH",201);
                        i.putExtra("addL",1);
                        i.putExtra("multH",21);
                        i.putExtra("multL",11);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                    case 3:
                        i.putExtra("level",3);
                        i.putExtra("addH",200);
                        i.putExtra("addL",1);
                        i.putExtra("multH",15);
                        i.putExtra("multL",2);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                }
                    startActivity(i);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= null;
                try {
                    i = new Intent(Main3DActivity.this,Class.forName("com.first.manoj.braintrainer."+act));
                switch (level){
                    case 0:
                        i.putExtra("level",1);
                        i.putExtra("addH",100);
                        i.putExtra("addL",26);
                        i.putExtra("multH",16);
                        i.putExtra("multL",5);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                    case 1:
                        i.putExtra("level",2);
                        i.putExtra("addH",201);
                        i.putExtra("addL",1);
                        i.putExtra("multH",21);
                        i.putExtra("multL",11);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                    case 2:
                        i.putExtra("level",3);
                        i.putExtra("addH",200);
                        i.putExtra("addL",1);
                        i.putExtra("multH",15);
                        i.putExtra("multL",2);
                        i.putExtra("type",getType);
                        i.putExtra("levelType",levelType);
                        startActivity(i);
                        break;
                }
                startActivity(i);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {
            startActivity(new Intent(Main3DActivity.this,Class.forName("com.first.manoj.braintrainer."+onback)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
