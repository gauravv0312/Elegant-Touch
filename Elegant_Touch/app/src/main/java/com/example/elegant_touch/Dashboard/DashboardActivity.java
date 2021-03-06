package com.example.elegant_touch.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.elegant_touch.Account.LoginActivity;
import com.example.elegant_touch.Account.WelcomeActivity;
import com.example.elegant_touch.Adapter.offerAdapter;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityDashboardBinding;
import com.example.elegant_touch.modelclass.offerModelClass;
import com.example.elegant_touch.product.BoyActivity;
import com.example.elegant_touch.product.GirlActivity;
import com.example.elegant_touch.product.HairOilActivity;
import com.example.elegant_touch.product.MakeupActivity;
import com.example.elegant_touch.product.MenActivity;
import com.example.elegant_touch.product.ParlourActivity;
import com.example.elegant_touch.product.PerfumeActivity;
import com.example.elegant_touch.product.SaloonActivity;
import com.example.elegant_touch.product.ShampooActivity;
import com.example.elegant_touch.product.SoapActivity;
import com.example.elegant_touch.product.WomenActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , PaymentResultListener {
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
        Checkout.preload(getApplicationContext());

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
                finish();
            }
        });

        binding.girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GirlActivity.class));
                finish();
            }
        });


//        drawer
        navigationDrawer();

//      hide login id
//        hideItem();

// ------------------------------------------------------------> offer <--------------------------------------------------------------------

        binding.offerRecyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        binding.offerRecyclerview.setAdapter(new offerAdapter(offerModelClassArrayList()));
    }
    public ArrayList<offerModelClass> offerModelClassArrayList(){
        ArrayList<offerModelClass> holder = new ArrayList<>();
        offerModelClass obj1 = new offerModelClass();
        obj1.setImage(R.drawable.offer1);
        obj1.setOfferDetails("Limited Time Sale 30% off");
        holder.add(obj1);

        offerModelClass obj2 =new offerModelClass();
        obj2.setOfferDetails("Limited Time Sale 50% off");
        obj2.setImage(R.drawable.offer2);
        holder.add(obj2);

        offerModelClass obj3 =new offerModelClass();
        obj3.setOfferDetails("Limited Time Sale 60% off");
        obj3.setImage(R.drawable.offer3);
        holder.add(obj3);

        offerModelClass obj4 =new offerModelClass();
        obj4.setOfferDetails("Limited Time Sale 30% off");
        obj4.setImage(R.drawable.offer1);
        holder.add(obj4);

        offerModelClass obj5 =new offerModelClass();
        obj5.setOfferDetails("Limited Time Sale 50% off");
        obj5.setImage(R.drawable.offer2);
        holder.add(obj5);

        offerModelClass obj6 =new offerModelClass();
        obj6.setOfferDetails("Limited Time Sale 60% off");
        obj6.setImage(R.drawable.offer3);
        holder.add(obj6);
        return holder;
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
//                --------------------------------><------------------------------------------------
//            case R.id.menu_login:
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                finish();
//                break;
//                --------------------------------><------------------------------------------------

            case R.id.perfume:
                startActivity(new Intent(getApplicationContext(), PerfumeActivity.class));
                finish();
                break;
            case R.id.shampoo:
                startActivity(new Intent(getApplicationContext(), ShampooActivity.class));
                finish();
                break;
            case R.id.serum:
                startActivity(new Intent(getApplicationContext(), HairOilActivity.class));
                finish();
                break;
            case R.id.makeup:
                startActivity(new Intent(getApplicationContext(), MakeupActivity.class));
                finish();
                break;
            case R.id.soap:
                startActivity(new Intent(getApplicationContext(), SoapActivity.class));
                finish();
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
            case R.id.online:
                startPayment();
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
        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
    }

//    ----------------------------------------------------------------------> for hiding the login button in drawer <-----------------------------------------------------------------------
//    private void hideItem() {
//        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
//        if (sharedPreferences.contains("username")) {
//            Menu nav_Menu = binding.navigationView.getMenu();
//            nav_Menu.findItem(R.id.menu_login).setVisible(false);
//        }
//    }
//    ---------------------------------------------------------------------------><----------------------------------------------------------------------------------------------------
    public void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_OqfuQX5n4s3cF9");
        checkout.setImage(R.drawable.logo);
        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "Elegant Touch");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact","9996629014");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(), "Successfull Payment Id:"+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), "failed Payment Id:"+s, Toast.LENGTH_SHORT).show();

    }
}