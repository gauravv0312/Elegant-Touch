package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.menModelClass;
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class menAdapter extends RecyclerView.Adapter<menAdapter.menViewHolder> {
    ArrayList<menModelClass> menModelClasses;

    public menAdapter(ArrayList<menModelClass> menModelClasses) {
        this.menModelClasses = menModelClasses;
    }

    @NonNull
    @Override
    public menViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menproduct,parent,false);
        return new menAdapter.menViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menViewHolder holder, int position) {
        holder.image.setImageResource(menModelClasses.get(position).getImage());
        holder.productname.setText(menModelClasses.get(position).getName());
        holder.productprice.setText(menModelClasses.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return menModelClasses.size();
    }

    class menViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public menViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.men_product);
            productname = itemView.findViewById(R.id.men_product_name);
            productprice = itemView.findViewById(R.id.men_product_price);
        }
    }
}
