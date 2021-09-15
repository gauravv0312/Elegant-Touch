package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.girlModelClass;

import java.util.ArrayList;

public class girlAdapter extends RecyclerView.Adapter<girlAdapter.girlViewHolder> {

    ArrayList<girlModelClass> girlModelClasses;

    public girlAdapter(ArrayList<girlModelClass> girlModelClasses) {
        this.girlModelClasses = girlModelClasses;
    }

    @NonNull
    @Override
    public girlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.girlproduct,parent,false);
        return new girlAdapter.girlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull girlViewHolder holder, int position) {
        holder.image.setImageResource(girlModelClasses.get(position).getImage());
        holder.productname.setText(girlModelClasses.get(position).getName());
        holder.productprice.setText(girlModelClasses.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return girlModelClasses.size();
    }

    class girlViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public girlViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.girl_product);
            productname = itemView.findViewById(R.id.girl_product_name);
            productprice = itemView.findViewById(R.id.girl_product_price);
        }
    }
}
