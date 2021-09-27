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
import com.example.elegant_touch.modelclass.boyModelClass;
import com.example.elegant_touch.modelclass.cartModelClass;

import java.util.ArrayList;

public class boyAdapter extends RecyclerView.Adapter<boyAdapter.boyViewHolder>{
    ArrayList<boyModelClass> boyModelClasses;
    Context context;

    public boyAdapter(ArrayList<boyModelClass> boyModelClasses, Context applicationContext)
    {
        this.boyModelClasses = boyModelClasses;
        this.context = applicationContext;
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
        final boyModelClass temp = boyModelClasses.get(position);
        holder.image.setImageResource(boyModelClasses.get(position).getImage());
        holder.productname.setText(boyModelClasses.get(position).getName());
        holder.productprice.setText(boyModelClasses.get(position).getPrice());
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
