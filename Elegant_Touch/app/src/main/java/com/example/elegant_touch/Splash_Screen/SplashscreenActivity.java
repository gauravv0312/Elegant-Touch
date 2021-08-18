package com.example.elegant_touch.Splash_Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.elegant_touch.Account.WelcomeActivity;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.Onboarding_Screen.OnboardingScreenActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivitySplashscreenBinding;

public class SplashscreenActivity extends AppCompatActivity {
    ActivitySplashscreenBinding binding;
    Animation top_anim, bottom_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        top_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top);
        bottom_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom);
        binding.logo.setAnimation(top_anim);
        binding.desc.setAnimation(bottom_anim);
        binding.fullname.setAnimation(bottom_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("onboardingscreen", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("onboardingscreen", true);
                if (isFirstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("onboardingscreen", false);
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), OnboardingScreenActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                    finish();
                }

            }
        }, 4000);
        setContentView(binding.getRoot());
    }

}