package com.first.manoj.braintrainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class Main8BActivity extends AppCompatActivity {

    private AdView banner8b;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t0,text0,text1,text2,text3,text4,text5,text6,text7,text8,text9;
    TextView ts[],texts[];
    EditText number;
    Button enter;
    Random rand;
    int n=2,p,q,r,s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8b);

        banner8b= (AdView) findViewById(R.id.banner8b);
        AdRequest request=new AdRequest.Builder().build();
        banner8b.loadAd(request);

        number= (EditText) findViewById(R.id.number);
        rand=new Random();

        enter=(Button)findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(number.getText().toString())>99){
                    number.setText("99");
                    n=99;
                }
                if(Integer.parseInt(number.getText().toString())<2){
                    number.setText("2");
                    n=2;
                }
                n=Integer.parseInt(number.getText().toString());
                createTable();
            }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isEmpty()){
                    enter.setEnabled(false);
                }
                else{
                    enter.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        p=rand.nextInt(9+1-2)+2;
        q=rand.nextInt(9+1-2)+2;
        r=rand.nextInt(9+1-2)+2;
        s=rand.nextInt(9+1-2)+2;

        ts=new TextView[]{t1,t2,t3,t4,t5,t6,t7,t8,t9,t0};
        texts=new TextView[]{text0,text1,text2,text3,text4,text5,text6,text7,text8,text9};

        texts[0]= (TextView) findViewById(R.id.text0);
        texts[1]= (TextView) findViewById(R.id.text1);
        texts[2]= (TextView) findViewById(R.id.text2);
        texts[3]= (TextView) findViewById(R.id.text3);
        texts[4]= (TextView) findViewById(R.id.text4);
        texts[5]= (TextView) findViewById(R.id.text5);
        texts[6]= (TextView) findViewById(R.id.text6);
        texts[7]= (TextView) findViewById(R.id.text7);
        texts[8]= (TextView) findViewById(R.id.text8);
        texts[9]= (TextView) findViewById(R.id.text9);

        ts[0]=(TextView)findViewById(R.id.t0);
        ts[1]=(TextView)findViewById(R.id.t1);
        ts[2]=(TextView)findViewById(R.id.t2);
        ts[3]=(TextView)findViewById(R.id.t3);
        ts[4]=(TextView)findViewById(R.id.t4);
        ts[5]=(TextView)findViewById(R.id.t5);
        ts[6]=(TextView)findViewById(R.id.t6);
        ts[7]=(TextView)findViewById(R.id.t7);
        ts[8]=(TextView)findViewById(R.id.t8);
        ts[9]=(TextView)findViewById(R.id.t9);

        createTable();

    }

    public void createTable(){
        for(int i=0;i<10;i++){
            texts[i].setText(n+" \u00d7 "+(i+1)+" = ");
            ts[i].setText(String.valueOf(n*(i+1)));
        }
    }

    public boolean isEmpty(){
        if(String.valueOf(number.getText()).equals(""))
            return true;
        else
            return false;
    }
}