package com.example.elegant_touch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.offerModelClass;
import com.example.elegant_touch.modelclass.perfumeModelClass;

import java.util.ArrayList;

public class offerAdapter extends RecyclerView.Adapter<offerAdapter.offerViewHolder>{
    ArrayList<offerModelClass> offerModelClasses;

    public offerAdapter(ArrayList<offerModelClass> offerModelClasses) {
        this.offerModelClasses = offerModelClasses;
    }


    @NonNull
    @Override
    public offerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.offer,parent,false);
        return new offerAdapter.offerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull offerViewHolder holder, int position) {
        holder.image.setImageResource(offerModelClasses.get(position).getImage());
        holder.offer.setText(offerModelClasses.get(position).getOfferDetails());

    }

    @Override
    public int getItemCount() {
        return offerModelClasses.size();

    }

    class offerViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView offer;
        public offerViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.offerimage);
            offer = itemView.findViewById(R.id.offerText);
        }
    }
}
