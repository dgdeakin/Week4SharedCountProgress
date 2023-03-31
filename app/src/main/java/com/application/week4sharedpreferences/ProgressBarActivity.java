package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {



    int progress = 0;

    ProgressBar progressBar;
    Button buttonStartBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);


        progressBar = findViewById(R.id.progressBar);
        buttonStartBar = findViewById(R.id.button4);
        progressBar.setMax(100);
        progressBar.setProgress(50);
//        progressBar.setIndeterminate(true);



        buttonStartBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

//                setProgressValue(progress);
                progressBar.setMax(5);
                progressBar.setProgress(2);
//                progressBar.setIndeterminate(true);
            }
        });

    }

    private void setProgressValue(final int progress) {

        // set the progress
        progressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }

}