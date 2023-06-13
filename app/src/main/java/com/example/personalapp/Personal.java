package com.example.personalapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Personal extends AppCompatActivity {

    Intent intent3 = null, chooser3 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);

        Button button1 = findViewById(R.id.launch_dial);
        Button button2 = findViewById(R.id.launch_message);
        Button button3 = findViewById(R.id.launch_email);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "01164583396";

                Intent intent1 = new Intent(Intent.ACTION_DIAL);

                Uri phoneUri = Uri.parse("tel:" + phoneNumber);
                intent1.setData(phoneUri);

                startActivity(intent1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = "01164583396";
                String message = "Hello Vio! I want to offer business cooperation, if you interested please reply this message or call the number above. Sincerly, ....";

                Intent intent2 = new Intent(Intent.ACTION_VIEW);

                intent2.setData(Uri.parse("sms:" + phoneNumber));

                intent2.putExtra("sms_body", message);


                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent3 = new Intent(Intent.ACTION_SEND);
                intent3.setData(Uri.parse("mailto:"));
                String[] to={"vioapriviablah@gmail.com"};
                intent3.putExtra(Intent.EXTRA_EMAIL, to);
                intent3.putExtra(Intent.EXTRA_SUBJECT, "First Email");
                intent3.putExtra(Intent.EXTRA_TEXT, "Hello Vio! I want to offer business cooperation, if you interested please reply this message or call the number above. Sincerly, ....");
                intent3.setType("message/rfc822");
                chooser3 = Intent.createChooser(intent3, "Send Email");
                startActivity(chooser3);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();
        switch (id){
            case R.id.aboutme:
                Toast.makeText(this, "This is about me page", Toast.LENGTH_SHORT).show();
                Intent intent0 = new Intent(this,Personal.class);
                startActivity(intent0);
                break;
            case R.id.skills:
                Toast.makeText(this, "This is my skills page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Personal.this,Skill.class);
                startActivity(intent);
                break;
            case R.id.resume:
                Toast.makeText(this, "This is my skills page", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Resume.class);
                startActivity(intent1);
                break;
            case R.id.hobbies:
                Toast.makeText(this, "This is my hobbies page", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Personal.this,Hobby.class);
                startActivity(intent2);
                break;
            case R.id.logout:
                Toast.makeText(this, "You have log out", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Personal.this,Login.class);
                startActivity(intent3);
                break;
            case R.id.link:
                Toast.makeText(this, "This is my hobbies page", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Personal.this,WebUiTM.class);
                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}