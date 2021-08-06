package com.example.elegant_touch.Dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentCategoryBinding;


public class CategoryFragment extends Fragment {
    FragmentCategoryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}