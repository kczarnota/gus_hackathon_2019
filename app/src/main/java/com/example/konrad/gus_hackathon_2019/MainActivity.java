package com.example.konrad.gus_hackathon_2019;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.konrad.gus_hackathon_2019.data.Person;
import com.example.konrad.gus_hackathon_2019.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Person mPerson;
    private ActivityMainBinding mBinding;
    private int mEyeClickedCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.rankingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        mBinding.cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlotActivity.class);
                startActivity(intent);
            }
        });

        mBinding.instructionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });

        mBinding.eyeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEyeClickedCounter < 5) {
                    mEyeClickedCounter++;

                    if (mEyeClickedCounter == 5) {
                        mPerson.setAchieved(0);
                        update();
                        Toast.makeText(getBaseContext(), "Jestes Statystykiem!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mPerson = new Person(this);
        update();
    }

    private void update() {
        mBinding.pointsText.setText("Masz " + mPerson.getPoints() + " punktów!");

        List<Boolean> achievements = mPerson.getAchievements();

        for (int i = 0; i < achievements.size(); i++) {
            switch (i) {
                case 0:
                    if (achievements.get(i)) {
                        mBinding.trophy1.setText("Zdobyte");
                        mBinding.trophy1.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                        mEyeClickedCounter = 5;
                    } else {
                        mBinding.trophy1.setText("");
                        mBinding.trophy1.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
                    }
                    break;
                case 1:
                    if (achievements.get(i)) {
                        mBinding.trophy2.setText("Zdobyte");
                        mBinding.trophy2.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    } else {
                        mBinding.trophy2.setText("");
                        mBinding.trophy2.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
                    }
                    break;
                case 2:
                    if (achievements.get(i)) {
                        mBinding.trophy3.setText("Zdobyte");
                        mBinding.trophy3.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    } else {
                        mBinding.trophy3.setText("");
                        mBinding.trophy3.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
                    }
                    break;
                case 3:
                    if (achievements.get(i)) {
                        mBinding.trophy4.setText("Zdobyte");
                        mBinding.trophy4.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    } else {
                        mBinding.trophy4.setText("");
                        mBinding.trophy4.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
                    }
                    break;
                case 4:
                    if (achievements.get(i)) {
                        mBinding.trophy5.setText("Zdobyte");
                        mBinding.trophy5.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    } else {
                        mBinding.trophy5.setText("");
                        mBinding.trophy5.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
                    }
                    break;
                case 5:
                    if (achievements.get(i)) {
                        mBinding.trophy6.setText("Zdobyte");
                        mBinding.trophy6.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    } else {
                        mBinding.trophy6.setText("");
                        mBinding.trophy6.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy), null, null);
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
