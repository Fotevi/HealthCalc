package com.example.android.healthcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMicrosDatabaseScreen extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtVitA, mEtVitB6, mEtVitC, mEtVitD, mEtZinc, mEtMagnesium, mEtIron;
    private Button mBtnAddMicros;
    private DatabaseHelper mDatabaseHelper;
    private int mIntCalories, mIntProteins, mIntCarbs, mIntFats, mIntVitA, mIntVitB6,
            mIntVitC, mIntVitD, mIntZinc, mIntMagnesium, mIntIron;
    private String mStrName;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_micros_database_screen);

        init();
        mBtnAddMicros.setOnClickListener(this);
    }

    void init() {
        mEtVitA = (EditText) findViewById(R.id.et_add_in_db_vitA);
        mEtVitB6 = (EditText) findViewById(R.id.et_add_in_db_vitB6);
        mEtVitC = (EditText) findViewById(R.id.et_add_in_db_vitC);
        mEtVitD = (EditText) findViewById(R.id.et_add_in_db_vitD);
        mEtZinc = (EditText) findViewById(R.id.et_add_in_db_Zinc);
        mEtMagnesium = (EditText) findViewById(R.id.et_add_in_db_Magnesium);
        mEtIron = (EditText) findViewById(R.id.et_add_in_db_Iron);
        mBtnAddMicros = (Button) findViewById(R.id.btn_add_micros_in_db);
        mDatabaseHelper = new DatabaseHelper(this);
        mIntent = new Intent();
        mIntCalories = getIntent().getIntExtra("Calories",0);
        mIntProteins = getIntent().getIntExtra("Proteins",0);
        mIntCarbs = getIntent().getIntExtra("Carbs",0);
        mIntFats = getIntent().getIntExtra("Fats",0);
        mStrName = getIntent().getStringExtra("Name");
    }

    @Override
    public void onClick(View view) {

        mIntVitA = Integer.valueOf(mEtVitA.getText().toString());
        mIntVitB6 = Integer.valueOf(mEtVitB6.getText().toString());
        mIntVitC = Integer.valueOf(mEtVitC.getText().toString());
        mIntVitD = Integer.valueOf(mEtVitD.getText().toString());
        mIntZinc = Integer.valueOf(mEtZinc.getText().toString());
        mIntMagnesium = Integer.valueOf(mEtMagnesium.getText().toString());
        mIntIron = Integer.valueOf(mEtIron.getText().toString());

        boolean check=mDatabaseHelper.addItemInFoodTable(mStrName,mIntCalories,mIntProteins,mIntCarbs,mIntFats,mIntVitA
                ,mIntVitB6,mIntVitC,mIntVitD,mIntZinc,mIntMagnesium,mIntIron);
        if(check){

            mIntent=new Intent(this,DatabaseScreen.class);
            mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mIntent);
        }
        else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
