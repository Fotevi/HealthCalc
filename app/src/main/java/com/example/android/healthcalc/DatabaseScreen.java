package com.example.android.healthcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_screen);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();

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
               // databaseHelper.getOneItem(tempText);

        }
    }
}
