package com.bootcamp.okepedia.exercises.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bootcamp.okepedia.R;
import com.bootcamp.okepedia.exercises.basics.two.SecondActivity;

public class BasicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);
    }

    public void numberTwo(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}