package com.example.elegant_touch.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.elegant_touch.Account.LoginActivity;
import com.example.elegant_touch.Account.WelcomeActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityDashboardBinding;
import com.example.elegant_touch.product.BoyActivity;
import com.example.elegant_touch.product.MenActivity;
import com.example.elegant_touch.product.ParlourActivity;
import com.example.elegant_touch.product.SaloonActivity;
import com.example.elegant_touch.product.WomenActivity;
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
        binding.saloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SaloonActivity.class));
                finish();
            }
        });

       binding.parlour.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), ParlourActivity.class));
               finish();
           }
       });

        binding.man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenActivity.class));
                finish();
            }
        });

        binding.women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WomenActivity.class));
                finish();
            }
        });

        binding.boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BoyActivity.class));
            }
        });


//        drawer
        navigationDrawer();
//      hide login id
        hideItem();
    }

    private void navigationDrawer() {
        binding.navigationView.bringToFront();  // for interaction
        binding.navigationView.setNavigationItemSelectedListener(this);
        binding.navigationView.setCheckedItem(R.id.home);
        binding.drawerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
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
        switch (item.getItemId())
        {
            case R.id.menu_logout:
                logout_account();
                break;
            case R.id.menu_category:
                startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                finish();
                break;
            case R.id.menu_profile:
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                finish();
                break;
            case R.id.menu_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
                break;
            default:
        }

        return true;
    }

    public void logout_account() {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials",MODE_PRIVATE);
        if (sharedPreferences.contains("username"))
        {
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.remove("username");
            editor.putString("msg","Logout Successfully");
            editor.commit();
            startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
            finish();
        }
    }

    private void hideItem() {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        if (sharedPreferences.contains("username")) {
            Menu nav_Menu = binding.navigationView.getMenu();
            nav_Menu.findItem(R.id.menu_login).setVisible(false);
        }
    }

}