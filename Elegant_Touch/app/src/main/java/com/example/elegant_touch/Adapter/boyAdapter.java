package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.boyModelClass;

import java.util.ArrayList;

public class boyAdapter extends RecyclerView.Adapter<boyAdapter.boyViewHolder>{
    ArrayList<boyModelClass> boyModelClasses;

    public boyAdapter(ArrayList<boyModelClass> boyModelClasses) {
        this.boyModelClasses = boyModelClasses;
    }

    @NonNull
    @Override
    public boyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boyproduct,parent,false);
        return new boyAdapter.boyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull boyViewHolder holder, int position) {
        holder.image.setImageResource(boyModelClasses.get(position).getImage());
        holder.productname.setText(boyModelClasses.get(position).getName());
        holder.productprice.setText(boyModelClasses.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return boyModelClasses.size();
    }

    class boyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public boyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.boy_product);
            productname = itemView.findViewById(R.id.boy_product_name);
            productprice = itemView.findViewById(R.id.boy_product_price);
        }
    }
}
