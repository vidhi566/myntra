package com.example.mynthree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mynthree.Product;
import com.example.mynthree.R;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{
    List<Product> products;
    static Context context;

    public ProductListAdapter(Context context, List<Product> products){
        this.context=context;
        this.products=products;
    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.productview, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {

        holder.bindData(products.get(position),position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,price;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.productimage);

        }

        @SuppressLint("SetTextI18n")
        public void bindData(Product s, int index){
            this.name.setText(s.getName());
            price.setText(String.valueOf(s.getPrice()));
            image.setImageResource((int)s.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ProductDetails.class);
                    intent.putExtra("Product",index+1);
                    context.startActivity(intent);
                }
            });
        }
    }
}