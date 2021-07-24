package com.example.elegant_touch.Onboarding_Screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentOnboarding1Binding;


public class Onboarding1_Fragment extends Fragment {
    FragmentOnboarding1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboarding1Binding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}