package com.example.personalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2;
    EditText userEmail,userPassword;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        textView1 = findViewById(R.id.textview_1);
        textView1.setOnClickListener(this);
        textView2 = findViewById(R.id.textview_2);
        textView2.setOnClickListener(this);

        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userEmail.getText().toString().trim();
                String password = userPassword.getText().toString().trim();

                if (email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(Login.this,Personal.class);
                    intent.putExtra("EMAIL",email);
                    intent.putExtra("PASSWORD",password);
                    startActivity(intent);
                    finish();
                }
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Login.this,Register.class);
                startActivity(intent2);
                finish();
            }
        });

        ImageView imageView = findViewById(R.id.image_view);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Login.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textview_1:
                Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}