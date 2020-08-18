package com.mdd.pasarindo.activites;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.mdd.pasarindo.R;
import com.mdd.pasarindo.adapters.ProductAdapter;
import com.mdd.pasarindo.databinding.ActivityMainBinding;
import com.mdd.pasarindo.entities.Product;
import com.mdd.pasarindo.viewmodels.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String DATA_PRODUCT = "DATA_PRODUCT";

    private static final int REQUEST_PERMISSIONS = 111;

    private ActivityMainBinding binding;

    private String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestPermissions(permissions, REQUEST_PERMISSIONS);

        ProductAdapter adapter = new ProductAdapter();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rvProducts.setAdapter(adapter);

        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        viewModel.getProducts().observe(this, adapter::setProducts);

        adapter.setListener(new ProductAdapter.ProductListener() {
            @Override
            public void onUpdate(Product product) {
                startActivity(new Intent(
                        MainActivity.this,
                        ProductActivity.class).putExtra(DATA_PRODUCT, product)
                );
            }

            @Override
            public void onDelete(Product product) {
                viewModel.deleteProduct(product);
            }
        });

        binding.tvNewProduct.setOnClickListener(view ->
                startActivity(new Intent(this, ProductActivity.class))
        );
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.filter(charSequence.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.setViewModel(viewModel);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSIONS && grantResults.length != permissions.length) {
            requestPermissions(permissions, REQUEST_PERMISSIONS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
    }
}