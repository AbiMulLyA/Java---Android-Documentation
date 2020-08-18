package com.mdd.pasarindo.activites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.mdd.pasarindo.R;
import com.mdd.pasarindo.databinding.ActivityProductBinding;
import com.mdd.pasarindo.entities.Product;
import com.mdd.pasarindo.utils.ViewUtil;
import com.mdd.pasarindo.viewmodels.ProductViewModel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductActivity extends AppCompatActivity {

    private ActivityProductBinding binding;

    private boolean isUpdate = false;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private File file;

    private ProductViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        Product product = getIntent().getParcelableExtra(MainActivity.DATA_PRODUCT);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("NEW PRODUCT");
        }

        if (product != null) {
            isUpdate = true;

            viewModel.setPhoto(product.getPhoto());
            viewModel.setProduct(product);

            binding.btnSubmit.setText("UPDATE PRODUCT");

            getSupportActionBar().setTitle("UPDATE " + product.getName().toUpperCase());
        } else {
            product = new Product("", "", 0, 0, "");
        }

        binding.cvProduct.setOnClickListener(view -> takePhoto());

        Product finalProduct = product;
        binding.btnSubmit.setOnClickListener(view -> {
            try {
                if (TextUtils.isEmpty(binding.etProduct.getText().toString()) ||
                        TextUtils.isEmpty(binding.etPrice.getText().toString()) ||
                        TextUtils.isEmpty(binding.etQuantity.getText().toString()) ||
                        TextUtils.isEmpty(binding.etDescription.getText().toString())) {
                    ViewUtil.showMessage(
                            binding.getRoot(),
                            "Nama produk, harga, kuantitas dan deskrpsi produk tidak boleh kosong"
                    );

                    return;
                }

                if (file != null) {
                    finalProduct.setPhoto(file.getAbsolutePath());
                }

                finalProduct.setName(binding.etProduct.getText().toString());
                finalProduct.setDescription(binding.etDescription.getText().toString());
                finalProduct.setPrice(Long.parseLong(binding.etPrice.getText().toString()));
                finalProduct.setQuantity(Long.parseLong(binding.etQuantity.getText().toString()));

                if (isUpdate) {
                    viewModel.updateProduct(finalProduct);
                } else {
                    viewModel.insertProduct(finalProduct);
                }

                finish();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        binding.setViewModel(viewModel);
    }

    private File createImageFile() {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File image = File.createTempFile(
                    "IMG_" + timeStamp + "_",
                    ".jpg",
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            );
            file = image;
            return image;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

    private void takePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = createImageFile();

            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            binding.setPhoto(file.getAbsolutePath());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
    }
}