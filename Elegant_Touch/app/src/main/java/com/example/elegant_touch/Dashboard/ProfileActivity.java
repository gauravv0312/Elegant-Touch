package com.example.elegant_touch.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}