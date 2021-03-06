package com.example.konrad.gus_hackathon_2019;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.konrad.gus_hackathon_2019.data.Person;
import com.example.konrad.gus_hackathon_2019.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Person mPerson;
    private ActivityMainBinding mBinding;
    private int mEyeClickedCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.rankingBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RankingActivity.class);
            startActivity(intent);
        });

        mBinding.cameraBtn.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, R.string.grand_perm, Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
            }
        });

        mBinding.instructionBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
            startActivity(intent);
        });

        mBinding.eyeImage.setOnClickListener(view -> {
            if (mEyeClickedCounter < 5) {
                mEyeClickedCounter++;

                if (mEyeClickedCounter == 5) {
                    mPerson.addScanned(Person.STATISTIC);
                    update();
                }
            }
        });
        mPerson = new Person(this);
        update();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPerson.reload();
        update();
    }

    private void update() {
        mBinding.pointsText.setText(getString(R.string.have_points, Integer.toString(mPerson.getPoints())));

        List<Boolean> achievements = mPerson.getAchievements();

        for (int i = 0; i < achievements.size(); i++) {
            switch (i) {
                case 0:
                    if (achievements.get(i)) {
                        mBinding.trophy1.setText(R.string.achived);
                        mBinding.trophy1.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_water), null, null);
                        mEyeClickedCounter = 5;
                    } else {
                        mBinding.trophy1.setText("");
                        mBinding.trophy1.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_water_sec), null, null);
                    }
                    break;
                case 1:
                    if (achievements.get(i)) {
                        mBinding.trophy2.setText(R.string.achived);
                        mBinding.trophy2.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_person), null, null);
                    } else {
                        mBinding.trophy2.setText("");
                        mBinding.trophy2.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_person_sec), null, null);
                    }
                    break;
                case 2:
                    if (achievements.get(i)) {
                        mBinding.trophy3.setText(R.string.achived);
                        mBinding.trophy3.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_clock), null, null);
                    } else {
                        mBinding.trophy3.setText("");
                        mBinding.trophy3.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_clock_sec), null, null);
                    }
                    break;
                case 3:
                    if (achievements.get(i)) {
                        mBinding.trophy4.setText(R.string.achived);
                        mBinding.trophy4.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_smartphone), null, null);
                    } else {
                        mBinding.trophy4.setText("");
                        mBinding.trophy4.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_smartphone_sec), null, null);
                    }
                    break;
                case 4:
                    if (achievements.get(i)) {
                        mBinding.trophy5.setText(R.string.achived);
                        mBinding.trophy5.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_laptop), null, null);
                    } else {
                        mBinding.trophy5.setText("");
                        mBinding.trophy5.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_laptop_sec), null, null);
                    }
                    break;
                case 5:
                    if (achievements.get(i)) {
                        mBinding.trophy6.setText(R.string.achived);
                        mBinding.trophy6.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_cat), null, null);
                    } else {
                        mBinding.trophy6.setText("");
                        mBinding.trophy6.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_cat_sec), null, null);
                    }
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            mPerson.reset();
            mEyeClickedCounter = 0;
            update();
        }

        return true;
    }
}
