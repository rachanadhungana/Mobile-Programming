package com.example.rachanadhungana;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int[] icons={R.drawable.ic_home,R.drawable.chat,R.drawable.user};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initToolbar();
        findViews();
//        setViewPager();

    }

    private void findViews(){
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewpager);
        setViewPager();
        tabLayout.setupWithViewPager(viewPager);
        setIcon();

    }
    private void setIcon(){
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(2).setIcon(icons[2]);
    }
    private void setViewPager(){
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_Fragment(),"Home");
        adapter.addFragment(new Message_Fragment(),"Message");
        adapter.addFragment(new Profile_Fragment(),"Profile");
        viewPager.setAdapter(adapter);
    }

    private void initToolbar(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.user);
        getSupportActionBar().setTitle("Dashboard");
    }
}