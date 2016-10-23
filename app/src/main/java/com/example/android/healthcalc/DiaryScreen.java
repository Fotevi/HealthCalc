package com.example.android.healthcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_screen);

        init();

        mCurrentDate = java.text.DateFormat.getDateInstance(3).format(new Date());
        mArrListDataFromDb = databaseHelper.searchForDiary(mCurrentDate);
        if (mArrListDataFromDb.size() != 0) {
            mAdapter = new RecViewAdapterDiary(mArrListDataFromDb);
            mRecyclerView.setAdapter(mAdapter);
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


    }
}
