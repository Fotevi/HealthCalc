package com.example.android.healthcalc;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Fotev on 10/20/2016.
 */
public class ADdFoodInDatabaseDialog extends DialogFragment {

    public interface IAddDialogListener{
        void onAddInDatabaseBtnClicked(int quantity);
    }

    public static IAddDialogListener dialogListener;

    private Button mBtnAdd, mBtnCancel;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    private EditText mEtQuantity;
    private int mIntQuantity;
}
