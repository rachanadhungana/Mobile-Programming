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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }
}