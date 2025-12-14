package com.example.rachanadhungana;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private ArrayList<Product> productList=new ArrayList<>();
    private Context context;

    GridAdapter(ArrayList<Product> dataList,Context mContext){
        productList.clear();
        productList.addAll(dataList);
        context=mContext;

    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.adaptor_grid_item,null);

        ProductListVH holder=new ProductListVH(view);
        holder.txtProductTitle.setText(productList.get(position).getTitle());
        holder.txtProductDescription.setText(productList.get(position).getProductDescription());
        holder.txtProductUnit.setText(productList.get(position).getUnit());
        holder.txtProductQuantity.setText(productList.get(position).getQuantity());
        holder.txtProductPrice.setText(productList.get(position).getPrice());
        holder.imgProduct.setImageDrawable(context.getResources().getDrawable(productList.get(position).getImageProduct()));
        return view;
    }
    public static class ProductListVH{
        TextView txtProductTitle, txtProductDescription, txtProductUnit,txtProductQuantity,txtProductPrice;
        ImageView imgProduct;
        ProductListVH(View view){
            txtProductTitle=view.findViewById(R.id.txtProductTitle);
            txtProductDescription=view.findViewById(R.id.txtProductDescription);
            txtProductUnit=view.findViewById(R.id.txtProductUnit);
            txtProductQuantity=view.findViewById(R.id.txtProductQuantity);
            txtProductPrice=view.findViewById(R.id.txtProductPrice);
            imgProduct=view.findViewById(R.id.imgProduct);


        }
    }
}