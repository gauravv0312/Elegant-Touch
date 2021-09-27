package com.example.elegant_touch.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.ActivityPreviewBinding;
import com.example.elegant_touch.product.BoyActivity;

import org.w3c.dom.Text;

public class PreviewActivity extends AppCompatActivity {
    ActivityPreviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageView4.setImageResource(getIntent().getIntExtra("imagename",0));
        binding.textView11.setText(getIntent().getStringExtra("productname"));
        binding.textView12.setText(getIntent().getStringExtra("productprice"));
        binding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), CartActivity.class);
                intent.putExtra("imagename",R.id.imageView4);
                intent.putExtra("productname",R.id.textView11);
                intent.putExtra("productprice",R.id.textView12);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });

    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }
}