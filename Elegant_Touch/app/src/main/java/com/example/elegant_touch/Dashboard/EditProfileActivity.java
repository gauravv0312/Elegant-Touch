package com.example.elegant_touch.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {
    ActivityEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}