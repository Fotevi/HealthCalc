package com.example.android.healthcalc;

/**
 * Created by Fotev on 10/12/2016.
 */
public class Food {

    //Class maping the columns in Foods database

    private int mIntId;
    private String mStrName;
    private int mIntCalories;
    private int mIntProtein;
    private int mIntCarbs;
    private int mIntFats;
    private int mIntVitA;
    private int mIntVitB6;
    private int mIntVitC;
    private int mIntVitD;
    private int mIntZinc;
    private int mIntMagnesium;
    private int mIntIron;
    private int mIntQuantity;

    public Food(int mIntId, String mStrName, int mIntCalories, int mIntProtein,
                 int mIntCarbs, int mIntFats, int mIntVitA, int mIntVitB6, int mIntVitC,
                 int mIntVitD, int mIntZinc, int mIntMagnesium, int mIntIron) {
        this.mIntId = mIntId;
        this.mStrName = mStrName;
        this.mIntCalories = mIntCalories;
        this.mIntProtein = mIntProtein;
        this.mIntCarbs = mIntCarbs;
        this.mIntFats = mIntFats;
        this.mIntVitA = mIntVitA;
        this.mIntVitB6 = mIntVitB6;
        this.mIntVitC = mIntVitC;
        this.mIntVitD = mIntVitD;
        this.mIntZinc = mIntZinc;
        this.mIntMagnesium = mIntMagnesium;
        this.mIntIron = mIntIron;
    }

    public Food(String mStrName, int mIntCalories, int mIntProtein,
                int mIntCarbs, int mIntFats, int mIntVitA, int mIntVitB6, int mIntVitC,
                int mIntVitD, int mIntZinc, int mIntMagnesium, int mIntIron) {
        this.mStrName = mStrName;
        this.mIntCalories = mIntCalories;
        this.mIntProtein = mIntProtein;
        this.mIntCarbs = mIntCarbs;
        this.mIntFats = mIntFats;
        this.mIntVitA = mIntVitA;
        this.mIntVitB6 = mIntVitB6;
        this.mIntVitC = mIntVitC;
        this.mIntVitD = mIntVitD;
        this.mIntZinc = mIntZinc;
        this.mIntMagnesium = mIntMagnesium;
        this.mIntIron = mIntIron;
    }

    public Food(String mStrName, int mIntCalories, int mIntProtein,
                int mIntCarbs, int mIntFats) {
        this.mStrName = mStrName;
        this.mIntCalories = mIntCalories;
        this.mIntProtein = mIntProtein;
        this.mIntCarbs = mIntCarbs;
        this.mIntFats = mIntFats;
    }

    public Food(){}


    public int getmIntId() {
        return mIntId;
    }

    public void setmIntId(int mIntId) {
        this.mIntId = mIntId;
    }

    public String getmStrName() {
        return mStrName;
    }

    public void setmStrName(String mStrName) {
        this.mStrName = mStrName;
    }

    public int getmIntCalories() {
        return mIntCalories;
    }

    public void setmIntCalories(int mIntCalories) {
        this.mIntCalories = mIntCalories;
    }

    public int getmIntProtein() {
        return mIntProtein;
    }

    public void setmIntProtein(int mIntProtein) {
        this.mIntProtein = mIntProtein;
    }

    public int getmIntCarbs() {
        return mIntCarbs;
    }

    public void setmIntCarbs(int mIntCarbs) {
        this.mIntCarbs = mIntCarbs;
    }

    public int getmIntFats() {
        return mIntFats;
    }

    public void setmIntFats(int mIntFats) {
        this.mIntFats = mIntFats;
    }

    public int getmIntVitA() {
        return mIntVitA;
    }

    public void setmIntVitA(int mIntVitA) {
        this.mIntVitA = mIntVitA;
    }

    public int getmIntVitB6() {
        return mIntVitB6;
    }

    public void setmIntVitB6(int mIntVitB6) {
        this.mIntVitB6 = mIntVitB6;
    }

    public int getmIntVitC() {
        return mIntVitC;
    }

    public void setmIntVitC(int mIntVitC) {
        this.mIntVitC = mIntVitC;
    }

    public int getmIntVitD() {
        return mIntVitD;
    }

    public void setmIntVitD(int mIntVitD) {
        this.mIntVitD = mIntVitD;
    }

    public int getmIntZinc() {
        return mIntZinc;
    }

    public void setmIntZinc(int mIntZinc) {
        this.mIntZinc = mIntZinc;
    }

    public int getmIntMagnesium() {
        return mIntMagnesium;
    }

    public void setmIntMagnesium(int mIntMagnesium) {
        this.mIntMagnesium = mIntMagnesium;
    }

    public int getmIntIron() {
        return mIntIron;
    }

    public void setmIntIron(int mIntIron) {
        this.mIntIron = mIntIron;
    }

    public void setmIntQuantity(int mIntQuantity) {
        this.mIntQuantity = mIntQuantity;
    }

    public int getmIntQuantity() {
        return mIntQuantity;

    }
}
