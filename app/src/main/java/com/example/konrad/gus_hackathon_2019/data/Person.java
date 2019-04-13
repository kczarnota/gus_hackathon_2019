package com.example.konrad.gus_hackathon_2019.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final SharedPreferences mSharedPrefs;

    private int mPoints;
    private List<Boolean> mAchievements = new ArrayList<>();
    private Context mContext;

    public Person(Context context) {
        mSharedPrefs = context.getSharedPreferences("Person", Context.MODE_PRIVATE);
        mPoints = mSharedPrefs.getInt("points", 0);
        mAchievements.add(mSharedPrefs.getBoolean("0", true));
        mAchievements.add(mSharedPrefs.getBoolean("1", false));
        mAchievements.add(mSharedPrefs.getBoolean("2", false));
        mAchievements.add(mSharedPrefs.getBoolean("3", false));
        mAchievements.add(mSharedPrefs.getBoolean("4", false));
        mAchievements.add(mSharedPrefs.getBoolean("5", false));
        mContext = context;
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

    public void reload() {
        mAchievements.clear();
        mPoints = mSharedPrefs.getInt("points", 0);
        mAchievements.add(mSharedPrefs.getBoolean("0", true));
        mAchievements.add(mSharedPrefs.getBoolean("1", false));
        mAchievements.add(mSharedPrefs.getBoolean("2", false));
        mAchievements.add(mSharedPrefs.getBoolean("3", false));
        mAchievements.add(mSharedPrefs.getBoolean("4", false));
        mAchievements.add(mSharedPrefs.getBoolean("5", false));
    }

    public void addScanned(String scanned) {

        switch (scanned) {

            case "bottle":
                if (!mAchievements.get(0)) {
                    setAchieved(0);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś butelkę! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
            case "person":
                if (!mAchievements.get(1)) {
                    setAchieved(1);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś osobę! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
            case "clock":
                if (!mAchievements.get(2)) {
                    setAchieved(2);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś zegar! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
            case "cell phone":
                if (!mAchievements.get(3)) {
                    setAchieved(3);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś telefon! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
            case "laptop":
                if (!mAchievements.get(4)) {
                    setAchieved(4);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś laptop! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
            case "cat":
                if (!mAchievements.get(5)) {
                    setAchieved(5);
                    Toast toast = Toast.makeText(mContext, "\uD83C\uDFC6 Znalazłeś kota! \uD83C\uDFC6",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 400);
                    toast.show();
                }
                break;
        }
    }
}