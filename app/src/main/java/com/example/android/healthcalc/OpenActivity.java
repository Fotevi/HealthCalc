package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class

OpenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGoToCalcScreen1, mBtnHelloLayout;
    private Intent mIntnGoToCalcScreen1;
    private Context ctx = this;
    private SharedPreferences mSharPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        if ((int) (mSharPref.getFloat("Fats", 0.00f)) == 0) {
            setContentView(R.layout.hello_layout);
            mBtnHelloLayout=(Button)findViewById(R.id.btn_hello_layout);
            mBtnHelloLayout.setOnClickListener((View.OnClickListener) ctx);
        } else {
            setContentView(R.layout.activity_open);
            mBtnGoToCalcScreen1=(Button)findViewById(R.id.btn_open_activity_go_calc);
            mBtnGoToCalcScreen1.setOnClickListener((View.OnClickListener) ctx);
        }


    }

    protected void init() {
        mSharPref = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE);
        mBtnHelloLayout=(Button)findViewById(R.id.btn_hello_layout);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_hello_layout){
            mIntnGoToCalcScreen1=new Intent(ctx,CalcScreen1.class);
            startActivity(mIntnGoToCalcScreen1);
        }else if(view.getId()==R.id.btn_open_activity_go_calc){
            mIntnGoToCalcScreen1=new Intent(ctx,CalcScreen1.class);
            startActivity(mIntnGoToCalcScreen1);
        }
    }
}
