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
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class parlourAdapter extends RecyclerView.Adapter<parlourAdapter.parlourViewHolder>{

    ArrayList<parlourModelClass> parlourModelClasses;

    public parlourAdapter(ArrayList<parlourModelClass> parlourModelClasses) {
        this.parlourModelClasses = parlourModelClasses;
    }
    @NonNull
    @Override
    public parlourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.parlourproduct,parent,false);
        return new parlourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull parlourViewHolder holder, int position) {
        holder.image.setImageResource(parlourModelClasses.get(position).getImage());
        holder.productname.setText(parlourModelClasses.get(position).getName());
        holder.productprice.setText(parlourModelClasses.get(position).getPrice());
    }
    @Override
    public int getItemCount() {
        return parlourModelClasses.size();
    }

    class parlourViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public parlourViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.parlour_product);
            productname =itemView.findViewById(R.id.parlour_product_name);
            productprice = itemView.findViewById(R.id.parlour_product_price);
        }
    }
}
