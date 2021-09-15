package com.example.elegant_touch.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityPreviewBinding;
import com.example.elegant_touch.product.BoyActivity;

public class PreviewActivity extends AppCompatActivity {
    ActivityPreviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageView4.setImageResource(getIntent().getIntExtra("imagename",0));
        binding.textView11.setText(getIntent().getStringExtra("productname"));
        binding.textView12.setText(getIntent().getStringExtra("productprice"));
    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }
}