package com.first.manoj.braintrainer;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class Main8CActivity extends AppCompatActivity {

    private AdView banner8c;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t0, text0, text1, text2, text3, text4, text5, text6, text7, text8, text9, r1, r2, r3, r4;
    TextView ts[], texts[], rs[],comp;
    EditText number;
    Button enter;
    Random rand;
    boolean flag, checked,finish1,finish2,finish3,finish4;
    LinearLayout complete;
    int n = 2, r, x, zs[],m;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8c);

        banner8c= (AdView) findViewById(R.id.banner8c);
        AdRequest request=new AdRequest.Builder().build();
        banner8c.loadAd(request);

        m=2;
        shared=getSharedPreferences("tables",MODE_PRIVATE);
        m=shared.getInt("tables",m);

        number = (EditText) findViewById(R.id.number);
        rand = new Random();
        complete = (LinearLayout) findViewById(R.id.complete);
        flag = false;
        checked = false;
        finish1 = false;
        finish2 = false;
        finish3 = false;
        finish4 = false;

        ts = new TextView[]{t1, t2, t3, t4, t5, t6, t7, t8, t9, t0};
        texts = new TextView[]{text0, text1, text2, text3, text4, text5, text6, text7, text8, text9};
        rs = new TextView[]{r1, r2, r3, r4};
        zs = new int[4];

        comp=(TextView)findViewById(R.id.comp);


        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(number.getText().toString())>m){
                    number.setText(String.valueOf(m));
                    Toast.makeText(getApplicationContext(),"THIS TABLE IS LOCKED,\nYOU NEED TO UNLOCK THIS TABLE FIRST",Toast.LENGTH_LONG).show();
                    n=m;
                }
                else if(Integer.parseInt(number.getText().toString()) < 2){
                    number.setText("2");
                    n = 2;
                }
                else
                    n = Integer.parseInt(number.getText().toString());
                created();
            }
        });

        rs[0] = (TextView) findViewById(R.id.r1);
        rs[1] = (TextView) findViewById(R.id.r2);
        rs[2] = (TextView) findViewById(R.id.r3);
        rs[3] = (TextView) findViewById(R.id.r4);

        texts[0] = (TextView) findViewById(R.id.text0);
        texts[1] = (TextView) findViewById(R.id.text1);
        texts[2] = (TextView) findViewById(R.id.text2);
        texts[3] = (TextView) findViewById(R.id.text3);
        texts[4] = (TextView) findViewById(R.id.text4);
        texts[5] = (TextView) findViewById(R.id.text5);
        texts[6] = (TextView) findViewById(R.id.text6);
        texts[7] = (TextView) findViewById(R.id.text7);
        texts[8] = (TextView) findViewById(R.id.text8);
        texts[9] = (TextView) findViewById(R.id.text9);

        ts[0] = (TextView) findViewById(R.id.t0);
        ts[1] = (TextView) findViewById(R.id.t1);
        ts[2] = (TextView) findViewById(R.id.t2);
        ts[3] = (TextView) findViewById(R.id.t3);
        ts[4] = (TextView) findViewById(R.id.t4);
        ts[5] = (TextView) findViewById(R.id.t5);
        ts[6] = (TextView) findViewById(R.id.t6);
        ts[7] = (TextView) findViewById(R.id.t7);
        ts[8] = (TextView) findViewById(R.id.t8);
        ts[9] = (TextView) findViewById(R.id.t9);

        rs[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    if (ts[i].getText().toString() == "") {
                        ts[i].setText(rs[0].getText().toString());
                        rs[0].setVisibility(View.GONE);
                        final int finalI = i;
                        final int finalI1 = i;
                        if (Integer.parseInt(ts[i].getText().toString()) == n * (i + 1)) {
                            ts[i].setTextColor(Color.BLACK);
                            ts[i].setBackgroundResource(0);
                            finish1=true;
                        } else {
                            ts[i].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    rs[0].setVisibility(View.VISIBLE);
                                    ts[finalI1].setText("");
                                }
                            });
                        }
                        completed();
                        break;
                    }
                }
            }
        });
        rs[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    if (ts[i].getText().toString() == "") {
                        ts[i].setText(rs[1].getText().toString());
                        rs[1].setVisibility(View.GONE);
                        final int finalI = i;
                        final int finalI1 = i;
                        if (Integer.parseInt(ts[i].getText().toString()) == n * (i + 1)) {
                            ts[i].setTextColor(Color.BLACK);
                            ts[i].setBackgroundResource(0);
                            finish2=true;
                        } else {
                            ts[i].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    rs[1].setVisibility(View.VISIBLE);
                                    ts[finalI1].setText("");
                                }
                            });
                        }
                       completed();
                        break;
                    }
                }
            }
        });
        rs[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    if (ts[i].getText().toString() == "") {
                        ts[i].setText(rs[2].getText().toString());
                        rs[2].setVisibility(View.GONE);
                        final int finalI = i;
                        final int finalI1 = i;
                        if (Integer.parseInt(ts[i].getText().toString()) == n * (i + 1)) {
                            ts[i].setTextColor(Color.BLACK);
                            ts[i].setBackgroundResource(0);
                            finish3=true;
                        } else {
                            ts[i].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    rs[2].setVisibility(View.VISIBLE);
                                    ts[finalI1].setText("");
                                }
                            });
                        }
                       completed();
                        break;
                    }
                }
            }
        });
        rs[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    if (ts[i].getText().toString() == "") {
                        ts[i].setText(rs[3].getText().toString());
                        rs[3].setVisibility(View.GONE);
                        final int finalI = i;
                        final int finalI1 = i;
                        if (Integer.parseInt(ts[i].getText().toString()) == n * (i + 1)) {
                            ts[i].setTextColor(Color.BLACK);
                            ts[i].setBackgroundResource(0);
                            finish4=true;
                        } else {
                            ts[i].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    rs[3].setVisibility(View.VISIBLE);
                                    ts[finalI1].setText("");
                                }
                            });
                        }
                        completed();
                        break;
                    }
                }
            }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isEmpty()){
                    enter.setEnabled(false);
                }
                else{
                    enter.setEnabled(true);
                }

            }
        });
        n=m;
        created();

    }


    public void created() {
        number.setText(String.valueOf(n));

        for (int j = 0; j < 4; j++) {
            rs[j].setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < 10; i++) {
            ts[i].setBackgroundResource(0);
            ts[i].setTextColor(Color.BLACK);
            ts[i].setText("");
        }


        for (int k = 0; k < 4; k++) {
            rs[k].setText("");
        }

        for (int i = 0; i < 4; i++) {
            zs[i] = rand.nextInt(8 + 1 - 2) + 2;
            for (int j = 0; j < i; j++) {
                if (zs[i] == zs[j]) {
                    i--;
                    break;
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            texts[i].setText(n + " \u00d7 " + (i + 1) + " = ");
            if (i == zs[0] || i == zs[1] || i == zs[2] || i == zs[3]) {
                ts[i].setBackgroundResource(R.drawable.main_color);
                ts[i].setTextColor(Color.WHITE);
            } else
                ts[i].setText(String.valueOf(n * (i + 1)));
        }

        for (int k = 0; k < 4; k++) {
            x = rand.nextInt(4);
            if (rs[x].getText().toString() == "") {
                rs[x].setText(String.valueOf((zs[k] + 1) * n));
            } else
                k--;
        }

    }

    public boolean check() {
        for (int i = 0; i < 10; i++) {
            if (ts[i].getText().toString() == "") {
                flag = false;
                break;
            } else
                flag = true;
        }
        return flag;
    }

    public void completed(){
        checked = check();
        if (checked == true && finish1==true&&finish2==true&&finish3==true && finish4==true) {
            complete.setVisibility(View.VISIBLE);
            Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.larger);
            comp.startAnimation(animation);
        }
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complete.setVisibility(View.GONE);
                m++;
                n++;
                shared.edit().putInt("tables",m).commit();
                created();
            }
        });
    }

    public boolean isEmpty(){
        if(String.valueOf(number.getText()).equals(""))
            return true;
        else
            return false;
    }
}