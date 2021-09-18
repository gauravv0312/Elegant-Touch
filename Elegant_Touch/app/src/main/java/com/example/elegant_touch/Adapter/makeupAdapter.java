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
import com.example.elegant_touch.modelclass.girlModelClass;
import com.example.elegant_touch.modelclass.makeupModelClass;

import java.util.ArrayList;

public class makeupAdapter extends RecyclerView.Adapter<makeupAdapter.makeupViewHolder>{
    ArrayList<makeupModelClass> makeupModelClasses;
    Context context;
    public makeupAdapter(ArrayList<makeupModelClass> makeupModelClasses, Context applicationContext) {
        this.makeupModelClasses = makeupModelClasses;
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public makeupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.makeupproduct,parent,false);
        return new makeupAdapter.makeupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull makeupViewHolder holder, int position) {
        final makeupModelClass temp = makeupModelClasses.get(position);
     holder.image.setImageResource(makeupModelClasses.get(position).getImage());
     holder.productname.setText(makeupModelClasses.get(position).getName());
     holder.productprice.setText(makeupModelClasses.get(position).getPrice());
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

    class makeupViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productname,productprice;
        public makeupViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.makeup_product);
            productname = itemView.findViewById(R.id.makeup_product_name);
            productprice = itemView.findViewById(R.id.makeup_product_price);
        }
    }
}
