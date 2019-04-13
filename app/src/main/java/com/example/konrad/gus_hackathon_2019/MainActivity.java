package com.example.konrad.gus_hackathon_2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;

import com.example.konrad.gus_hackathon_2019.data.Person;
import com.example.konrad.gus_hackathon_2019.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Person mPerson;
    private List<Boolean> mAchievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPerson = new Person(this);
        mAchievements = mPerson.getAchievements();
        mPerson.addPoints(20);
        binding.pointsText.setText("Masz " + mPerson.getPoints() + " punktów!");

        for (int i = 0; i < mAchievements.size(); i++) {
            switch (i) {
                case 0:
                    if (mAchievements.get(i)) {
                        binding.trophy1.setText("Zdobyte");
                        binding.trophy1.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;
                case 1:
                    if (mAchievements.get(i)) {
                        binding.trophy2.setText("Zdobyte");
                        binding.trophy2.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;
                case 2:
                    if (mAchievements.get(i)) {
                        binding.trophy3.setText("Zdobyte");
                        binding.trophy3.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;
                case 3:
                    if (mAchievements.get(i)) {
                        binding.trophy4.setText("Zdobyte");
                        binding.trophy4.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;
                case 4:
                    if (mAchievements.get(i)) {
                        binding.trophy5.setText("Zdobyte");
                        binding.trophy5.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;
                case 5:
                    if (mAchievements.get(i)) {
                        binding.trophy6.setText("Zdobyte");
                        binding.trophy6.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                                getDrawable(R.drawable.ic_trophy_gold), null, null);
                    }
                    break;

            }
        }

        binding.rankingBtn.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(intent);
        });

        binding.cameraBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(i);
        });

        binding.instructionBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
            startActivity(intent);
        });
    }
}
