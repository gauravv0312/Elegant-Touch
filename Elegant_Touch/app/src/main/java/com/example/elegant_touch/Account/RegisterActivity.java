package com.example.elegant_touch.Account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.LoaderActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth fAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fAuth = FirebaseAuth.getInstance();
        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        }

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                String email =binding.signEmail.getText().toString().trim();
                String password = binding.signPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    binding.signEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    binding.signPassword.setError("Password must be greater than 6 character");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoaderActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}















//----------------------------------------------------------> This code will use when we use retrofit api <-------------------------------------------------

//        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = binding.fullname.getText().toString().trim();
//                String Email= binding.email.getText().toString().trim();
//                String Phone = binding.number.getText().toString().trim();
//                String Password = binding.password.getText().toString().trim();
//                String address = binding.address.getText().toString().trim();
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
//                    userregister(name,Email,Password,Phone,address);
//                }
//
//            }
//        });
//        return binding.getRoot();
//
//    }
//
//    public void userregister(String name,String email, String password, String mobile,String address) {
//        Call<signup_response_mode> call=apicontroller.getInstance()
//                                        .getapi()
//                                        .getregister(name,email,mobile,password,address);
//
//        call.enqueue(new Callback<signup_response_mode>() {
//            @Override
//            public void onResponse(Call<signup_response_mode> call, Response<signup_response_mode> response) {
//                signup_response_mode obj= response.body();
//                String result = obj.getMessage().trim();
//                if (result.equals("inserted"))
//                {
//                    startActivity(new Intent(getContext(), LoaderActivity.class));
//                    getActivity().finish();
//                }
//                if (result.equals("exist"))
//                {
//                    binding.fullname.setText("");
//                    binding.email.setText("");
//                    binding.number.setText("");
//                    binding.password.setText("");
//                    binding.address.setText("");
//                    Toast.makeText(getContext(),"Email is already registered", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<signup_response_mode> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}