package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.parlourAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityParlourBinding;
import com.example.elegant_touch.modelclass.SaloonModelClass;
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class ParlourActivity extends AppCompatActivity {
   ActivityParlourBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParlourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new parlourAdapter(parlourModelClassArrayList()));
    }

    public ArrayList<parlourModelClass> parlourModelClassArrayList(){
        ArrayList<parlourModelClass> holder =new ArrayList<>();
        parlourModelClass obj1= new parlourModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        parlourModelClass obj2= new parlourModelClass();
        obj2.setName("Shampoo");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        parlourModelClass obj3= new parlourModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        parlourModelClass obj4= new parlourModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        parlourModelClass obj5= new parlourModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        parlourModelClass obj6= new parlourModelClass();
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