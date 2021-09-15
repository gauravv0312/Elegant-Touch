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
import com.example.elegant_touch.modelclass.SaloonModelClass;
import com.example.elegant_touch.modelclass.girlModelClass;
import com.example.elegant_touch.modelclass.parlourModelClass;

import java.util.ArrayList;

public class parlourAdapter extends RecyclerView.Adapter<parlourAdapter.parlourViewHolder>{

    ArrayList<parlourModelClass> parlourModelClasses;
    Context context;
    public parlourAdapter(ArrayList<parlourModelClass> parlourModelClasses, Context applicationContext) {
        this.parlourModelClasses = parlourModelClasses;
        this.context = applicationContext;
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
        final parlourModelClass temp = parlourModelClasses.get(position);
        holder.image.setImageResource(parlourModelClasses.get(position).getImage());
        holder.productname.setText(parlourModelClasses.get(position).getName());
        holder.productprice.setText(parlourModelClasses.get(position).getPrice());
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
