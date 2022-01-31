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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String CustomerId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        setContentView(binding.getRoot());

        if (fAuth.getCurrentUser() !=null)
        {
            startActivity(new Intent(getApplicationContext(),LoaderActivity.class));
            finish();
        }
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
               // else {
                   // userregister(name,Email,Password,Phone,address);
               // }
                fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "User Successfully inserted", Toast.LENGTH_SHORT).show();
                            CustomerId=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("Customer").document(CustomerId);
                            Map<String,Object> customer = new HashMap<>();
                            customer.put("Name",name);
                            customer.put("Email",Email);
                            customer.put("Number",Phone);
                            customer.put("Address",address);

                            documentReference.set(customer).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Customer Profile Has Been Created", Toast.LENGTH_SHORT).show();
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),LoaderActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }

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
//                    startActivity(new Intent(getApplicationContext(), LoaderActivity.class));
//                  finish();
//                }
//                if (result.equals("exist"))
//                {
//                    binding.signFullname.setText("");
//                    binding.signEmail.setText("");
//                    binding.signNumber.setText("");
//                    binding.signPassword.setText("");
//                    binding.signAddress.setText("");
//                    Toast.makeText(getApplicationContext(),"Email is already registered", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<signup_response_mode> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
        finish();
    }
}