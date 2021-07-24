package com.example.elegant_touch.Onboarding_Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.elegant_touch.databinding.ActivityOnboardingScreenBinding;

public class OnboardingScreenActivity extends AppCompatActivity {
    ActivityOnboardingScreenBinding binding;
    Onboarding3_Fragment.OnboardingScreenAdapter onboardingScreenAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingScreenBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        onboardingScreenAdapter = new Onboarding3_Fragment.OnboardingScreenAdapter(getSupportFragmentManager(),getLifecycle());
        binding.viewpager.setAdapter(onboardingScreenAdapter);
    }


}