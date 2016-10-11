package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class

OpenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGoToCalcScreen1, mBtnHelloLayout;
    private Intent mIntentGoToCalcScreen1;
    private Context ctx = this;
    private SharedPreferences mSharPref;
    private TextView mTvCalories, mTvNutrients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharPref = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE);

        if ((mSharPref.getInt("DailyCalories", 0)) == 0) {
            setContentView(R.layout.hello_layout);
            mBtnHelloLayout = (Button) findViewById(R.id.btn_hello_layout);
            mBtnHelloLayout.setOnClickListener((View.OnClickListener) ctx);

        } else {
            setContentView(R.layout.activity_open);
            init();

            mBtnGoToCalcScreen1.setOnClickListener((View.OnClickListener) ctx);

            mTvCalories.setText(String.valueOf(mSharPref.getInt("DailyCalories", 0)));
            mTvNutrients.setText(getResources().getString(R.string.proteins) + " " + String.valueOf(mSharPref.getInt("Protein", 0)));
            mTvNutrients.append(" \n" + getResources().getString(R.string.carbs) + " " + String.valueOf(mSharPref.getInt("Carbs", 0)));
            mTvNutrients.append(" \n" + getResources().getString(R.string.fats) + " " + String.valueOf(mSharPref.getInt("Fats", 0)));

        }
    }

    protected void init() {
        mTvCalories = (TextView) findViewById(R.id.tv_open_activity_calories);
        mTvNutrients = (TextView) findViewById(R.id.tv_open_activity_nutrients);
        mBtnGoToCalcScreen1 = (Button) findViewById(R.id.btn_open_activity_go_calc);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hello_layout) {
            mIntentGoToCalcScreen1 = new Intent(ctx, CalcScreen1.class);
            startActivity(mIntentGoToCalcScreen1);
        } else if (view.getId() == R.id.btn_open_activity_go_calc) {
            mIntentGoToCalcScreen1 = new Intent(ctx, CalcScreen1.class);
            startActivity(mIntentGoToCalcScreen1);
        }
    }
}
