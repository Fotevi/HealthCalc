package com.example.android.healthcalc;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class DiaryScreen extends AppCompatActivity{
    private ArrayList<Food> mArrListDataFromDb;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private DatabaseHelper databaseHelper;
    private Context ctx = this;
    private String mCurrentDate;
    private Intent mIntent;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_screen);

        init();

        mDetector = new GestureDetectorCompat(this,new MyGestureListener());



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

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {

            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Toast.makeText(ctx,"SAAAAAAAAAAAAAA",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

}
