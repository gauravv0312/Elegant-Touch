package com.example.elegant_touch.Account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.elegant_touch.LoaderActivity;
import com.example.elegant_touch.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.signFullname.getText().toString().trim();
                String Email= binding.signEmail.getText().toString().trim();
                String Phone = binding.signNumber.getText().toString().trim();
                String Password = binding.signPassword.getText().toString().trim();
                String address = binding.signAddress.getText().toString().trim();
                if (TextUtils.isEmpty(name))
                {
                    binding.signFullname.setError("Name is required");
                    return;
                }
                else if (TextUtils.isEmpty(Email))
                {
                    binding.signEmail.setError("Name is required");
                    return;
                }
                else if (TextUtils.isEmpty(Phone))
                {
                    binding.signPassword.setError("Name is required");
                    return;
                }
                else {
                    userregister(name,Email,Password,Phone,address);
                }

            }
        });


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
                    startActivity(new Intent(getApplicationContext(), LoaderActivity.class));
                  finish();
                }
                if (result.equals("exist"))
                {
                    binding.signFullname.setText("");
                    binding.signEmail.setText("");
                    binding.signNumber.setText("");
                    binding.signPassword.setText("");
                    binding.signAddress.setText("");
                    Toast.makeText(getApplicationContext(),"Email is already registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<signup_response_mode> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}