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
import com.example.elegant_touch.modelclass.soapModelClass;

import java.util.ArrayList;

public class soapAdapter extends RecyclerView.Adapter<soapAdapter.soapViewHolder> {
    ArrayList<soapModelClass> soapModelClasses;
    Context context;
    public soapAdapter(ArrayList<soapModelClass> soapModelClasses, Context applicationContext) {
        this.soapModelClasses = soapModelClasses;
        this.context = applicationContext;
    }
    @NonNull
    @Override
    public soapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.soapproduct,parent,false);
        return new soapAdapter.soapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull soapViewHolder holder, int position) {
        final soapModelClass temp = soapModelClasses.get(position);
        holder.image.setImageResource(soapModelClasses.get(position).getImage());
        holder.productname.setText(soapModelClasses.get(position).getName());
        holder.productprice.setText(soapModelClasses.get(position).getPrice());
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
        return 0;
    }

    class soapViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public soapViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.soap_product);
            productname = itemView.findViewById(R.id.soap_product_name);
            productprice = itemView.findViewById(R.id.soap_product_price);
        }
    }
}
