package com.first.manoj.braintrainer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener {

    private AdView banner9;
    TextView gametext3, gametext4, gametext5, gametext6, gametext7;
    LinearLayout game3, game4, game5, game6, game7;
    TextView beginner3, beginner4, beginner5, beginner6, beginner7,
            intermediate3, intermediate4, intermediate5, intermediate6, intermediate7,
            advance3, advance4, advance5, advance6, advance7,
            expert3, expert4, expert5, expert6, expert7;

    Animation bu, bd;

    Button add3, add4, add6, sub3, sub4, sub6, mul3, mul4, mul6, div3, div4, div6, mix3, mix4, mix6;

    boolean b3 = false, b4 = false, b5 = false, b6 = false, b7 = false;

    int addBest03, addBest13, addBest23, addBest33,
            subBest03, subBest13, subBest23, subBest33,
            mulBest03, mulBest13, mulBest23, mulBest33,
            divBest03, divBest13, divBest23, divBest33,
            mixBest03, mixBest13, mixBest23, mixBest33;

    int addBest04, addBest14, addBest24, addBest34,
            subBest04, subBest14, subBest24, subBest34,
            mulBest04, mulBest14, mulBest24, mulBest34,
            divBest04, divBest14, divBest24, divBest34,
            mixBest04, mixBest14, mixBest24, mixBest34;

    int addBest05, addBest15, addBest25, addBest35;

    int addBest06, addBest16, addBest26, addBest36,
            subBest06, subBest16, subBest26, subBest36,
            mulBest06, mulBest16, mulBest26, mulBest36,
            divBest06, divBest16, divBest26, divBest36,
            mixBest06, mixBest16, mixBest26, mixBest36;

    int addBest07, addBest17, addBest27, addBest37;

    SharedPreferences g3, g4, g5, g6, g7;

    AdColonyInterstitialListener listener;
    AdColonyAdOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        banner9= (AdView) findViewById(R.id.banner9);
        AdRequest request=new AdRequest.Builder().build();
        banner9.loadAd(request);


        bd = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bestdown);
        bu = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bestup);


        game3 = (LinearLayout) findViewById(R.id.game3);
        game4 = (LinearLayout) findViewById(R.id.game4);
        game5 = (LinearLayout) findViewById(R.id.game5);
        game6 = (LinearLayout) findViewById(R.id.game6);
        game7 = (LinearLayout) findViewById(R.id.game7);

        gametext3 = (TextView) findViewById(R.id.game3text);
        gametext4 = (TextView) findViewById(R.id.game4text);
        gametext5 = (TextView) findViewById(R.id.game5text);
        gametext6 = (TextView) findViewById(R.id.game6text);
        gametext7 = (TextView) findViewById(R.id.game7text);

        beginner3 = (TextView) findViewById(R.id.beginner3);
        beginner4 = (TextView) findViewById(R.id.beginner4);
        beginner5 = (TextView) findViewById(R.id.beginner5);
        beginner6 = (TextView) findViewById(R.id.beginner6);
        beginner7 = (TextView) findViewById(R.id.beginner7);

        intermediate3 = (TextView) findViewById(R.id.intermediate3);
        intermediate4 = (TextView) findViewById(R.id.intermediate4);
        intermediate5 = (TextView) findViewById(R.id.intermediate5);
        intermediate6 = (TextView) findViewById(R.id.intermediate6);
        intermediate7 = (TextView) findViewById(R.id.intermediate7);

        advance3 = (TextView) findViewById(R.id.advance3);
        advance4 = (TextView) findViewById(R.id.advance4);
        advance5 = (TextView) findViewById(R.id.advance5);
        advance6 = (TextView) findViewById(R.id.advance6);
        advance7 = (TextView) findViewById(R.id.expert7);


        expert3 = (TextView) findViewById(R.id.expert3);
        expert4 = (TextView) findViewById(R.id.expert4);
        expert5 = (TextView) findViewById(R.id.expert5);
        expert6 = (TextView) findViewById(R.id.expert6);
        expert7 = (TextView) findViewById(R.id.expert7);

        add3 = (Button) findViewById(R.id.add3);
        add4 = (Button) findViewById(R.id.add4);
        add6 = (Button) findViewById(R.id.add6);

        sub3 = (Button) findViewById(R.id.sub3);
        sub4 = (Button) findViewById(R.id.sub4);
        sub6 = (Button) findViewById(R.id.sub6);

        mul3 = (Button) findViewById(R.id.mul3);
        mul4 = (Button) findViewById(R.id.mul4);
        mul6 = (Button) findViewById(R.id.mul6);

        div3 = (Button) findViewById(R.id.div3);
        div4 = (Button) findViewById(R.id.div4);
        div6 = (Button) findViewById(R.id.div6);

        mix3 = (Button) findViewById(R.id.mix3);
        mix4 = (Button) findViewById(R.id.mix4);
        mix6 = (Button) findViewById(R.id.mix6);

        g3 = getSharedPreferences("0best", MODE_PRIVATE);
        g4 = getSharedPreferences("1best", MODE_PRIVATE);
        g5 = getSharedPreferences("2best", MODE_PRIVATE);
        g6 = getSharedPreferences("3best", MODE_PRIVATE);
        g7 = getSharedPreferences("4best", MODE_PRIVATE);

        addBest03 = g3.getInt("0addbest0", 9999);
        addBest13 = g3.getInt("0addbest1", 9999);
        addBest23 = g3.getInt("0addbest2", 9999);
        addBest33 = g3.getInt("0addbest3", 9999);
        subBest03 = g3.getInt("0subbest0", 9999);
        subBest13 = g3.getInt("0subbest1", 9999);
        subBest23 = g3.getInt("0subbest2", 9999);
        subBest33 = g3.getInt("0subbest3", 9999);
        mulBest03 = g3.getInt("0mulbest0", 9999);
        mulBest13 = g3.getInt("0mulbest1", 9999);
        mulBest23 = g3.getInt("0mulbest2", 9999);
        mulBest33 = g3.getInt("0mulbest3", 9999);
        divBest03 = g3.getInt("0divbest0", 9999);
        divBest13 = g3.getInt("0divbest1", 9999);
        divBest23 = g3.getInt("0divbest2", 9999);
        divBest33 = g3.getInt("0divbest3", 9999);
        mixBest03 = g3.getInt("0mixbest0", 9999);
        mixBest13 = g3.getInt("0mixbest1", 9999);
        mixBest23 = g3.getInt("0mixbest2", 9999);
        mixBest33 = g3.getInt("0mixbest3", 9999);

        addBest04 = g4.getInt("1addbest0", 9999);
        addBest14 = g4.getInt("1addbest1", 9999);
        addBest24 = g4.getInt("1addbest2", 9999);
        addBest34 = g4.getInt("1addbest3", 9999);
        subBest04 = g4.getInt("1subbest0", 9999);
        subBest14 = g4.getInt("1subbest1", 9999);
        subBest24 = g4.getInt("1subbest2", 9999);
        subBest34 = g4.getInt("1subbest3", 9999);
        mulBest04 = g4.getInt("1mulbest0", 9999);
        mulBest14 = g4.getInt("1mulbest1", 9999);
        mulBest24 = g4.getInt("1mulbest2", 9999);
        mulBest34 = g4.getInt("1mulbest3", 9999);
        divBest04 = g4.getInt("1divbest0", 9999);
        divBest14 = g4.getInt("1divbest1", 9999);
        divBest24 = g4.getInt("1divbest2", 9999);
        divBest34 = g4.getInt("1divbest3", 9999);
        mixBest04 = g4.getInt("1mixbest0", 9999);
        mixBest14 = g4.getInt("1mixbest1", 9999);
        mixBest24 = g4.getInt("1mixbest2", 9999);
        mixBest34 = g4.getInt("1mixbest3", 9999);

        addBest05 = g5.getInt("2addbest0", 9999);
        addBest15 = g5.getInt("2addbest1", 9999);
        addBest25 = g5.getInt("2addbest2", 9999);
        addBest35 = g5.getInt("2addbest3", 9999);

        addBest06 = g6.getInt("3addbest0", 9999);
        addBest16 = g6.getInt("3addbest1", 9999);
        addBest26 = g6.getInt("3addbest2", 9999);
        addBest36 = g6.getInt("3addbest3", 9999);
        subBest06 = g6.getInt("3subbest0", 9999);
        subBest16 = g6.getInt("3subbest1", 9999);
        subBest26 = g6.getInt("3subbest2", 9999);
        subBest36 = g6.getInt("3subbest3", 9999);
        mulBest06 = g6.getInt("3mulbest0", 9999);
        mulBest16 = g6.getInt("3mulbest1", 9999);
        mulBest26 = g6.getInt("3mulbest2", 9999);
        mulBest36 = g6.getInt("3mulbest3", 9999);
        divBest06 = g6.getInt("3divbest0", 9999);
        divBest16 = g6.getInt("3divbest1", 9999);
        divBest26 = g6.getInt("3divbest2", 9999);
        divBest36 = g6.getInt("3divbest3", 9999);
        mixBest06 = g6.getInt("3mixbest0", 9999);
        mixBest16 = g6.getInt("3mixbest1", 9999);
        mixBest26 = g6.getInt("3mixbest2", 9999);
        mixBest36 = g6.getInt("3mixbest3", 9999);

        addBest07 = g7.getInt("4addbest0", 9999);
        addBest17 = g7.getInt("4addbest1", 9999);
        addBest27 = g7.getInt("4addbest2", 9999);
        addBest37 = g7.getInt("4addbest3", 9999);

        beginner3.setText(String.valueOf(addBest03 + " s"));
        beginner4.setText(String.valueOf(addBest04 + " s"));
        beginner5.setText(String.valueOf(addBest05 + " s"));
        beginner6.setText(String.valueOf(addBest06 + " s"));
        beginner7.setText(String.valueOf(addBest07 + " s"));

        intermediate3.setText(String.valueOf(addBest13 + " s"));
        intermediate4.setText(String.valueOf(addBest14 + " s"));
        intermediate5.setText(String.valueOf(addBest15 + " s"));
        intermediate6.setText(String.valueOf(addBest16 + " s"));
        intermediate7.setText(String.valueOf(addBest17 + " s"));

        advance3.setText(String.valueOf(addBest23 + " s"));
        advance4.setText(String.valueOf(addBest24 + " s"));
        advance5.setText(String.valueOf(addBest24 + " s"));
        advance6.setText(String.valueOf(addBest26 + " s"));
        advance7.setText(String.valueOf(addBest27 + " s"));

        expert3.setText(String.valueOf(addBest33 + " s"));
        expert4.setText(String.valueOf(addBest34 + " s"));
        expert5.setText(String.valueOf(addBest35 + " s"));
        expert6.setText(String.valueOf(addBest36 + " s"));
        expert7.setText(String.valueOf(addBest37 + " s"));

        gametext3.setOnClickListener(this);
        gametext4.setOnClickListener(this);
        gametext5.setOnClickListener(this);
        gametext6.setOnClickListener(this);
        gametext7.setOnClickListener(this);

        add3.setOnClickListener(this);
        add4.setOnClickListener(this);
        add6.setOnClickListener(this);

        sub3.setOnClickListener(this);
        sub4.setOnClickListener(this);
        sub6.setOnClickListener(this);

        mul3.setOnClickListener(this);
        mul4.setOnClickListener(this);
        mul6.setOnClickListener(this);

        div3.setOnClickListener(this);
        div4.setOnClickListener(this);
        div6.setOnClickListener(this);

        mix3.setOnClickListener(this);
        mix4.setOnClickListener(this);
        mix6.setOnClickListener(this);

        add3.setBackgroundResource(R.drawable.newfile);
        add4.setBackgroundResource(R.drawable.newfile);
        add6.setBackgroundResource(R.drawable.newfile);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.game3text:
                if (b3) {
                    game3.setVisibility(View.GONE);
                    b3 = false;
                } else {
                    game3.setVisibility(View.VISIBLE);
                    game3.startAnimation(bd);
                    b3 = true;
                }
                break;

            case R.id.game4text:
                if (b4) {
                    game4.setVisibility(View.GONE);
                    b4 = false;
                } else {
                    game4.setVisibility(View.VISIBLE);
                    game4.startAnimation(bd);
                    b4 = true;
                }
                break;
            case R.id.game5text:
                if (b5) {
                    game5.setVisibility(View.GONE);
                    b5 = false;
                } else {
                    game5.setVisibility(View.VISIBLE);
                    game5.startAnimation(bd);
                    b5 = true;
                }
                break;
            case R.id.game6text:
                if (b6) {
                    game6.setVisibility(View.GONE);
                    b6 = false;
                } else {
                    game6.setVisibility(View.VISIBLE);
                    game6.startAnimation(bd);
                    b6 = true;
                }
                break;
            case R.id.game7text:
                if (b7) {
                    game7.setVisibility(View.GONE);
                    b7 = false;
                } else {
                    game7.setVisibility(View.VISIBLE);
                    game7.startAnimation(bd);
                    b7 = true;
                }
                break;
            case R.id.add3:
                add3.setBackgroundResource(R.drawable.newfile);
                sub3.setBackgroundResource(R.drawable.write_missing_number);
                mul3.setBackgroundResource(R.drawable.write_missing_number);
                div3.setBackgroundResource(R.drawable.write_missing_number);
                mix3.setBackgroundResource(R.drawable.write_missing_number);

                beginner3.setText(String.valueOf(addBest03 + " s"));
                intermediate3.setText(String.valueOf(addBest13 + " s"));
                advance3.setText(String.valueOf(addBest23 + " s"));
                expert3.setText(String.valueOf(addBest33 + " s"));
                break;
            case R.id.sub3:
                add3.setBackgroundResource(R.drawable.write_missing_number);
                sub3.setBackgroundResource(R.drawable.newfile);
                mul3.setBackgroundResource(R.drawable.write_missing_number);
                div3.setBackgroundResource(R.drawable.write_missing_number);
                mix3.setBackgroundResource(R.drawable.write_missing_number);
                beginner3.setText(String.valueOf(subBest03 + " s"));
                intermediate3.setText(String.valueOf(subBest13 + " s"));
                advance3.setText(String.valueOf(subBest23 + " s"));
                expert3.setText(String.valueOf(subBest33 + " s"));
                break;
            case R.id.mul3:
                add3.setBackgroundResource(R.drawable.write_missing_number);
                sub3.setBackgroundResource(R.drawable.write_missing_number);
                mul3.setBackgroundResource(R.drawable.newfile);
                div3.setBackgroundResource(R.drawable.write_missing_number);
                mix3.setBackgroundResource(R.drawable.write_missing_number);
                beginner3.setText(String.valueOf(mulBest03 + " s"));
                intermediate3.setText(String.valueOf(mulBest13 + " s"));
                advance3.setText(String.valueOf(mulBest23 + " s"));
                expert3.setText(String.valueOf(mulBest33 + " s"));
                break;
            case R.id.div3:
                add3.setBackgroundResource(R.drawable.write_missing_number);
                sub3.setBackgroundResource(R.drawable.write_missing_number);
                mul3.setBackgroundResource(R.drawable.write_missing_number);
                div3.setBackgroundResource(R.drawable.newfile);
                mix3.setBackgroundResource(R.drawable.write_missing_number);
                beginner3.setText(String.valueOf(divBest03 + " s"));
                intermediate3.setText(String.valueOf(divBest13 + " s"));
                advance3.setText(String.valueOf(divBest23 + " s"));
                expert3.setText(String.valueOf(divBest33 + " s"));
                break;
            case R.id.mix3:
                add3.setBackgroundResource(R.drawable.write_missing_number);
                sub3.setBackgroundResource(R.drawable.write_missing_number);
                mul3.setBackgroundResource(R.drawable.write_missing_number);
                div3.setBackgroundResource(R.drawable.write_missing_number);
                mix3.setBackgroundResource(R.drawable.newfile);
                beginner3.setText(String.valueOf(mixBest03 + " s"));
                intermediate3.setText(String.valueOf(mixBest13 + " s"));
                advance3.setText(String.valueOf(mixBest23 + " s"));
                expert3.setText(String.valueOf(mixBest33 + " s"));
                break;

            case R.id.add4:
                add4.setBackgroundResource(R.drawable.newfile);
                sub4.setBackgroundResource(R.drawable.write_missing_number);
                mul4.setBackgroundResource(R.drawable.write_missing_number);
                div4.setBackgroundResource(R.drawable.write_missing_number);
                mix4.setBackgroundResource(R.drawable.write_missing_number);
                beginner4.setText(String.valueOf(addBest04 + " s"));
                intermediate4.setText(String.valueOf(addBest14 + " s"));
                advance4.setText(String.valueOf(addBest24 + " s"));
                expert4.setText(String.valueOf(addBest34 + " s"));
                break;
            case R.id.sub4:
                add4.setBackgroundResource(R.drawable.write_missing_number);
                sub4.setBackgroundResource(R.drawable.newfile);
                mul4.setBackgroundResource(R.drawable.write_missing_number);
                div4.setBackgroundResource(R.drawable.write_missing_number);
                mix4.setBackgroundResource(R.drawable.write_missing_number);
                beginner4.setText(String.valueOf(subBest04 + " s"));
                intermediate4.setText(String.valueOf(subBest14 + " s"));
                advance4.setText(String.valueOf(subBest24 + " s"));
                expert4.setText(String.valueOf(subBest34 + " s"));
                break;
            case R.id.mul4:
                add4.setBackgroundResource(R.drawable.write_missing_number);
                sub4.setBackgroundResource(R.drawable.write_missing_number);
                mul4.setBackgroundResource(R.drawable.newfile);
                div4.setBackgroundResource(R.drawable.write_missing_number);
                mix4.setBackgroundResource(R.drawable.write_missing_number);
                beginner4.setText(String.valueOf(mulBest04 + " s"));
                intermediate4.setText(String.valueOf(mulBest14 + " s"));
                advance4.setText(String.valueOf(mulBest24 + " s"));
                expert4.setText(String.valueOf(mulBest34 + " s"));
                break;
            case R.id.div4:
                add4.setBackgroundResource(R.drawable.write_missing_number);
                sub4.setBackgroundResource(R.drawable.write_missing_number);
                mul4.setBackgroundResource(R.drawable.write_missing_number);
                div4.setBackgroundResource(R.drawable.newfile);
                mix4.setBackgroundResource(R.drawable.write_missing_number);
                beginner4.setText(String.valueOf(divBest04 + " s"));
                intermediate4.setText(String.valueOf(divBest14 + " s"));
                advance4.setText(String.valueOf(divBest24 + " s"));
                expert4.setText(String.valueOf(divBest34 + " s"));
                break;
            case R.id.mix4:
                add4.setBackgroundResource(R.drawable.write_missing_number);
                sub4.setBackgroundResource(R.drawable.write_missing_number);
                mul4.setBackgroundResource(R.drawable.write_missing_number);
                div4.setBackgroundResource(R.drawable.write_missing_number);
                mix4.setBackgroundResource(R.drawable.newfile);
                beginner4.setText(String.valueOf(mixBest04 + " s"));
                intermediate4.setText(String.valueOf(mixBest14 + " s"));
                advance4.setText(String.valueOf(mixBest24 + " s"));
                expert4.setText(String.valueOf(mixBest34 + " s"));
                break;

            case R.id.add6:
                add6.setBackgroundResource(R.drawable.newfile);
                sub6.setBackgroundResource(R.drawable.write_missing_number);
                mul6.setBackgroundResource(R.drawable.write_missing_number);
                div6.setBackgroundResource(R.drawable.write_missing_number);
                mix6.setBackgroundResource(R.drawable.write_missing_number);
                beginner6.setText(String.valueOf(addBest06 + " s"));
                intermediate6.setText(String.valueOf(addBest16 + " s"));
                advance6.setText(String.valueOf(addBest26 + " s"));
                expert6.setText(String.valueOf(addBest36 + " s"));
                break;
            case R.id.sub6:
                add6.setBackgroundResource(R.drawable.write_missing_number);
                sub6.setBackgroundResource(R.drawable.newfile);
                mul6.setBackgroundResource(R.drawable.write_missing_number);
                div6.setBackgroundResource(R.drawable.write_missing_number);
                mix6.setBackgroundResource(R.drawable.write_missing_number);
                beginner6.setText(String.valueOf(subBest06 + " s"));
                intermediate6.setText(String.valueOf(subBest16 + " s"));
                advance6.setText(String.valueOf(subBest26 + " s"));
                expert6.setText(String.valueOf(subBest36 + " s"));
                break;
            case R.id.mul6:
                add6.setBackgroundResource(R.drawable.write_missing_number);
                sub6.setBackgroundResource(R.drawable.write_missing_number);
                mul6.setBackgroundResource(R.drawable.newfile);
                div6.setBackgroundResource(R.drawable.write_missing_number);
                mix6.setBackgroundResource(R.drawable.write_missing_number);
                beginner6.setText(String.valueOf(mulBest06 + " s"));
                intermediate6.setText(String.valueOf(mulBest16 + " s"));
                advance6.setText(String.valueOf(mulBest26 + " s"));
                expert6.setText(String.valueOf(mulBest36 + " s"));
                break;
            case R.id.div6:
                add6.setBackgroundResource(R.drawable.write_missing_number);
                sub6.setBackgroundResource(R.drawable.write_missing_number);
                mul6.setBackgroundResource(R.drawable.write_missing_number);
                div6.setBackgroundResource(R.drawable.newfile);
                mix6.setBackgroundResource(R.drawable.write_missing_number);
                beginner6.setText(String.valueOf(divBest06 + " s"));
                intermediate6.setText(String.valueOf(divBest16 + " s"));
                advance6.setText(String.valueOf(divBest26 + " s"));
                expert6.setText(String.valueOf(divBest36 + " s"));
                break;
            case R.id.mix6:
                add6.setBackgroundResource(R.drawable.write_missing_number);
                sub6.setBackgroundResource(R.drawable.write_missing_number);
                mul6.setBackgroundResource(R.drawable.write_missing_number);
                div6.setBackgroundResource(R.drawable.write_missing_number);
                mix6.setBackgroundResource(R.drawable.newfile);
                beginner6.setText(String.valueOf(mixBest06 + " s"));
                intermediate6.setText(String.valueOf(mixBest16 + " s"));
                advance6.setText(String.valueOf(mixBest26 + " s"));
                expert6.setText(String.valueOf(mixBest36 + " s"));
                break;
        }
    }

}
