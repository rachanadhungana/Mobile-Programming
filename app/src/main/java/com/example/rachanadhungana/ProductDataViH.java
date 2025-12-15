package com.example.rachanadhungana;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductDataViH extends RecyclerView.ViewHolder {
    TextView txtProductTitle, txtProductDescription, txtProductUnit,txtProductQuantity,txtProductPrice;
    ImageView imgProduct;
    public ProductDataViH(@NonNull View itemView) {
        super(itemView);
        txtProductTitle=itemView.findViewById(R.id.txtProductTitle);
        txtProductDescription=itemView.findViewById(R.id.txtProductDescription);
        txtProductUnit=itemView.findViewById(R.id.txtProductUnit);
        txtProductQuantity=itemView.findViewById(R.id.txtProductQuantity);
        txtProductPrice=itemView.findViewById(R.id.txtProductPrice);
        imgProduct=itemView.findViewById(R.id.imgProduct);
    }
}
