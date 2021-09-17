package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.boyAdapter;
import com.example.elegant_touch.Adapter.girlAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityGirlBinding;
import com.example.elegant_touch.modelclass.girlModelClass;
import com.example.elegant_touch.modelclass.girlModelClass;

import java.util.ArrayList;

public class GirlActivity extends AppCompatActivity {
        ActivityGirlBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGirlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerview.setAdapter(new girlAdapter(girlModelClassArrayList(),getApplicationContext()));
    }
    public ArrayList<girlModelClass> girlModelClassArrayList(){
        ArrayList<girlModelClass> holder = new ArrayList<>();
        girlModelClass obj1 =new girlModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        girlModelClass obj2 =new girlModelClass();
        obj2.setName("Shampoo");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        girlModelClass obj3 =new girlModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        girlModelClass obj4 =new girlModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        girlModelClass obj5 =new girlModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        girlModelClass obj6 =new girlModelClass();
        obj6.setName("Scrub");
        obj6.setPrice("Rs 500");
        obj6.setImage(R.drawable.download);
        holder.add(obj6);

        girlModelClass obj7 =new girlModelClass();
        obj7.setName("Scrub");
        obj7.setPrice("Rs 500");
        obj7.setImage(R.drawable.download);
        holder.add(obj7);

        girlModelClass obj8 =new girlModelClass();
        obj8.setName("Scrub");
        obj8.setPrice("Rs 500");
        obj8.setImage(R.drawable.download);
        holder.add(obj8);

        girlModelClass obj9 =new girlModelClass();
        obj9.setName("Scrub");
        obj9.setPrice("Rs 500");
        obj9.setImage(R.drawable.download);
        holder.add(obj9);

        girlModelClass obj10 =new girlModelClass();
        obj10.setName("Scrub");
        obj10.setPrice("Rs 500");
        obj10.setImage(R.drawable.download);
        holder.add(obj10);

        girlModelClass obj11 =new girlModelClass();
        obj11.setName("Scrub");
        obj11.setPrice("Rs 500");
        obj11.setImage(R.drawable.download);
        holder.add(obj11);

        girlModelClass obj12 =new girlModelClass();
        obj12.setName("Scrub");
        obj12.setPrice("Rs 500");
        obj12.setImage(R.drawable.download);
        holder.add(obj12);

        girlModelClass obj13 =new girlModelClass();
        obj13.setName("Scrub");
        obj13.setPrice("Rs 500");
        obj13.setImage(R.drawable.download);
        holder.add(obj13);

        girlModelClass obj14 =new girlModelClass();
        obj14.setName("Scrub");
        obj14.setPrice("Rs 500");
        obj14.setImage(R.drawable.download);
        holder.add(obj6);

        girlModelClass obj15 =new girlModelClass();
        obj15.setName("Scrub");
        obj15.setPrice("Rs 500");
        obj15.setImage(R.drawable.download);
        holder.add(obj15);

        girlModelClass obj16 =new girlModelClass();
        obj16.setName("Scrub");
        obj16.setPrice("Rs 500");
        obj16.setImage(R.drawable.download);
        holder.add(obj16);

        girlModelClass obj17 =new girlModelClass();
        obj17.setName("Scrub");
        obj17.setPrice("Rs 500");
        obj17.setImage(R.drawable.download);
        holder.add(obj17);

        girlModelClass obj18 =new girlModelClass();
        obj18.setName("Scrub");
        obj18.setPrice("Rs 500");
        obj18.setImage(R.drawable.download);
        holder.add(obj18);

        girlModelClass obj19 =new girlModelClass();
        obj19.setName("Scrub");
        obj19.setPrice("Rs 500");
        obj19.setImage(R.drawable.download);
        holder.add(obj19);

        girlModelClass obj20 =new girlModelClass();
        obj20.setName("Scrub");
        obj20.setPrice("Rs 500");
        obj20.setImage(R.drawable.download);
        holder.add(obj20);
        return holder;
    }
    public void backButton(View view){
        super.onBackPressed();;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
        finish();
    }
}