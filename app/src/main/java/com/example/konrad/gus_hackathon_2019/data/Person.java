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
        mPoints += 10;
        editor.putInt("points", mPoints);
        editor.apply();
    }

    public void reset() {
        mPoints = 0;
        mAchievements.clear();

        for (int i = 0; i < 6; i++) {
            mAchievements.add(false);
        }

        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putInt("points", mPoints);
        editor.putBoolean("0", false);
        editor.putBoolean("1", false);
        editor.putBoolean("2", false);
        editor.putBoolean("3", false);
        editor.putBoolean("4", false);
        editor.putBoolean("5", false);
        editor.apply();
    }
}