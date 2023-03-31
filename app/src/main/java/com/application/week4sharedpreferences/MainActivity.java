package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Two ways:
    //1. getSharedPreferences()
    //2. getPreferences()

    SharedPreferences sharedPreferences, preferences;
    Button loginButton;
    CheckBox checkBox;
    EditText userName, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkBox);
        userName = findViewById(R.id.editTextTextPersonName);
        passWord = findViewById(R.id.editTextTextPassword);

//        preferences = getPreferences(Context.MODE_PRIVATE); //First Way

        preferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE); //Second Way

        String nameFromSharedPreference = preferences.getString("name","");
        String passwordFromSharedPreference = preferences.getString("password","");
        userName.setText(nameFromSharedPreference);
        passWord.setText(passwordFromSharedPreference);

        if(nameFromSharedPreference != ""){
//            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            Intent intent = new Intent(MainActivity.this, CountDownActivity.class);
//            Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
            startActivity(intent);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Checked", "Yess");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                if(checkBox.isChecked()){

                    editor.putString("name", userName.getText().toString());
                    editor.putString("password", passWord.getText().toString());
                    editor.apply();
//
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
                else{
                    editor.putString("name", "");
                    editor.putString("password", "");
                    editor.apply();
                }


            }
        });

    }
}