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

import com.example.elegant_touch.modelclass.shampooModelClass;

import java.util.ArrayList;

public class shampooAdapter extends RecyclerView.Adapter<shampooAdapter.shampooViewHolder>{
    ArrayList<shampooModelClass> shampooModelClasses;
    Context context;
    public shampooAdapter(ArrayList<shampooModelClass> shampooModelClasses, Context applicationContext) {
        this.shampooModelClasses = shampooModelClasses;
        this.context = applicationContext;
    }



    @NonNull
    @Override
    public shampooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.makeupproduct,parent,false);
        return new shampooAdapter.shampooViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull shampooViewHolder holder, int position) {
        final shampooModelClass temp = shampooModelClasses.get(position);
        holder.image.setImageResource(shampooModelClasses.get(position).getImage());
        holder.productname.setText(shampooModelClasses.get(position).getName());
        holder.productprice.setText(shampooModelClasses.get(position).getPrice());
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
        return shampooModelClasses.size();
    }

    class shampooViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public shampooViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.shampoo_product);
            productname = itemView.findViewById(R.id.shampoo_product_name);
            productprice = itemView.findViewById(R.id.shampoo_product_price);
        }
    }
}
