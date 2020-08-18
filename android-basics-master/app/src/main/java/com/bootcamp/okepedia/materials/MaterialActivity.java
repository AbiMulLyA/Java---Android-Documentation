package com.bootcamp.okepedia.materials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bootcamp.okepedia.R;
import com.bootcamp.okepedia.materials.designs.layout.DesignActivity;

public class MaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
    }

    public void moveToViewAndLayout(View view) {
        startActivity(
                new Intent(this, DesignActivity.class)
        );
    }
}