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

public class Register extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2;
    EditText userName,userEmail,userPassword;
    Button submitBtn;
    CheckBox checkBox;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);

        dbHelper = new DBHelper(this);


        textView1 = findViewById(R.id.textview_1);
        textView1.setOnClickListener(this);
        textView2 = findViewById(R.id.textview_2);
        textView2.setOnClickListener(this);


        userName = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submit_btn);


        checkBox = findViewById(R.id.checkBox);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Register.this,Login.class);
                startActivity(intent2);
                finish();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString().trim();
                String email = userEmail.getText().toString().trim();
                String password = userPassword.getText().toString().trim();

                if (name.equals("") || email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    dbHelper.registerUser(name, email, password);
                    Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,Login.class);
                    intent.putExtra("NAME",name);
                    intent.putExtra("EMAIL",email);
                    intent.putExtra("PASSWORD",password);
                    startActivity(intent);
                    finish();
                }
            }
        });

        ImageView imageView = findViewById(R.id.image_view);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Register.this, "Clicked", Toast.LENGTH_SHORT).show();
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