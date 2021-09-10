package com.example.elegant_touch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.womenModelClass;

import java.util.ArrayList;

public class womenAdapter extends RecyclerView.Adapter<womenAdapter.womenViewHolder>{

     ArrayList<womenModelClass> womenModelClasses;

    public womenAdapter(ArrayList<womenModelClass> womenModelClasses) {
        this.womenModelClasses = womenModelClasses;
    }

    @NonNull
    @Override
    public womenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.womenproduct,parent,false);
        return new womenAdapter.womenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull womenViewHolder holder, int position) {
       holder.image.setImageResource(womenModelClasses.get(position).getImage());
       holder.productname.setText(womenModelClasses.get(position).getName());
       holder.productprice.setText(womenModelClasses.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class womenViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public womenViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.women_product);
            productname = itemView.findViewById(R.id.women_product_name);
            productprice = itemView.findViewById(R.id.women_product_price);
        }
    }
}
