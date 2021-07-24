package com.example.elegant_touch.Onboarding_Screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elegant_touch.Account.WelcomeActivity;

import com.example.elegant_touch.databinding.FragmentOnboarding3Binding;


public class Onboarding3_Fragment extends Fragment {
    FragmentOnboarding3Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding = FragmentOnboarding3Binding.inflate(inflater,container,false);
    binding.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getContext(), WelcomeActivity.class));
        }
    });
        return binding.getRoot();
    }

    public static class OnboardingScreenAdapter extends FragmentPagerAdapter {
        public OnboardingScreenAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
            {
                return new Onboarding1_Fragment();
            }
            else if (position == 1)
            {
                return new Onboarding2_Fragment();
            }
            else {
                return new Onboarding3_Fragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}