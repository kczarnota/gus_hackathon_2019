package com.example.konrad.gus_hackathon_2019;

import android.content.Context;
import android.content.SharedPreferences;

public class Person {
    private final Context mContext;
    private final SharedPreferences mSharedPrefs;

    private int mPoints;

    public Person(Context context) {
        mContext = context;
        mSharedPrefs = context.getSharedPreferences("Person", Context.MODE_PRIVATE);
        mPoints = mSharedPrefs.getInt("points", 0);
    }

    public int getPoints() {
        return mPoints;
    }

    public void addPoints(int points) {
        mPoints += points;
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putInt("points", mPoints);
        editor.apply();
    }
}