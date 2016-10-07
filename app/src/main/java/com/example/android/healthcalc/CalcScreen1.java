package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalcScreen1 extends AppCompatActivity implements View.OnClickListener,TabLayout.OnTabSelectedListener{

    private Context ctx=this;
    private EditText mEtYears, mEtMetersFeet, mEtCmInch, mEtKgLbs ;
    private Button mBtnGoToCalcScreen2;
    private Intent mIntnGoToCalcScreen2;
    private int mYears, mMeters, mCentimeters, mKilograms;
    private boolean mIsMale, mAreMeters, mAreKilograms;
    private TabLayout mTlMetersFeet, mTlKgLbs;


    protected void init(){
        mEtYears=(EditText)findViewById(R.id.et_calc_screen1_years);
        mEtMetersFeet=(EditText)findViewById(R.id.et_calc_screen1_meters_feet);
        mEtCmInch=(EditText)findViewById(R.id.et_calc_screen1_meters_feet);
        mEtKgLbs=(EditText)findViewById(R.id.et_calc_screen1_kg_lbs);
        mBtnGoToCalcScreen2=(Button)findViewById(R.id.btn_calc_screen1_go_calc_screen2);
        mTlMetersFeet=(TabLayout)findViewById(R.id.tl_calc_screen1_meters_feet);
        mTlKgLbs=(TabLayout)findViewById(R.id.tl_calc_screen1_lbs_kg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_screen1);

        init();

        mBtnGoToCalcScreen2.setOnClickListener((View.OnClickListener) ctx);
        mTlMetersFeet.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) ctx);
        mTlKgLbs.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) ctx);



    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_calc_screen1_go_calc_screen2){

            try {
                mYears = Integer.parseInt(mEtYears.getText().toString());

                mIntnGoToCalcScreen2=new Intent(ctx,CalcScreen2.class);
                startActivity(mIntnGoToCalcScreen2);
            }catch (Exception ex){
                Toast.makeText(ctx, "Wrong input", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        try {
                if(tab.equals(mTlKgLbs.getTabAt(0))) {
                    mTlMetersFeet.getTabAt(0).select();
                }
                else if(tab.equals(mTlKgLbs.getTabAt(1))){
                    mTlMetersFeet.getTabAt(1).select();
                }
                else if(tab.equals(mTlMetersFeet.getTabAt(1))){
                    mTlKgLbs.getTabAt(1).select();
                }
                else if(tab.equals(mTlMetersFeet.getTabAt(0))){
                    mTlKgLbs.getTabAt(0).select();
                }

        }catch (Exception ex){

        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
