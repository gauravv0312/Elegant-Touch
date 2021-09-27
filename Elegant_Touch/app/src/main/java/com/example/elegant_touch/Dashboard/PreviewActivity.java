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
    ImageView previewImage;
    TextView previewText1,previewText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageView4.setImageResource(getIntent().getIntExtra("imagename",0));
        binding.textView11.setText(getIntent().getStringExtra("productname"));
        binding.textView12.setText(getIntent().getStringExtra("productprice"));
//        previewImage = findViewById(R.id.imageView4);
//        previewText1 = findViewById(R.id.textView11);
//        previewText2 = findViewById(R.id.textView12);
//        binding.addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(getApplicationContext(), CartActivity.class);
//                intent.putExtra("imagename",previewImage.setImageResource());
//                intent.putExtra("cartproductname",);
//                intent.putExtra("cartproductprice",);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getApplicationContext().startActivity(intent);
//            }
//        });

    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }
}