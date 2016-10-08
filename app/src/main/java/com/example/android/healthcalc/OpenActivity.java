package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class

OpenActivity extends AppCompatActivity {

    private Button mBtnGoToCalcScreen1;
    private Intent mIntnGoToCalcScreen1;
    private Context ctx = this;
    private SharedPreferences mSharPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float test ;
        mSharPref = getSharedPreferences("MySharedPrefs",Context.MODE_PRIVATE);
        test = (mSharPref.getFloat("Fats",0.00f));
          if (test == 0) {
            mBtnGoToCalcScreen1 = (Button) findViewById(R.id.btn_open_activity_go_calc);
            mIntnGoToCalcScreen1 = new Intent(ctx, CalcScreen1.class);
            startActivity(mIntnGoToCalcScreen1);
        } else {
            setContentView(R.layout.activity_open);
            Toast.makeText(this, "Test ", Toast.LENGTH_LONG);
        }
    }
}
