package com.example.rachanadhungana;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Profile_Fragment extends Fragment {

    private View mainView;
    private Button btnAlert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mainView= inflater.inflate(R.layout.fragment_profile, container, false);
       findView();
       return mainView;
    }
    private void findView(){
        btnAlert=mainView.findViewById(R.id.btnAlert);
    }
}