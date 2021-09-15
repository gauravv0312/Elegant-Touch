package com.example.elegant_touch.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_touch.Dashboard.PreviewActivity;
import com.example.elegant_touch.R;
import com.example.elegant_touch.modelclass.girlModelClass;
import com.example.elegant_touch.modelclass.menModelClass;
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class menAdapter extends RecyclerView.Adapter<menAdapter.menViewHolder> {
    ArrayList<menModelClass> menModelClasses;
    Context context;
    public menAdapter(ArrayList<menModelClass> menModelClasses, Context applicationContext) {
        this.menModelClasses = menModelClasses;
        this.context = applicationContext;
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
        final menModelClass temp = menModelClasses.get(position);
        holder.image.setImageResource(menModelClasses.get(position).getImage());
        holder.productname.setText(menModelClasses.get(position).getName());
        holder.productprice.setText(menModelClasses.get(position).getPrice());
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
