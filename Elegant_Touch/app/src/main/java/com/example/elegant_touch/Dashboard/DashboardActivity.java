package com.example.elegant_touch.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
     ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HomeFragment()).commit();
        binding.bottomnavigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment temp= null;
                switch (item.getItemId())
                {
//                    case R.id.home: temp= new HomeFragment();
//                        break;
//
//                    case R.id.category: temp= new CategoryFragment();
//                        break;
//
//                    case R.id.order: temp= new OrderFragment();
//                        break;
//
//                    case R.id.profile: temp= new ProfileFragment();
//                        break;

                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,temp).commit();
                return ;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}