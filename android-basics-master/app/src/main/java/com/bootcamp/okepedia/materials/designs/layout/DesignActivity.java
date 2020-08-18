package com.bootcamp.okepedia.materials.designs.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bootcamp.okepedia.R;
import com.bootcamp.okepedia.materials.designs.webview.CompanyActivity;
import com.bootcamp.okepedia.utils.ViewUtil;
import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DesignActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private static final int READ_EXTERNAL_PERMISSION_CODE = 562;

    private ImageView ivIcon;
    private Spinner spEducations;
    private CheckBox cbJava, cbPython, cbPHP;
    private RadioGroup rgGender;
    private AppCompatRatingBar rbFeedBack;
    private Button btnCommit;
    private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        ivIcon = findViewById(R.id.ivIcon);
        spEducations = findViewById(R.id.spEducation);
        cbJava = findViewById(R.id.cbJava);
        rgGender = findViewById(R.id.rgGender);
        rbFeedBack = findViewById(R.id.rbFeedback);
        btnCommit = findViewById(R.id.btnCommit);
        etMessage = findViewById(R.id.etMessage);

//        readFromInternalStorage();

//        ivIcon.setImageDrawable(getDrawable(R.mipmap.ic_launcher));
//        ivIcon.setImageResource(R.drawable.cup);

        Glide.with(this)
                .load("http://goo.gl/gEgYUd")
                .into(ivIcon);

        try {
            URL url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ivIcon.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> educations = new ArrayList<>();
        educations.add("SMK");
        educations.add("SMA");
        educations.add("D1");
        educations.add("D2");
        educations.add("D3");
        educations.add("D4");
        educations.add("S1");
        educations.add("S2");
        educations.add("S3");

        ArrayAdapter<String> educationsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                educations);
        educationsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEducations.setAdapter(educationsAdapter);
        spEducations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("EDUCATION: ", adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spEducations.setSelection(educations.size() - 1);

//        cbPython.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);

        rgGender.setOnCheckedChangeListener(this);

        rbFeedBack.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.e("RATING", v + "");
            }
        });

        btnCommit.setOnClickListener(it -> startActivity(
                new Intent(
                        DesignActivity.this,
                        CompanyActivity.class
                )
        ));

        etMessage.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEND) {
                Toast.makeText(
                        DesignActivity.this,
                        textView.getText(),
                        Toast.LENGTH_SHORT
                ).show();

                hideKeyboard(textView);

                return true;
            }

            return false;
        });
    }

    private void hideKeyboard(View view) {
        ViewUtil.hideKeyboard(this, view);
    }

    private void readFromInternalStorage() {
        if (checkSelfPermission(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {

            loadBitmap();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_EXTERNAL_PERMISSION_CODE);
        }
    }

    private void loadBitmap() {
        final String dir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();

        Bitmap bitmap = BitmapFactory.decodeFile(dir + "/drink.png");

        ivIcon.setImageBitmap(bitmap);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            loadBitmap();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId() == R.id.cbJava) {

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId() == R.id.rgGender) {
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

            Log.e("PILIHAN: ", radioButton.getText().toString());
        }
    }
}