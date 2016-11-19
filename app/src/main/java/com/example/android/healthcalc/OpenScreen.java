package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class

OpenScreen extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGoToCalcScreen1, mBtnHelloLayout, mBtnGoDb, mBtnGoDiary;
    private Intent mIntent;
    private Context ctx = this;
    private SharedPreferences mSharPref;
    private TextView mTvMaxCalories,mTvCurrentCalories, mTvMaxProt, mTvCurrentProt,mTvMaxCarbs, mTvCurrentCarbs, mTvMaxFats,mTvCurrentFats;
    private Float mFloatCurrentCalories, mFloatCurrentProt, mFloatCurrentCarbs, mFloatCurrentFats;
    private String mStrData;
    private ArrayList<Food> mArrListDataFromDb;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharPref = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE);

        //Checking which screen need to be shown based on the data in SharedPrefferences

        //If no data show the Hello screen
        if ((mSharPref.getInt("DailyCalories", 0)) == 0) {
            setContentView(R.layout.hello_layout);
            mBtnHelloLayout = (Button) findViewById(R.id.btn_hello_layout);
            mBtnHelloLayout.setOnClickListener((View.OnClickListener) ctx);

        } else {
            //If there is data in shared prefferences we show the main activity
            setContentView(R.layout.activity_open);
            init();

            mBtnGoToCalcScreen1.setOnClickListener((View.OnClickListener) ctx);
            mBtnGoDb.setOnClickListener((View.OnClickListener) ctx);
            mBtnGoDiary.setOnClickListener((View.OnClickListener) ctx);




        }


    }


    @Override
    protected void onStart() {
        super.onStart();
        if ((mSharPref.getInt("DailyCalories", 0)) != 0) {
            mStrData = android.text.format.DateFormat.format("dd/MM/yyyy",new Date()).toString();
            /*TO DO : Try to add logic with temporal list to distinguish when to add prot,cals,etc..*/
            mArrListDataFromDb = mDatabaseHelper.searchForDiary(mStrData);
            mFloatCurrentCalories = 0.0f;
            mFloatCurrentProt = 0.0f;
            mFloatCurrentCarbs = 0.0f ;
            mFloatCurrentFats =0.0f;
            for(Food food : mArrListDataFromDb){
                mFloatCurrentCalories +=(food.getmIntCalories() * food.getmIntQuantity()) / 100.0f;
                mFloatCurrentProt +=(food.getmIntProtein() * food.getmIntQuantity()) / 100.0f;
                mFloatCurrentCarbs +=(food.getmIntCarbs() * food.getmIntQuantity()) / 100.0f;
                mFloatCurrentFats +=(food.getmIntFats() * food.getmIntQuantity()) / 100.0f;
            }


            mTvMaxCalories.setText(String.valueOf(mSharPref.getInt("DailyCalories",0)));
            mTvCurrentCalories.setText(String.valueOf(mFloatCurrentCalories));
            mTvMaxProt.setText(String.valueOf(mSharPref.getInt("Protein",0)));
            mTvCurrentProt.setText(String.valueOf(mFloatCurrentProt));
            mTvMaxCarbs.setText(String.valueOf(mSharPref.getInt("Carbs",0)));
            mTvCurrentCarbs.setText(String.valueOf(mFloatCurrentCarbs));
            mTvMaxFats.setText(String.valueOf(mSharPref.getInt("Fats",0)));
            mTvCurrentFats.setText(String.valueOf(mFloatCurrentFats));

        }
    }

    protected void init() {
        //binding the UI elements to variables
        mTvMaxCalories=(TextView)findViewById(R.id.tv_open_activity_max_calories);
        mTvCurrentCalories=(TextView)findViewById(R.id.tv_open_activity_current_calories);
        mTvMaxProt=(TextView)findViewById(R.id.tv_open_activity_max_proteins);
        mTvCurrentProt=(TextView)findViewById(R.id.tv_open_activity_current_proteins);
        mTvMaxCarbs=(TextView)findViewById(R.id.tv_open_activity_max_carbs);
        mTvCurrentCarbs=(TextView)findViewById(R.id.tv_open_activity_current_carbs);
        mTvMaxFats=(TextView)findViewById(R.id.tv_open_activity_max_fats);
        mTvCurrentFats=(TextView)findViewById(R.id.tv_open_activity_current_fats);
        mBtnGoToCalcScreen1 = (Button) findViewById(R.id.btn_open_activity_go_calc);
        mBtnGoDb = (Button) findViewById(R.id.btn_open_activity_go_db);
        mBtnGoDiary = (Button) findViewById(R.id.btn_open_activity_go_diary);
        mArrListDataFromDb = new ArrayList<Food>();
        mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hello_layout) {
            mIntent = new Intent(ctx, CalcScreen1.class);
            startActivity(mIntent);
        } else if (view.getId() == R.id.btn_open_activity_go_calc) {
            mIntent = new Intent(ctx, CalcScreen1.class);
            startActivity(mIntent);
        } else if (view.getId() == R.id.btn_open_activity_go_db) {
            mIntent = new Intent(ctx, DatabaseScreen.class);
            startActivity(mIntent);
        } else if (view.getId() == R.id.btn_open_activity_go_diary) {
            mIntent = new Intent(ctx, DiaryScreen.class);
            mIntent.putParcelableArrayListExtra("DataFromDb", mArrListDataFromDb);
            startActivity(mIntent);
        }
    }
}
