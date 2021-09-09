package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivitySaloonBinding;

public class SaloonActivity extends AppCompatActivity {
    ActivitySaloonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaloonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}