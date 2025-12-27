package com.example.rachanadhungana;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachanadhungana.movie.MovieContainer;
import com.example.rachanadhungana.movie.Results;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductRecyclerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView productRecyclerView;
    private ArrayList<Product> productList=new ArrayList<>();
    private ProductRecyclerAdapter adapter;
    private MovieContainer movieContainer;
    private ArrayList<Results> movieList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute();
        setData();
        setContentView(R.layout.activity_product_recycler);
        initToolbar();
        findViews();

    }
    private void findViews(){
        productRecyclerView=findViewById(R.id.productRecyclerView);
        adapter=new ProductRecyclerAdapter(movieList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(adapter);
    }
    private void initToolbar(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.user);
        getSupportActionBar().setTitle("Product RecyclerView");
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
    class JSONAsyncTask extends AsyncTask<Void,Void,Boolean>{
        ProgressDialog p=new ProgressDialog(ProductRecyclerActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p.setTitle("Please Wait...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51")
                        .build();

                Response response = client.newCall(request).execute(); // <-- synchronous

                if (response.isSuccessful()) {
                    String jsonData = response.body().string();

                    Gson gson = new Gson();
                    movieContainer = gson.fromJson(jsonData, MovieContainer.class);

                    movieList.clear();
                    movieList.addAll(movieContainer.getResultList());

                    return true; // success
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false; // fail
        }

        @Override
        protected void onPostExecute(Boolean success) {
            p.dismiss();

            if (success) {
                adapter = new ProductRecyclerAdapter(movieList, ProductRecyclerActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductRecyclerActivity.this, LinearLayoutManager.HORIZONTAL, false);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(ProductRecyclerActivity.this, 2);
                productRecyclerView.setLayoutManager(linearLayoutManager);
                productRecyclerView.setAdapter(adapter);
            }
        }
    }
}
