package com.example.konrad.gus_hackathon_2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {

            Log.d(TAG, "onCreate: success!");
        });

        Button cameraBtn = findViewById(R.id.camera);
        cameraBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(i);
        });
    }
}
