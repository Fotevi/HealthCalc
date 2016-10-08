package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CalcScreen2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private Context ctx = this;
    private Intent mIntentFromCalcScreen1;
    private int mIntAge;
    private boolean mBoolIsMale;
    private float mFloatHeight, mFloatWeight, mFloatDailyCalories, mFloatActivityLvl;
    private float mFloatProtein, mFloatCarbs, mFloatFats;
    private RadioGroup mRgActivityLvl;
    private SharedPreferences mSharPref;
    private SharedPreferences.Editor mSharPrefEditor;
    private Button mBtnCalcCals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_screen2);
        init();

        mIntentFromCalcScreen1 = getIntent();
        mIntAge = mIntentFromCalcScreen1.getIntExtra("Age", 0);
        mBoolIsMale = mIntentFromCalcScreen1.getBooleanExtra("Gender", true);
        mFloatHeight = mIntentFromCalcScreen1.getFloatExtra("Height", 0.00f);
        mFloatWeight = mIntentFromCalcScreen1.getFloatExtra("Weight", 0.00f);
        mRgActivityLvl.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) ctx);
    }

    protected void init() {
        mIntentFromCalcScreen1 = new Intent();
        mRgActivityLvl = (RadioGroup) findViewById(R.id.rg_calc_screen2_activity_lvl);
        mSharPref = this.getPreferences(Context.MODE_PRIVATE);
        mSharPrefEditor = mSharPref.edit();
        mBtnCalcCals = (Button) findViewById(R.id.btn_calc_screen2);
        mBtnCalcCals.setOnClickListener(this);

    }

    public void calculateDailyCalories(View view) {

        /*W = weight in kilograms (weight (lbs)/2.2) =weight in kg
        H = height in centimeters (inches x 2.54) =height in cm
        A = age in years

        Men: BMR=66.47+ (13.75 x W) + (5.0 x H) - (6.75 x A)
        Women: BMR=665.09 + (9.56 x W) + (1.84 x H) - (4.67 x A)*/

        if (mBoolIsMale) {
            mFloatDailyCalories = 66.47f + (13.75f * mFloatWeight) + (5 * mFloatHeight) - (6.75f * mIntAge);
        } else {
            mFloatDailyCalories = 665.09f + (9.56f * mFloatWeight) + (1.84f * mFloatHeight) - (4.67f * mIntAge);
        }
        // adapting calories to the activity level
        mFloatDailyCalories = mFloatDailyCalories * mFloatActivityLvl;

        //Calculating macros
        mFloatProtein = mFloatWeight * 2.204f;
        mFloatFats = mFloatWeight;
        mFloatCarbs = (mFloatDailyCalories - mFloatProtein * 4 - mFloatFats * 9)/4;

        mSharPrefEditor.putFloat("DailyCalories", mFloatDailyCalories);
        mSharPrefEditor.putFloat("Protein", mFloatProtein);
        mSharPrefEditor.putFloat("Fats", mFloatFats);
        mSharPrefEditor.putFloat("Carbs", mFloatCarbs);
        mSharPrefEditor.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_calc_screen2_low) {
            mFloatActivityLvl = 1.25f;
        } else if (i == R.id.rb_calc_screen2_light) {
            mFloatActivityLvl = 1.375f;
        } else if (i == R.id.rb_calc_screen2_moderate) {
            mFloatActivityLvl = 1.55f;
        } else if (i == R.id.rb_calc_screen2_active) {
            mFloatActivityLvl = 1.725f;
        } else if (i == R.id.rb_calc_screen2_extreme) {
            mFloatActivityLvl = 1.9f;
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calc_screen2) {
            calculateDailyCalories(view);
        }
    }
}
