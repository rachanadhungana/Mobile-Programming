package com.example.rachanadhungana;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editEmail, editPassword;
    private CheckBox chkRememberMe;
    private AppCompatButton btnLogin;
    private TextView txtForgotPassword, tvSignUp;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initToolbar();
        findViews();

    }
    private void findViews(){
        editEmail=findViewById(R.id.idemail);
        editPassword=findViewById(R.id.idpassword);
        chkRememberMe=findViewById(R.id.checkbox);
        btnLogin=findViewById(R.id.btnlogin);;
        txtForgotPassword=findViewById(R.id.forgotpassword);
        tvSignUp=findViewById(R.id.tvSignUp);
        toolbar=findViewById(R.id.toolbar);
        tvSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = editEmail.getText().toString().trim();
//                String password = editPassword.getText().toString().trim();
//                if (email.isEmpty()) {
//                    Toast.makeText(LoginActivity.this,"Email can not be empty",Toast.LENGTH_SHORT).show();
//
//                } else if (password.isEmpty()) {
//                    Toast.makeText(LoginActivity.this,"Password can not be empty",Toast.LENGTH_SHORT).show();
//
//
//                }else if (!email.equals("rachanadhungana405@gmail.com")&& !password.equals("rachana")) {
//                    Toast.makeText(LoginActivity.this,"Login credential didnot match",Toast.LENGTH_SHORT).show();
//
//
//                } else {
//                    Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
    }
    private void initToolbar(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.user);
        getSupportActionBar().setTitle("Login page");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==android.R.id.home){
            Toast.makeText(LoginActivity.this, "Profile Clicker", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.cart){
            Toast.makeText(LoginActivity.this, "Cart is clicked", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.notification){
            Toast.makeText(LoginActivity.this, "Notification is clicked", Toast.LENGTH_SHORT).show();
        }
        else if(id==android.R.id.message){
            Toast.makeText(LoginActivity.this, "Message is clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tvSignUp){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("Email","rachanadhungana88@gmail.com");
            signUpActivityLauncher.launch(intent);

    }else if(v.getId()==R.id.btnlogin){
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(LoginActivity.this,"Email can not be empty",Toast.LENGTH_SHORT).show();

            } else if (password.isEmpty()) {
                Toast.makeText(LoginActivity.this,"Password can not be empty",Toast.LENGTH_SHORT).show();


            }else if (!email.equals("rachanadhungana405@gmail.com")&& !password.equals("rachana")) {
                Toast.makeText(LoginActivity.this,"Login credential didnot match",Toast.LENGTH_SHORT).show();


            } else {
                Intent intent=new Intent(LoginActivity.this, ProductGridActivity.class);
                startActivity(intent);
//                Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();

            }
        }
    }

    ActivityResultLauncher<Intent> signUpActivityLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult activityResult) {
            if (activityResult.getResultCode()==RESULT_OK){
                Toast.makeText(LoginActivity.this,activityResult.getResultCode(),Toast.LENGTH_SHORT).show();
            }

        }
    }) ;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        if(requestCode==200 && resultCode==RESULT_OK){
            Toast.makeText(LoginActivity.this,data.getStringExtra("Result"),Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data, caller);
    }
}