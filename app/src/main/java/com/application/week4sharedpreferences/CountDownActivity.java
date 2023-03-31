package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {


    TextView textView;

    CountDownTimer mCountDownTimer;
    Button mButton, stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        textView = findViewById(R.id.textView3);
        mButton = findViewById(R.id.button2);
        stopButton = findViewById(R.id.button3);

//        new CountDownTimer(30000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
//            }
//
//            public void onFinish() {
//                textView.setText("done!");
//            }
//        }.start();


        mCountDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("seconds remaining: " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {

                textView.setText("done!");

            }
        };

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
            }
        });







    }
}