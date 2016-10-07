package com.example.android.healthcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CalcScreen2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private Intent mIntentFromCalcScreen1;
    private int mIntAge;
    private boolean mBoolIsMale;
    private double mDoubleHeight, mDoubleWeight , mDoubleDailyCalories, mDoubleActivityLvl;
    private RadioGroup mRgActivityLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_screen2);
        init();

        mIntAge = mIntentFromCalcScreen1.getIntExtra("Age",0);
        mBoolIsMale = mIntentFromCalcScreen1.getBooleanExtra("Gender",true);
        mDoubleHeight = mIntentFromCalcScreen1.getDoubleExtra("Height",0.00);
        mDoubleWeight = mIntentFromCalcScreen1.getDoubleExtra("Weight",0.00);
    }

    protected void init(){
        mIntentFromCalcScreen1 = new Intent();
        mRgActivityLvl=(RadioGroup)findViewById(R.id.rg_calc_screen2_activity_lvl);
    }

    public void calculateDailyCalories(View view){

        /*W = weight in kilograms (weight (lbs)/2.2) =weight in kg
        H = height in centimeters (inches x 2.54) =height in cm
        A = age in years

        Men: BMR=66.47+ (13.75 x W) + (5.0 x H) - (6.75 x A)
        Women: BMR=665.09 + (9.56 x W) + (1.84 x H) - (4.67 x A)*/

        if(mBoolIsMale){
            mDoubleDailyCalories = 66.47 + (13.75 * mDoubleWeight) + (5 * mDoubleHeight) - (6.75 * mIntAge);
        }else{
            mDoubleDailyCalories = 665.09 + (9.56 * mDoubleWeight) + (1.84 * mDoubleHeight) - (4.67 * mIntAge);
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(mRgActivityLvl.getCheckedRadioButtonId()==R.id.rb_calc_screen2_low){
            mDoubleActivityLvl=1.25;
        }else if(mRgActivityLvl.getCheckedRadioButtonId()==R.id.rb_calc_screen2_light){
            mDoubleActivityLvl=1.375;
        }else if(mRgActivityLvl.getCheckedRadioButtonId()==R.id.rb_calc_screen2_moderate){
            mDoubleActivityLvl=1.55;
        }else if(mRgActivityLvl.getCheckedRadioButtonId()==R.id.rb_calc_screen2_active){
            mDoubleActivityLvl=1.725;
        }else if(mRgActivityLvl.getCheckedRadioButtonId()==R.id.rb_calc_screen2_extreme){
            mDoubleActivityLvl=1.9;
        }


    }
}
