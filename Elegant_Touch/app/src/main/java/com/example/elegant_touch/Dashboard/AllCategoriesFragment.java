package com.example.elegant_touch.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentAllCategoriesBinding;

public class AllCategoriesFragment extends Fragment {
    FragmentAllCategoriesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentAllCategoriesBinding.inflate(inflater,container,false);
       binding.backbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              startActivity(new Intent(getContext(),DashboardActivity.class));
              getActivity().finish();
           }
       });

       return binding.getRoot();
    }
}