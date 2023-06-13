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

    Button backButton;
    Intent intent = null, chooser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);

        Button button = findViewById(R.id.launch_email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={"vioapriviablah@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "First Email");
                intent.putExtra(Intent.EXTRA_TEXT, "Hi Vio!, i'm one of your fans from ...");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);
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