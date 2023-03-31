package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTextView = findViewById(R.id.textView2);

//        sharedPreferences = getPreferences(Context.MODE_PRIVATE);


        sharedPreferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        String nameFromShared = sharedPreferences.getString("name", "");
        Toast.makeText(this, nameFromShared, Toast.LENGTH_SHORT).show();

        mTextView.setText(nameFromShared);










    }
}