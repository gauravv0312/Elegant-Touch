package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.menAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityMenBinding;
import com.example.elegant_touch.modelclass.SaloonModelClass;
import com.example.elegant_touch.modelclass.menModelClass;

import java.util.ArrayList;

public class MenActivity extends AppCompatActivity {
    ActivityMenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        binding.recyclerview.setLayoutManager(gridLayoutManager);
        binding.recyclerview.setAdapter(new menAdapter(menModelClassArrayList(),getApplicationContext()));
    }
    public ArrayList<menModelClass> menModelClassArrayList(){
        ArrayList<menModelClass> holder =new ArrayList<>();
        menModelClass obj1 =new menModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        menModelClass obj2 =new menModelClass();
        obj2.setName("Shampoo");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        menModelClass obj3 =new menModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        menModelClass obj4 =new menModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        menModelClass obj5 =new menModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        menModelClass obj6 =new menModelClass();
        obj6.setName("Scrub");
        obj6.setPrice("Rs 500");
        obj6.setImage(R.drawable.download);
        holder.add(obj6);

        menModelClass obj7 =new menModelClass();
        obj7.setName("Scrub");
        obj7.setPrice("Rs 500");
        obj7.setImage(R.drawable.download);
        holder.add(obj7);

        menModelClass obj8 =new menModelClass();
        obj8.setName("Scrub");
        obj8.setPrice("Rs 500");
        obj8.setImage(R.drawable.download);
        holder.add(obj8);

        menModelClass obj9 =new menModelClass();
        obj9.setName("Scrub");
        obj9.setPrice("Rs 500");
        obj9.setImage(R.drawable.download);
        holder.add(obj9);

        menModelClass obj10 =new menModelClass();
        obj10.setName("Scrub");
        obj10.setPrice("Rs 500");
        obj10.setImage(R.drawable.download);
        holder.add(obj10);

        menModelClass obj11 =new menModelClass();
        obj11.setName("Scrub");
        obj11.setPrice("Rs 500");
        obj11.setImage(R.drawable.download);
        holder.add(obj11);

        menModelClass obj12 =new menModelClass();
        obj12.setName("Scrub");
        obj12.setPrice("Rs 500");
        obj12.setImage(R.drawable.download);
        holder.add(obj12);

        menModelClass obj13 =new menModelClass();
        obj13.setName("Scrub");
        obj13.setPrice("Rs 500");
        obj13.setImage(R.drawable.download);
        holder.add(obj13);

        menModelClass obj14 =new menModelClass();
        obj14.setName("Scrub");
        obj14.setPrice("Rs 500");
        obj14.setImage(R.drawable.download);
        holder.add(obj6);

        menModelClass obj15 =new menModelClass();
        obj15.setName("Scrub");
        obj15.setPrice("Rs 500");
        obj15.setImage(R.drawable.download);
        holder.add(obj15);

        menModelClass obj16 =new menModelClass();
        obj16.setName("Scrub");
        obj16.setPrice("Rs 500");
        obj16.setImage(R.drawable.download);
        holder.add(obj16);

        menModelClass obj17 =new menModelClass();
        obj17.setName("Scrub");
        obj17.setPrice("Rs 500");
        obj17.setImage(R.drawable.download);
        holder.add(obj17);

        menModelClass obj18 =new menModelClass();
        obj18.setName("Scrub");
        obj18.setPrice("Rs 500");
        obj18.setImage(R.drawable.download);
        holder.add(obj18);

        menModelClass obj19 =new menModelClass();
        obj19.setName("Scrub");
        obj19.setPrice("Rs 500");
        obj19.setImage(R.drawable.download);
        holder.add(obj19);

        menModelClass obj20 =new menModelClass();
        obj20.setName("Scrub");
        obj20.setPrice("Rs 500");
        obj20.setImage(R.drawable.download);
        holder.add(obj20);
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