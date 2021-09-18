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
import com.example.elegant_touch.modelclass.hairoilModelClass;
import com.example.elegant_touch.modelclass.hairoilModelClass;

import java.util.ArrayList;

public class hairoilAdapter extends RecyclerView.Adapter<hairoilAdapter.hairoilViewHolder>{
    ArrayList<hairoilModelClass> hairoilModelClasses;
    Context context;
    public hairoilAdapter(ArrayList<hairoilModelClass> hairoilModelClasses, Context applicationContext) {
        this.hairoilModelClasses = hairoilModelClasses;
        this.context = applicationContext;
    }
    @NonNull
    @Override
    public hairoilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.makeupproduct,parent,false);
        return new hairoilAdapter.hairoilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hairoilViewHolder holder, int position) {
        final hairoilModelClass temp = hairoilModelClasses.get(position);
        holder.image.setImageResource(hairoilModelClasses.get(position).getImage());
        holder.productname.setText(hairoilModelClasses.get(position).getName());
        holder.productprice.setText(hairoilModelClasses.get(position).getPrice());
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

    class hairoilViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public hairoilViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hairoil_product);
            productname = itemView.findViewById(R.id.hairoil_product_name);
            productprice = itemView.findViewById(R.id.hairoil_product_price);
        }
    }
}
