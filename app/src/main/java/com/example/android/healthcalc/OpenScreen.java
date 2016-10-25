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

    private Button mBtnGoToCalcScreen1, mBtnHelloLayout , mBtnGoDb, mBtnGoDiary;
    private Intent mIntent;
    private Context ctx = this;
    private SharedPreferences mSharPref;
    private TextView mTvCalories, mTvNutrients;
    private String mStrData ;
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

            mTvCalories.setText(String.valueOf(mSharPref.getInt("DailyCalories", 0)));

            mStrData = java.text.DateFormat.getDateInstance(3).format(new Date());
            mArrListDataFromDb = mDatabaseHelper.searchForDiary(mStrData);



        }


    }

    protected void init() {
        //binding the UI elements to variables
        mTvCalories = (TextView) findViewById(R.id.tv_open_activity_calories);
        mTvNutrients = (TextView) findViewById(R.id.tv_open_activity_nutrients);
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
        } else if (view.getId() == R.id.btn_open_activity_go_db){
            mIntent = new Intent(ctx , DatabaseScreen.class);
            startActivity(mIntent);
        }else if(view.getId() == R.id.btn_open_activity_go_diary){
            mIntent = new Intent(ctx, DiaryScreen.class);
            mIntent.putParcelableArrayListExtra("DataFromDb",mArrListDataFromDb);
            startActivity(mIntent);
        }
    }
}
