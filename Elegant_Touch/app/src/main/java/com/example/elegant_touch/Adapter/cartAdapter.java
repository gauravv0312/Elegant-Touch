package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.cartModelClass;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartViewHolder> {
    ArrayList<cartModelClass> cartModelClasses;

    public cartAdapter(ArrayList<cartModelClass> cartModelClasses) {
        this.cartModelClasses = cartModelClasses;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemcart,parent,false);
        return new cartAdapter.cartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
      holder.image.setImageResource(cartModelClasses.get(position).getImage());
      holder.cartProductName.setText(cartModelClasses.get(position).getName());
      holder.cartProductPrice.setText(cartModelClasses.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return cartModelClasses.size();
    }

    class cartViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView cartProductName,cartProductPrice;
        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cart_product);
            cartProductName = itemView.findViewById(R.id.cart_product_name);
            cartProductPrice = itemView.findViewById(R.id.cart_product_price);
        }
    }
}
