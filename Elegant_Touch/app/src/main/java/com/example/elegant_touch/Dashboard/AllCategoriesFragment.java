package com.example.elegant_touch.Dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentAllCategoriesBinding;

public class AllCategoriesFragment extends Fragment {
    FragmentAllCategoriesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentAllCategoriesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}