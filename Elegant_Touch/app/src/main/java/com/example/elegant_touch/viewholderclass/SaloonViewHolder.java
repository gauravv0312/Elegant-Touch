package com.example.elegant_touch.viewholderclass;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;

public class SaloonViewHolder extends RecyclerView.ViewHolder
{   ImageView productimage;
    TextView productname, productprice;
    public SaloonViewHolder(@NonNull View itemView) {
        super(itemView);
        productimage = itemView.findViewById(R.id.saloon_product);
        productname = itemView.findViewById(R.id.saloon_product_name);
        productname = itemView.findViewById(R.id.saloon_product_price);
    }
}
