package com.example.android.healthcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CalcScreen2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup mRgGoal ;
    private Button mBtnGoCalcScreen3;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_screen2);


        mRgGoal = (RadioGroup) findViewById(R.id.rg_calc_screen2_activity_lvl);
        mBtnGoCalcScreen3 = (Button) findViewById(R.id.btn_calc_screen2);
        mBtnGoCalcScreen3.setOnClickListener(this);

        //Initial value of activity lvl, because first radio button is checked by default
        MyApplication.appGoal = 0;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //gets the checked radio button and assigns
        // the corresponding value to mFloatActivityLvl

        if (i == R.id.rb_calc_screen3_low) {
            MyApplication.appGoal = -500;
        } else if (i == R.id.rb_calc_screen3_light) {
            MyApplication.appGoal = -250;
        } else if (i == R.id.rb_calc_screen3_moderate) {
            MyApplication.appGoal = 0;
        } else if (i == R.id.rb_calc_screen3_active) {
            MyApplication.appGoal = 250;
        } else if (i == R.id.rb_calc_screen3_extreme) {
            MyApplication.appGoal = 500;
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calc_screen2) {
            mIntent = new Intent(this, CalcScreen3.class);
            startActivity(mIntent);
        }
    }
}
