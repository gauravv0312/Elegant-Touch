package com.example.elegant_touch.Account;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.elegant_touch.LoaderActivity;
import com.example.elegant_touch.databinding.FragmentRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                String address = binding.address.getText().toString().trim();
//                if (TextUtils.isEmpty(name))
//                {
//                    binding.fullname.setError("Name is required");
////                    return;
//                }
//                else if (TextUtils.isEmpty(Email))
//                {
//                    binding.email.setError("Name is required");
////                    return;
//                }
//                else if (TextUtils.isEmpty(Phone))
//                {
//                    binding.number.setError("Name is required");
////                    return;
//                }
//                else {
                    userregister(name,Email,Password,Phone,address);
//                }

            }
        });
        return binding.getRoot();

    }

    public void userregister(String name,String email, String password, String mobile,String address) {
        Call<signup_response_mode> call=apicontroller.getInstance()
                                        .getapi()
                                        .getregister(name,email,mobile,password,address);

        call.enqueue(new Callback<signup_response_mode>() {
            @Override
            public void onResponse(Call<signup_response_mode> call, Response<signup_response_mode> response) {
                signup_response_mode obj= response.body();
                String result = obj.getMessage().trim();
                if (result.equals("inserted"))
                {
                    startActivity(new Intent(getContext(), LoaderActivity.class));
                }
                if (result.equals("exist"))
                {
                    Toast.makeText(getContext(),"Email is already registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<signup_response_mode> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}