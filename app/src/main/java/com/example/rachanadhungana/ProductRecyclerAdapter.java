package com.example.rachanadhungana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductDataViH> {
    private ArrayList<Product> productList=new ArrayList<>();
    private Context context;

    ProductRecyclerAdapter(ArrayList<Product> dataList,Context mContext){
        productList.clear();
        productList.addAll(dataList);
        context=mContext;

    }

    @NonNull
    @Override
    public ProductDataViH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item,parent,false);
        return new ProductDataViH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDataViH holder, int position) {
        holder.txtProductTitle.setText(productList.get(position).getTitle());
        holder.txtProductDescription.setText(productList.get(position).getProductDescription());
        holder.txtProductUnit.setText(productList.get(position).getUnit());
        holder.txtProductQuantity.setText(productList.get(position).getQuantity());
        holder.txtProductPrice.setText(productList.get(position).getPrice());
        holder.imgProduct.setImageDrawable(context.getResources().getDrawable(productList.get(position).getImageProduct()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
