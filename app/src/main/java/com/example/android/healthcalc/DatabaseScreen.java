package com.example.android.healthcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseScreen extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    DatabaseHelper databaseHelper;
    Context ctx=this;
    Button mBtnSearch , mBtnAdd;
    ArrayList<Food> mArrListDataFromDb;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.ItemDecoration mItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_screen);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();

        //Food food=new Food("food",50,50,50,50);
        //databaseHelper.addItem(food);

    }

    public void init(){
        mEditText=(EditText)findViewById(R.id.edit_text);
        /*mEditText.addTextChangedListener(new TextWatcher() {
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
        });*/
        mItemDecoration=new RecViewItemDecoration();
        mRecyclerView=(RecyclerView)findViewById(R.id.rv_database_screen_recycler);
        mLayoutManager=new LinearLayoutManager(ctx);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mItemDecoration);

        mArrListDataFromDb=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        mBtnSearch = (Button) findViewById(R.id.btn_database_screen_search);
        mBtnAdd = (Button) findViewById(R.id.btn_database_screen_add);
        mBtnSearch.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_database_screen_search:
                String tempText = mEditText.getText().toString();
                Toast.makeText(ctx,tempText,Toast.LENGTH_LONG).show();
                mArrListDataFromDb=databaseHelper.getOneItem(tempText);
                mAdapter=new RecViewAdapter(mArrListDataFromDb);
                mRecyclerView.setAdapter(mAdapter);
        }
    }
}
