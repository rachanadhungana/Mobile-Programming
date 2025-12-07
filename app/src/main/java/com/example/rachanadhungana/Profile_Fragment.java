package com.example.rachanadhungana;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


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
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlertDialog();
            }
        });
    }

    private void createAlertDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Alert");
        builder.setMessage("This is an Alert Box");
        builder.setIcon(R.drawable.user);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"Okay is clicked",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"Cancel is clicked",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}