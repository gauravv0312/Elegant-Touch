package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.elegant_touch.Adapter.saloonAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivitySaloonBinding;
import com.example.elegant_touch.modelclass.SaloonModelClass;

import java.util.ArrayList;

public class SaloonActivity extends AppCompatActivity {
    ActivitySaloonBinding binding;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaloonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new saloonAdapter(saloonModelClassArrayList()));
    }
    public ArrayList<SaloonModelClass> saloonModelClassArrayList(){
        ArrayList<SaloonModelClass> holder = new ArrayList<>();
        SaloonModelClass obj1 =new SaloonModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        SaloonModelClass obj2 =new SaloonModelClass();
        obj2.setName("Shampoo");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        SaloonModelClass obj3 =new SaloonModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        SaloonModelClass obj4 =new SaloonModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        SaloonModelClass obj5 =new SaloonModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        SaloonModelClass obj6 =new SaloonModelClass();
        obj6.setName("Scrub");
        obj6.setPrice("Rs 500");
        obj6.setImage(R.drawable.download);
        holder.add(obj6);
        return holder;
    }
    public void backButton(View view){
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}