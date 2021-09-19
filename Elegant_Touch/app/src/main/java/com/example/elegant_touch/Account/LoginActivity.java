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
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityLoginBinding;
import com.example.elegant_touch.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
   ActivityLoginBinding binding;
   FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        fAuth =FirebaseAuth.getInstance();
        setContentView(binding.getRoot());

        binding.newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =binding.loginEmail.getText().toString().trim();
                String password = binding.loginPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    binding.loginEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    binding.loginPassword.setError("Password must be greater than 6 character");
                    return;
                }
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){
                          Toast.makeText(getApplicationContext(), "Logged is successfully", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(), LoaderActivity.class));
                      }
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
    }
}


//----------------------------------------------------------> This code will use when we use retrofit api <-------------------------------------------------

//        verifyuserexistance();
//        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Email= binding.loginEmail.getText().toString().trim();
//                String Password= binding.loginPassword.getText().toString().trim();
//                processlogin(Email,Password);
//            }
//        });
//        return binding.getRoot();
//    }
//
//    public void processlogin(String email, String password) {
//        Call<login_response_model> call =apicontroller.getInstance()
//                                          .getapi()
//                                          .getlogin(email,password);
//
//        call.enqueue(new Callback<login_response_model>() {
//            @Override
//            public void onResponse(Call<login_response_model> call, Response<login_response_model> response) {
//                login_response_model obj= response.body();
//                String result = obj.getMessage().trim();
//                if (result.equals("exist"))
//                {
//                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credentials",MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("username",email);
//                    editor.putString("password",password);
//                    editor.commit();
//                    editor.apply();
//                    startActivity(new Intent(getContext(), LoaderActivity.class));
//                    getActivity().finish();
//                }
//                if (result.equals("not exist"))
//                {
//                    binding.loginEmail.setText("");
//                    binding.loginPassword.setText("");
//                    Toast.makeText(getContext(),"Check your password", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<login_response_model> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void verifyuserexistance()
//    {
//        SharedPreferences sharedPreferences =getContext().getSharedPreferences("credentials",MODE_PRIVATE);
//        if (sharedPreferences.contains("username"))
//        {
//            startActivity(new Intent(getContext(),DashboardActivity.class));
//            getActivity().finish();
//        }
//    }

