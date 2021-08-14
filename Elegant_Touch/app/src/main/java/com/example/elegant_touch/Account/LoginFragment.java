package com.example.elegant_touch.Account;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.elegant_touch.LoaderActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        binding.newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),RegisterActivity.class));
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= binding.loginEmail.getText().toString().trim();
                String Password= binding.loginPassword.getText().toString().trim();
                processlogin(Email,Password);
            }
        });
        return binding.getRoot();
    }

    public void processlogin(String email, String password) {
        Call<login_response_model> call =apicontroller.getInstance()
                                          .getapi()
                                          .getlogin(email,password);

        call.enqueue(new Callback<login_response_model>() {
            @Override
            public void onResponse(Call<login_response_model> call, Response<login_response_model> response) {
                login_response_model obj= response.body();
                String result = obj.getMessage().trim();
                if (result.equals("exist"))
                {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credentials",MODE_PRIVATE);
                }
                if (result.equals("not exist"))
                {
                    Toast.makeText(getContext(),"Check your password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<login_response_model> call, Throwable t) {

            }
        });
    }
}