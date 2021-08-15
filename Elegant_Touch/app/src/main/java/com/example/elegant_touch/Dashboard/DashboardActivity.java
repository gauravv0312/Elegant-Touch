package com.example.elegant_touch.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.elegant_touch.Account.WelcomeActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
     ActivityDashboardBinding binding;
    List<SlideModel> slideModels = new ArrayList<SlideModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        slideModels.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.FIT));
        binding.imageSlider.setImageList(slideModels);
        setContentView(binding.getRoot());
        //        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HomeFragment()).commit();



//        drawer
        navigationDrawer();

    }

    private void navigationDrawer() {
        binding.navigationView.bringToFront();  // for interaction
        binding.navigationView.setNavigationItemSelectedListener(this);
        binding.navigationView.setCheckedItem(R.id.home);
        binding.drawerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerVisible(GravityCompat.START))
                {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerVisible(GravityCompat.START))
        {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
            finishAffinity();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}