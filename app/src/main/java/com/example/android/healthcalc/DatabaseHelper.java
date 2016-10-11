package com.example.android.healthcalc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Fotev on 10/11/2016.
 */
public class DatabaseHelper  extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "foods.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
