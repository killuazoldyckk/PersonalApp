package com.example.personalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Hobby extends AppCompatActivity {

    ListView listView;
    List<Pojo> list;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill);

        listView = findViewById(R.id.list_view);

        listShow();
        myAdapter = new MyAdapter(this,list);
        listView.setAdapter(myAdapter);
    }

    private void listShow(){
        list = new ArrayList<>();

        list.add(new Pojo(R.drawable.singing,"Singing"));
        list.add(new Pojo(R.drawable.reading,"Reading"));
        list.add(new Pojo(R.drawable.gaming,"Gaming"));

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
                Intent intent = new Intent(this,Skill.class);
                startActivity(intent);
                break;
            case R.id.resume:
                Toast.makeText(this, "This is my skills page", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Resume.class);
                startActivity(intent1);
                break;
            case R.id.hobbies:
                Toast.makeText(this, "This is my hobbies page", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this,Hobby.class);
                startActivity(intent2);
                break;
            case R.id.logout:
                Toast.makeText(this, "You have log out", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this,Login.class);
                startActivity(intent3);
                break;
            case R.id.uitm:
                Toast.makeText(this, "This is UiTM Website", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this,WebUiTM.class);
                startActivity(intent4);
                break;
            case R.id.portal:
                Toast.makeText(this, "This is iStudent Portal", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this,Portal.class);
                startActivity(intent5);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}