package com.example.konrad.gus_hackathon_2019.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.widget.Toast;

import com.example.konrad.gus_hackathon_2019.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private final SharedPreferences mSharedPrefs;

    private int mPoints;
    private List<Boolean> mAchievements = new ArrayList<>();
    private Context mContext;

    public final static String STATISTIC = "statystyk";
    private static String POINTS = "points";
    private static String ACHIVEMENT_0 = "0";
    private static String ACHIVEMENT_1 = "1";
    private static String ACHIVEMENT_2 = "2";
    private static String ACHIVEMENT_3 = "3";
    private static String ACHIVEMENT_4 = "4";
    private static String ACHIVEMENT_5 = "5";
    private static String ACHIVEMENT_6 = "6";


    public Person(Context context) {
        mSharedPrefs = context.getSharedPreferences("Person", Context.MODE_PRIVATE);
        mPoints = mSharedPrefs.getInt(POINTS, 0);
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_0, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_1, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_2, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_3, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_4, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_5, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_6, false));
        mContext = context;
    }

    public int getPoints() {
        return mPoints;
    }

    public void addPoints(int points) {
        mPoints += points;
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putInt(POINTS, mPoints);
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
        editor.putInt(POINTS, mPoints);
        editor.apply();
    }

    public void reset() {
        mPoints = 0;
        mAchievements.clear();

        for (int i = 0; i < 7; i++) {
            mAchievements.add(false);
        }

        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putInt(POINTS, mPoints);
        editor.putBoolean(ACHIVEMENT_0, false);
        editor.putBoolean(ACHIVEMENT_1, false);
        editor.putBoolean(ACHIVEMENT_2, false);
        editor.putBoolean(ACHIVEMENT_3, false);
        editor.putBoolean(ACHIVEMENT_4, false);
        editor.putBoolean(ACHIVEMENT_5, false);
        editor.putBoolean(ACHIVEMENT_6, false);

        editor.apply();
    }

    public void reload() {
        mAchievements.clear();
        mPoints = mSharedPrefs.getInt(POINTS, 0);
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_0, true));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_1, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_2, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_3, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_4, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_5, false));
        mAchievements.add(mSharedPrefs.getBoolean(ACHIVEMENT_6, false));

    }

    public void addScanned(String scanned) {
        switch (scanned) {
            case "bottle":
                if (!mAchievements.get(0)) {
                    setAchieved(0);
                    notifyAchievementUnlocked(R.string.found_bottle);
                }
                break;
            case "person":
                if (!mAchievements.get(1)) {
                    setAchieved(1);
                    notifyAchievementUnlocked(R.string.found_person);
                }
                break;
            case "clock":
                if (!mAchievements.get(2)) {
                    setAchieved(2);
                    notifyAchievementUnlocked(R.string.found_clock);
                }
                break;
            case "cell phone":
                if (!mAchievements.get(3)) {
                    setAchieved(3);
                    notifyAchievementUnlocked(R.string.found_phone);
                }
                break;
            case "laptop":
                if (!mAchievements.get(4)) {
                    setAchieved(4);
                    notifyAchievementUnlocked(R.string.found_laptop);
                }
                break;
            case "cat":
                if (!mAchievements.get(5)) {
                    setAchieved(5);
                    notifyAchievementUnlocked(R.string.found_cat);
                }
                break;
            case STATISTIC:
                if (!mAchievements.get(6)) {
                    setAchieved(6);
                    addPoints(90);
                    notifyAchievementUnlocked(R.string.statystyk);
                }
                break;
        }
    }

    private void notifyAchievementUnlocked(int messageId) {
        String msg = "\uD83C\uDFC6 " + mContext.getString(messageId) + " \uD83C\uDFC6";
        Toast toast = Toast.makeText(mContext, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 400);
        toast.show();

        startSound("NFF-coin-04.wav"); // more free sounds can be found at NoiseForFun.com
    }

    private void startSound(String filename) {
        AssetFileDescriptor afd = null;
        try {
            afd = mContext.getResources().getAssets().openFd(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaPlayer player = new MediaPlayer();
        try {
            assert afd != null;
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();
    }
}