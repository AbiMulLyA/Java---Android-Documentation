package com.bootcamp.okepedia.exercises.basics.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bootcamp.okepedia.R;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etResult;
    Button btnBack;

    public static final String data = "data";
    public static final int code = 466;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        etResult = findViewById(R.id.etResult);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) {
            backWithData();
        }
    }

    private void backWithData() {
        String data = etResult.getText().toString();

        if (data.trim().length() == 0) {
            Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(ResultActivity.data, data);
            setResult(ResultActivity.code, intent);
            finish();
        }
    }
}