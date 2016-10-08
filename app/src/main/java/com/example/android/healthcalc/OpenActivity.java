package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class

OpenActivity extends AppCompatActivity {

    private Button mBtnGoToCalcScreen1;
    private Intent mIntnGoToCalcScreen1;
    private Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        mBtnGoToCalcScreen1=(Button)findViewById(R.id.btn_open_activity_go_calc);
        mIntnGoToCalcScreen1= new Intent(ctx,CalcScreen1.class);
        startActivity(mIntnGoToCalcScreen1);
    }
}
