package com.example.android.healthcalc;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Fotev on 11/14/2016.
 */
public class FoodInDIary extends Food{
private int intIdNutritionTable;

    public FoodInDIary(Parcel in){
        super.mIntId = in.readInt();
        super.mStrName = in.readString();
        super.mIntCalories = in.readInt();
        super.mIntProtein = in.readInt();
        super.mIntCarbs = in.readInt();
        super.mIntFats = in.readInt();
        super.mIntVitA = in.readInt();
        super.mIntVitB6 = in.readInt();
        super.mIntVitC = in.readInt();
        super.mIntVitD = in.readInt();
        super.mIntZinc = in.readInt();
        super.mIntMagnesium = in.readInt();
        super.mIntIron = in.readInt();
        super.mIntQuantity=in.readInt();
        this.intIdNutritionTable = in.readInt();
    }

    public FoodInDIary(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel,i);
        parcel.writeInt(intIdNutritionTable);
    }

    public static final Parcelable.Creator<FoodInDIary> CREATOR
            = new Parcelable.Creator<FoodInDIary>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public FoodInDIary createFromParcel(Parcel in) {
            return new  FoodInDIary(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public FoodInDIary[] newArray(int size) {
            return new FoodInDIary[size];
        }
    };

    public int getIntIdNutritionTable() {
        return intIdNutritionTable;
    }

    public void setIntIdNutritionTable(int intIdNutritionTable) {
        this.intIdNutritionTable = intIdNutritionTable;
    }
}
