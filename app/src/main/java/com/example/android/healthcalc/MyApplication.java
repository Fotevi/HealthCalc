package com.example.android.healthcalc;

/**
 * Created by Fotev on 11/6/2016.
 */
public class MyApplication extends android.app.Application {
    public static int appAge, appGoal ;
    public static boolean appGender ;
    public static float appHeight;
    public static float appWeight;

    private static MyApplication singleton;

    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

}
