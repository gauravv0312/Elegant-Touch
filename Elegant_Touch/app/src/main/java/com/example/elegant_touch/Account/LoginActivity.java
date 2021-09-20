package com.example.elegant_touch.Account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.LoaderActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });


//----------------------------------------------------------> This code will use when we use retrofit api <-------------------------------------------------

        verifyuserexistance();
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = binding.loginEmail.getText().toString().trim();
                String Password = binding.loginPassword.getText().toString().trim();
                processlogin(Email, Password);
            }
        });

    }

    public void processlogin(String email, String password) {
        Call<login_response_model> call = apicontroller.getInstance()
                .getapi()
                .getlogin(email, password);

        call.enqueue(new Callback<login_response_model>() {
            @Override
            public void onResponse(Call<login_response_model> call, Response<login_response_model> response) {
                login_response_model obj = response.body();
                String result = obj.getMessage().trim();
                if (result.equals("exist")) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("credentials", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", email);
                    editor.putString("password", password);
                    editor.commit();
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), LoaderActivity.class));
                    finish();
                }
                if (result.equals("not exist")) {
                    binding.loginEmail.setText("");
                    binding.loginPassword.setText("");
                    Toast.makeText(getApplicationContext(), "Check your password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<login_response_model> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void verifyuserexistance() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("credentials", MODE_PRIVATE);
        if (sharedPreferences.contains("username")) {
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            finish();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
        finish();
    }
}
