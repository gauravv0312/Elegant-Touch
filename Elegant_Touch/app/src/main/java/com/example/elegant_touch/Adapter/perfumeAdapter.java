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
import com.example.elegant_touch.modelclass.parlourModelClass;
import com.example.elegant_touch.modelclass.perfumeModelClass;

import java.util.ArrayList;

public class perfumeAdapter extends RecyclerView.Adapter<perfumeAdapter.perfumeViewHolder>{
     ArrayList<perfumeModelClass> perfumeModelClasses;
     Context context;
    public perfumeAdapter(ArrayList<perfumeModelClass> perfumeModelClasses, Context applicationContext) {
        this.perfumeModelClasses = perfumeModelClasses;
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public perfumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.perfumeproduct,parent,false);
        return new perfumeAdapter.perfumeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull perfumeViewHolder holder, int position) {
        final perfumeModelClass temp = perfumeModelClasses.get(position);
      holder.image.setImageResource(perfumeModelClasses.get(position).getImage());
      holder.productname.setText(perfumeModelClasses.get(position).getName());
      holder.productprice.setText(perfumeModelClasses.get(position).getPrice());
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
        return perfumeModelClasses.size();
    }

    class perfumeViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public perfumeViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.perfume_product);
            productname = itemView.findViewById(R.id.perfume_product_name);
            productprice = itemView.findViewById(R.id.perfume_product_price);
        }
    }
}
