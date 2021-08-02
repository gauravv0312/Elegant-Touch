package com.example.elegant_touch.Account;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {
FragmentRegisterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),LoginActivity.class));
            }
        });

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.fullname.getText().toString().trim();
                String Email= binding.email.getText().toString().trim();
                String Phone = binding.number.getText().toString().trim();
                String Password = binding.password.getText().toString().trim();
                if (TextUtils.isEmpty(name))
                {
                    binding.fullname.setError("Name is required");
                }
                if (TextUtils.isEmpty(Email))
                {
                    binding.email.setError("Name is required");
                }
                if (TextUtils.isEmpty(Phone))
                {
                    binding.number.setError("Name is required");
                }
//                if (TextUtils.isEmpty(Password))
//                {
//                    binding.password.setError("Name is required");
//                }

                userregister(Email,Password,Phone);
            }
        });
        return binding.getRoot();

    }

    public void userregister(String email, String password, String phone) {

    }
}