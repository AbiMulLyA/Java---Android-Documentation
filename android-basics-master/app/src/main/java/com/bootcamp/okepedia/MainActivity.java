package com.bootcamp.okepedia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bootcamp.okepedia.exercises.ExerciseActivity;
import com.bootcamp.okepedia.materials.MaterialActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Multi Daya Dinamika");
        }

        Button btnMaterial = findViewById(R.id.btnMaterial),
                btnExercise = findViewById(R.id.btnExercise);

        btnMaterial.setOnClickListener(view -> startActivity(
                new Intent(
                        MainActivity.this,
                        MaterialActivity.class)
                )
        );

        btnExercise.setOnClickListener(view -> startActivity(
                new Intent(
                        MainActivity.this,
                        ExerciseActivity.class
                )
        ));
    }
}