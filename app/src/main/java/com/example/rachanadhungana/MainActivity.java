package com.example.rachanadhungana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton btnRegister;
    private AppCompatSpinner spinnerGender;
    private RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
        String email=getIntent().getStringExtra("Email");
        Toast.makeText(this,"Email: "+email,Toast.LENGTH_SHORT).show();

        btnRegister=findViewById(R.id.btnRegister);
        spinnerGender=findViewById(R.id.spinnerGender);
        rgGender=findViewById(R.id.rgGender);
        setSpinnerGender();
        setRadioGroup();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("Result","Result Return");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
    private void setRadioGroup(){
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton=findViewById(checkedId);
                Toast.makeText(MainActivity.this,selectedRadioButton.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setSpinnerGender(){
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.genderValue));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
        spinnerGender.setSelection(0);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}