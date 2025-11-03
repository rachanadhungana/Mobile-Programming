package com.example.rachanadhungana;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private CheckBox chkRememberMe;
    private AppCompatButton btnLogin;
    private TextView txtForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        findViews();

    }
    private void findViews(){
        editEmail=findViewById(R.id.idemail);
        editPassword=findViewById(R.id.idpassword);
        chkRememberMe=findViewById(R.id.checkbox);
        btnLogin=findViewById(R.id.btnlogin);;
        txtForgotPassword=findViewById(R.id.forgotpassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this,"Email can not be empty",Toast.LENGTH_SHORT).show();

                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this,"Password can not be empty",Toast.LENGTH_SHORT).show();


                }else if (!email.equals("rachanadhungana405@gmail.com")&& !password.equals("rachana")) {
                    Toast.makeText(LoginActivity.this,"Login credential didnot match",Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}