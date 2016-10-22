package com.example.android.healthcalc;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseScreen extends AppCompatActivity implements View.OnClickListener, RecViewAdapter.IRvOnClick, AddFoodQuantityDialog.IDialogListener {

    private EditText mEditText;
    private DatabaseHelper databaseHelper;
    private Context ctx = this;
    private Button mBtnSearch, mBtnAdd;
    private ArrayList<Food> mArrListDataFromDb;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private int mIntFoodId;
    private String mStrCurrentDate, mStringFoodName;
    private Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_screen);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();

        //databaseHelper.addItemInFoodTable("Test",10,10,10,10,0,0,0,0,0,0,0);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String tempText = mEditText.getText().toString();
                mArrListDataFromDb = databaseHelper.searchInFoodTableWK(tempText);
                mAdapter = new RecViewAdapter(mArrListDataFromDb, (RecViewAdapter.IRvOnClick) ctx);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }

    public void init() {
        mEditText = (EditText) findViewById(R.id.edit_text);

        mItemDecoration = new RecViewItemDecoration();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_database_screen_recycler);
        mLayoutManager = new LinearLayoutManager(ctx);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mItemDecoration);

        mArrListDataFromDb = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);
        mBtnSearch = (Button) findViewById(R.id.btn_database_screen_search);
        mBtnAdd = (Button) findViewById(R.id.btn_database_screen_add);
        mBtnSearch.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);

    }

    //function to show dialog
    public void showFoodQuantityDialog() {
        DialogFragment dialog = new AddFoodQuantityDialog();
        dialog.show(getFragmentManager(), "foodQuantityDialog");
    }

    @Override
    public void onClick(View view) {

        mStringFoodName = mEditText.getText().toString();

        switch (view.getId()) {
            case R.id.btn_database_screen_search:
                mArrListDataFromDb = databaseHelper.searchInFoodTable(mStringFoodName);
                mAdapter = new RecViewAdapter(mArrListDataFromDb, (RecViewAdapter.IRvOnClick) ctx);
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.btn_database_screen_add:
                mIntent = new Intent(ctx, AddFoodDatabaseScreen.class);
                mIntent.putExtra("FoodName", mStringFoodName);
                startActivity(mIntent);
                break;
        }
    }

    //gets information from recycler view
    @Override
    public void onItemSelected(int position) {
        mStrCurrentDate = java.text.DateFormat.getDateInstance(3).format(new Date());
        mIntFoodId = mArrListDataFromDb.get(position).getmIntId();
        showFoodQuantityDialog();
    }

    //get information from dialog
    @Override
    public void onAddBtnClicked(int quantity) {
        boolean check = databaseHelper.addItemInDailyNutrTable(mIntFoodId, mStrCurrentDate, quantity);
    }
}
