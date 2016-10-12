package com.example.android.healthcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseScreen extends AppCompatActivity {

    private EditText mEditText;
    DatabaseHelper databaseHelper;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_screen);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        mEditText=(EditText)findViewById(R.id.edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(ctx,"OnTextChanged",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(ctx,"afterTectChanged",Toast.LENGTH_SHORT).show();
            }
        });

        databaseHelper = new DatabaseHelper(this);
        int testInt = 10;
        Food testFood = new Food("TestFood",testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt);

        boolean test = databaseHelper.addItem(testFood);

        ArrayList<Food> testlist = databaseHelper.getOneItem(testFood.getmStrName());

        Toast.makeText(this,String.valueOf(test),Toast.LENGTH_LONG);
        Toast.makeText(this,String.valueOf(test),Toast.LENGTH_LONG);
    }
}
