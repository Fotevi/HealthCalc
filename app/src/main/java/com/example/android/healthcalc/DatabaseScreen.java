package com.example.android.healthcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseScreen extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_screen);

        databaseHelper = new DatabaseHelper(this);
        int testInt = 10;
        Food testFood = new Food("TestFood",testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt,testInt);

        boolean test = databaseHelper.addItem(testFood);

        ArrayList<Food> testlist = databaseHelper.getOneItem(testFood.getmStrName());

        Toast.makeText(this,String.valueOf(test),Toast.LENGTH_LONG);
        Toast.makeText(this,String.valueOf(test),Toast.LENGTH_LONG);
    }
}
