package com.bootcamp.okepedia.exercises.basics.two;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.bootcamp.okepedia.R;

public class SecondActivity extends AppCompatActivity {

    public static final int code = 658;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void next(View view) {
        startActivityForResult(
                new Intent(this, ResultActivity.class),
                SecondActivity.code
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String text = data.getStringExtra(ResultActivity.data);

            if (requestCode == SecondActivity.code && resultCode == ResultActivity.code) {
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        }
    }
}