package com.example.konrad.gus_hackathon_2019.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final SharedPreferences mSharedPrefs;

    private int mPoints;
    private List<Boolean> mAchievements = new ArrayList<>();

    public Person(Context context) {
        mSharedPrefs = context.getSharedPreferences("Person", Context.MODE_PRIVATE);
        mPoints = mSharedPrefs.getInt("points", 0);
        mAchievements.add(mSharedPrefs.getBoolean("0", true));
        mAchievements.add(mSharedPrefs.getBoolean("1", false));
        mAchievements.add(mSharedPrefs.getBoolean("2", false));
        mAchievements.add(mSharedPrefs.getBoolean("3", false));
        mAchievements.add(mSharedPrefs.getBoolean("4", false));
        mAchievements.add(mSharedPrefs.getBoolean("5", false));
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

    public List<Boolean> getAchievements() {
        return mAchievements;
    }

    public void setAchieved(int index) {
        mAchievements.set(index, true);
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putBoolean(Integer.toString(index), true);
        editor.apply();
    }
}