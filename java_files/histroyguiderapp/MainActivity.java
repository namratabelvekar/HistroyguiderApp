package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int ROTATE_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = findViewById(R.id.progressBar);


        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(ROTATE_DURATION);
        rotateAnimation.setRepeatCount(0);
        progressBar.startAnimation(rotateAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {

                Intent intent = new Intent(MainActivity.this, history_places_button.class);
                startActivity(intent);
                finish();
            }
        }, ROTATE_DURATION);
    }
}