package com.bootcamp.okepedia.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bootcamp.okepedia.R;
import com.bootcamp.okepedia.exercises.basics.BasicsActivity;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Button btnNavigation = findViewById(R.id.btnNavigation);
        btnNavigation.setOnClickListener(this::moveToBasics);
    }

    public void moveToBasics(View view) {
        startActivity(new Intent(this, BasicsActivity.class));
    }
}