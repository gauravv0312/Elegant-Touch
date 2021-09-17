package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class ParlourActivity extends AppCompatActivity {
   ActivityParlourBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParlourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//      binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        binding.recyclerview.setLayoutManager(gridLayoutManager);
        binding.recyclerview.setAdapter(new parlourAdapter(parlourModelClassArrayList(),getApplicationContext()));
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

        parlourModelClass obj7 =new parlourModelClass();
        obj7.setName("Scrub");
        obj7.setPrice("Rs 500");
        obj7.setImage(R.drawable.download);
        holder.add(obj7);

        parlourModelClass obj8 =new parlourModelClass();
        obj8.setName("Scrub");
        obj8.setPrice("Rs 500");
        obj8.setImage(R.drawable.download);
        holder.add(obj8);

        parlourModelClass obj9 =new parlourModelClass();
        obj9.setName("Scrub");
        obj9.setPrice("Rs 500");
        obj9.setImage(R.drawable.download);
        holder.add(obj9);

        parlourModelClass obj10 =new parlourModelClass();
        obj10.setName("Scrub");
        obj10.setPrice("Rs 500");
        obj10.setImage(R.drawable.download);
        holder.add(obj10);

        parlourModelClass obj11 =new parlourModelClass();
        obj11.setName("Scrub");
        obj11.setPrice("Rs 500");
        obj11.setImage(R.drawable.download);
        holder.add(obj11);

        parlourModelClass obj12 =new parlourModelClass();
        obj12.setName("Scrub");
        obj12.setPrice("Rs 500");
        obj12.setImage(R.drawable.download);
        holder.add(obj12);

        parlourModelClass obj13 =new parlourModelClass();
        obj13.setName("Scrub");
        obj13.setPrice("Rs 500");
        obj13.setImage(R.drawable.download);
        holder.add(obj13);

        parlourModelClass obj14 =new parlourModelClass();
        obj14.setName("Scrub");
        obj14.setPrice("Rs 500");
        obj14.setImage(R.drawable.download);
        holder.add(obj6);

        parlourModelClass obj15 =new parlourModelClass();
        obj15.setName("Scrub");
        obj15.setPrice("Rs 500");
        obj15.setImage(R.drawable.download);
        holder.add(obj15);

        parlourModelClass obj16 =new parlourModelClass();
        obj16.setName("Scrub");
        obj16.setPrice("Rs 500");
        obj16.setImage(R.drawable.download);
        holder.add(obj16);

        parlourModelClass obj17 =new parlourModelClass();
        obj17.setName("Scrub");
        obj17.setPrice("Rs 500");
        obj17.setImage(R.drawable.download);
        holder.add(obj17);

        parlourModelClass obj18 =new parlourModelClass();
        obj18.setName("Scrub");
        obj18.setPrice("Rs 500");
        obj18.setImage(R.drawable.download);
        holder.add(obj18);

        parlourModelClass obj19 =new parlourModelClass();
        obj19.setName("Scrub");
        obj19.setPrice("Rs 500");
        obj19.setImage(R.drawable.download);
        holder.add(obj19);

        parlourModelClass obj20 =new parlourModelClass();
        obj20.setName("Scrub");
        obj20.setPrice("Rs 500");
        obj20.setImage(R.drawable.download);
        holder.add(obj20);
        return holder;
    }
    public void backButton(View view){
        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
        finish();

    }
}