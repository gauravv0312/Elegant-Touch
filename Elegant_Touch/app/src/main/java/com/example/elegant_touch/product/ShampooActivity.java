package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.shampooAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityShampooBinding;
import com.example.elegant_touch.modelclass.shampooModelClass;

import java.util.ArrayList;

public class ShampooActivity extends AppCompatActivity {
    ActivityShampooBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShampooBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerview.setAdapter(new shampooAdapter(shampooModelClassArrayList(),getApplicationContext()));
    }
    public ArrayList<shampooModelClass> shampooModelClassArrayList(){
        ArrayList<shampooModelClass> holder = new ArrayList<>();
        shampooModelClass obj1 =new shampooModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        shampooModelClass obj2 =new shampooModelClass();
        obj2.setName("Shampoo");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        shampooModelClass obj3 =new shampooModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        shampooModelClass obj4 =new shampooModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        shampooModelClass obj5 =new shampooModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        shampooModelClass obj6 =new shampooModelClass();
        obj6.setName("Scrub");
        obj6.setPrice("Rs 500");
        obj6.setImage(R.drawable.download);
        holder.add(obj6);

        shampooModelClass obj7 =new shampooModelClass();
        obj7.setName("Scrub");
        obj7.setPrice("Rs 500");
        obj7.setImage(R.drawable.download);
        holder.add(obj7);

        shampooModelClass obj8 =new shampooModelClass();
        obj8.setName("Scrub");
        obj8.setPrice("Rs 500");
        obj8.setImage(R.drawable.download);
        holder.add(obj8);

        shampooModelClass obj9 =new shampooModelClass();
        obj9.setName("Scrub");
        obj9.setPrice("Rs 500");
        obj9.setImage(R.drawable.download);
        holder.add(obj9);

        shampooModelClass obj10 =new shampooModelClass();
        obj10.setName("Scrub");
        obj10.setPrice("Rs 500");
        obj10.setImage(R.drawable.download);
        holder.add(obj10);

        shampooModelClass obj11 =new shampooModelClass();
        obj11.setName("Scrub");
        obj11.setPrice("Rs 500");
        obj11.setImage(R.drawable.download);
        holder.add(obj11);

        shampooModelClass obj12 =new shampooModelClass();
        obj12.setName("Scrub");
        obj12.setPrice("Rs 500");
        obj12.setImage(R.drawable.download);
        holder.add(obj12);

        shampooModelClass obj13 =new shampooModelClass();
        obj13.setName("Scrub");
        obj13.setPrice("Rs 500");
        obj13.setImage(R.drawable.download);
        holder.add(obj13);

        shampooModelClass obj14 =new shampooModelClass();
        obj14.setName("Scrub");
        obj14.setPrice("Rs 500");
        obj14.setImage(R.drawable.download);
        holder.add(obj6);

        shampooModelClass obj15 =new shampooModelClass();
        obj15.setName("Scrub");
        obj15.setPrice("Rs 500");
        obj15.setImage(R.drawable.download);
        holder.add(obj15);

        shampooModelClass obj16 =new shampooModelClass();
        obj16.setName("Scrub");
        obj16.setPrice("Rs 500");
        obj16.setImage(R.drawable.download);
        holder.add(obj16);

        shampooModelClass obj17 =new shampooModelClass();
        obj17.setName("Scrub");
        obj17.setPrice("Rs 500");
        obj17.setImage(R.drawable.download);
        holder.add(obj17);

        shampooModelClass obj18 =new shampooModelClass();
        obj18.setName("Scrub");
        obj18.setPrice("Rs 500");
        obj18.setImage(R.drawable.download);
        holder.add(obj18);

        shampooModelClass obj19 =new shampooModelClass();
        obj19.setName("Scrub");
        obj19.setPrice("Rs 500");
        obj19.setImage(R.drawable.download);
        holder.add(obj19);

        shampooModelClass obj20 =new shampooModelClass();
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