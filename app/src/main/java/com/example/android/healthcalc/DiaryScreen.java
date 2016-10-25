package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class DiaryScreen extends AppCompatActivity {
    private ArrayList<Food> mArrListDataFromDb;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private DatabaseHelper databaseHelper;
    private Context ctx = this;
    private String mCurrentDate;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_screen);

        init();

        mIntent = getIntent();
        mCurrentDate = java.text.DateFormat.getDateInstance(3).format(new Date());
        mArrListDataFromDb = mIntent.getParcelableArrayListExtra("DataFromDb");

        if(mArrListDataFromDb != null) {
            if (mArrListDataFromDb.size() != 0) {
                mAdapter = new RecViewAdapterDiary(mArrListDataFromDb);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }

    public void init(){
        mItemDecoration = new RecViewItemDecoration();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_diary_screen);
        mLayoutManager = new LinearLayoutManager(ctx);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mItemDecoration);

        mArrListDataFromDb = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);
        mIntent = new Intent();

    }
}
