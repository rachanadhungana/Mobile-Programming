package com.example.rachanadhungana;

import android.os.Bundle;
import android.widget.GridView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ProductGridActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private GridView productGridview;
    private ArrayList<Product> productList=new ArrayList<>();
    private GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        setContentView(R.layout.activity_grid_product);
        initToolbar();
        findViews();
    }
    private void initToolbar(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.user);
        getSupportActionBar().setTitle("Grid View");
    }
    private void findViews(){
        productGridview=findViewById(R.id.productGridView);
        adapter=new GridAdapter(productList,this);
        productGridview.setAdapter(adapter);
    }
    private void setData(){
        Product p1=new Product();
        Product p2=new Product();
        Product p3=new Product();
        Product p4=new Product();
        Product p5=new Product();

        p1.setTitle("Sunsilk Shampooo");
        p1.setProductDescription("It makes your hair silkyyyyy");
        p1.setUnit("Pcs");
        p1.setPrice("499");
        p1.setImageProduct(R.drawable.producti);

        p2.setTitle("Camera");
        p2.setProductDescription("It takes your photo beautifully");
        p2.setUnit("Pcs");
        p2.setPrice("14499");
        p2.setImageProduct(R.drawable.productii);

        p3.setTitle("Shoes");
        p3.setProductDescription("Run Smoothly");
        p3.setUnit("Pcs");
        p3.setPrice("1499");
        p3.setImageProduct(R.drawable.productiii);

        p4.setTitle("Hair Oil");
        p4.setProductDescription("It makes your hair Strong");
        p4.setUnit("Pcs");
        p4.setPrice("499");
        p4.setImageProduct(R.drawable.productiv);

        p5.setTitle("Mango Juice");
        p5.setProductDescription("It makes you  Strong");
        p5.setUnit("Pcs");
        p5.setPrice("50");
        p5.setImageProduct(R.drawable.productv);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
    }
}