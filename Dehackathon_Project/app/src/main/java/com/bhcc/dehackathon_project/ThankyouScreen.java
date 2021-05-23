package com.bhcc.dehackathon_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThankyouScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou_screen);
    }
    public void goBack(){
        Intent goBack = new Intent(this,MainActivity.class);
        startActivity(goBack);
    }
}