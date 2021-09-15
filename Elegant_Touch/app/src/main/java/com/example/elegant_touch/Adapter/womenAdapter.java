package com.example.elegant_touch.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.Dashboard.PreviewActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.womenModelClass;

import java.util.ArrayList;

public class womenAdapter extends RecyclerView.Adapter<womenAdapter.womenViewHolder>{

     ArrayList<womenModelClass> womenModelClasses;
     Context context;
    public womenAdapter(ArrayList<womenModelClass> womenModelClasses, Context applicationContext) {
        this.womenModelClasses = womenModelClasses;
        this.context = applicationContext;
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
        final womenModelClass temp = womenModelClasses.get(position);
       holder.image.setImageResource(womenModelClasses.get(position).getImage());
       holder.productname.setText(womenModelClasses.get(position).getName());
       holder.productprice.setText(womenModelClasses.get(position).getPrice());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, PreviewActivity.class);
                intent.putExtra("imagename",temp.getImage());
                intent.putExtra("productname",temp.getName());
                intent.putExtra("productprice",temp.getPrice());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return womenModelClasses.size();
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
