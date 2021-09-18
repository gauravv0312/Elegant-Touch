package com.example.elegant_touch.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elegant_touch.Adapter.hairoilAdapter;
import com.example.elegant_touch.Dashboard.DashboardActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityHairOilBinding;
import com.example.elegant_touch.modelclass.hairoilModelClass;

import java.util.ArrayList;

public class HairOilActivity extends AppCompatActivity {
    ActivityHairOilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHairOilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerview.setAdapter(new hairoilAdapter(hairoilModelClassArrayList(),getApplicationContext()));
    }
    public ArrayList<hairoilModelClass> hairoilModelClassArrayList(){
        ArrayList<hairoilModelClass> holder = new ArrayList<>();
        hairoilModelClass obj1 =new hairoilModelClass();
        obj1.setName("Cream");
        obj1.setPrice("Rs 500");
        obj1.setImage(R.drawable.download);
        holder.add(obj1);

        hairoilModelClass obj2 =new hairoilModelClass();
        obj2.setName("hairoil");
        obj2.setPrice("Rs 500");
        obj2.setImage(R.drawable.download);
        holder.add(obj2);

        hairoilModelClass obj3 =new hairoilModelClass();
        obj3.setName("FashWash");
        obj3.setPrice("Rs 500");
        obj3.setImage(R.drawable.download);
        holder.add(obj3);

        hairoilModelClass obj4 =new hairoilModelClass();
        obj4.setName("Lotion");
        obj4.setPrice("Rs 500");
        obj4.setImage(R.drawable.download);
        holder.add(obj4);

        hairoilModelClass obj5 =new hairoilModelClass();
        obj5.setName("Facial");
        obj5.setPrice("Rs 500");
        obj5.setImage(R.drawable.download);
        holder.add(obj5);

        hairoilModelClass obj6 =new hairoilModelClass();
        obj6.setName("Scrub");
        obj6.setPrice("Rs 500");
        obj6.setImage(R.drawable.download);
        holder.add(obj6);

        hairoilModelClass obj7 =new hairoilModelClass();
        obj7.setName("Scrub");
        obj7.setPrice("Rs 500");
        obj7.setImage(R.drawable.download);
        holder.add(obj7);

        hairoilModelClass obj8 =new hairoilModelClass();
        obj8.setName("Scrub");
        obj8.setPrice("Rs 500");
        obj8.setImage(R.drawable.download);
        holder.add(obj8);

        hairoilModelClass obj9 =new hairoilModelClass();
        obj9.setName("Scrub");
        obj9.setPrice("Rs 500");
        obj9.setImage(R.drawable.download);
        holder.add(obj9);

        hairoilModelClass obj10 =new hairoilModelClass();
        obj10.setName("Scrub");
        obj10.setPrice("Rs 500");
        obj10.setImage(R.drawable.download);
        holder.add(obj10);

        hairoilModelClass obj11 =new hairoilModelClass();
        obj11.setName("Scrub");
        obj11.setPrice("Rs 500");
        obj11.setImage(R.drawable.download);
        holder.add(obj11);

        hairoilModelClass obj12 =new hairoilModelClass();
        obj12.setName("Scrub");
        obj12.setPrice("Rs 500");
        obj12.setImage(R.drawable.download);
        holder.add(obj12);

        hairoilModelClass obj13 =new hairoilModelClass();
        obj13.setName("Scrub");
        obj13.setPrice("Rs 500");
        obj13.setImage(R.drawable.download);
        holder.add(obj13);

        hairoilModelClass obj14 =new hairoilModelClass();
        obj14.setName("Scrub");
        obj14.setPrice("Rs 500");
        obj14.setImage(R.drawable.download);
        holder.add(obj6);

        hairoilModelClass obj15 =new hairoilModelClass();
        obj15.setName("Scrub");
        obj15.setPrice("Rs 500");
        obj15.setImage(R.drawable.download);
        holder.add(obj15);

        hairoilModelClass obj16 =new hairoilModelClass();
        obj16.setName("Scrub");
        obj16.setPrice("Rs 500");
        obj16.setImage(R.drawable.download);
        holder.add(obj16);

        hairoilModelClass obj17 =new hairoilModelClass();
        obj17.setName("Scrub");
        obj17.setPrice("Rs 500");
        obj17.setImage(R.drawable.download);
        holder.add(obj17);

        hairoilModelClass obj18 =new hairoilModelClass();
        obj18.setName("Scrub");
        obj18.setPrice("Rs 500");
        obj18.setImage(R.drawable.download);
        holder.add(obj18);

        hairoilModelClass obj19 =new hairoilModelClass();
        obj19.setName("Scrub");
        obj19.setPrice("Rs 500");
        obj19.setImage(R.drawable.download);
        holder.add(obj19);

        hairoilModelClass obj20 =new hairoilModelClass();
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
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        finish();
    }
}