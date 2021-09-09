package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.SaloonModelClass;

import java.util.ArrayList;

public class saloonAdapter extends RecyclerView.Adapter<saloonAdapter.saloonViewHolder> {
    ArrayList<SaloonModelClass> saloonModelClasses;

    public saloonAdapter(ArrayList<SaloonModelClass> saloonModelClasses) {
        this.saloonModelClasses = saloonModelClasses;
    }

    @NonNull
    @Override
    public saloonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.saloonproduct,parent,false);
        return new saloonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull saloonViewHolder holder, int position) {
         holder.image.setImageResource(saloonModelClasses.get(position).getImage());
         holder.productname.setText(saloonModelClasses.get(position).getName());
         holder.productprice.setText(saloonModelClasses.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return saloonModelClasses.size();
    }

    class saloonViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public saloonViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.saloon_product);
            productname= itemView.findViewById(R.id.saloon_product_name);
            productprice = itemView.findViewById(R.id.saloon_product_price);

        }
    }

}
