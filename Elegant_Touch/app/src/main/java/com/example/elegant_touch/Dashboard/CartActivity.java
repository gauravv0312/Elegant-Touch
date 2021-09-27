package com.example.elegant_touch.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.boyAdapter;
import com.example.elegant_touch.Adapter.cartAdapter;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityCartBinding;
import com.example.elegant_touch.modelclass.cartModelClass;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new cartAdapter(cartModelClassArrayList()));
    }
    public ArrayList<cartModelClass> cartModelClassArrayList(){
        ArrayList<cartModelClass> holder = new ArrayList<>();
        cartModelClass obj1 =new cartModelClass();
        obj1.setImage(getIntent().getIntExtra("imagename",0));
        obj1.setName(getIntent().getStringExtra("cartproductname"));
        obj1.setPrice(getIntent().getStringExtra("cartproductprice"));
        holder.add(obj1);
        return holder;
    }
    public void backButton(View view){
        super.onBackPressed();

    }
}