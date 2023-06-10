package com.example.personalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Personal extends AppCompatActivity {

    Button button;
    boolean status = false;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setElevation(0);

        setContentView(R.layout.personal);
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()){
                case R.id.navi_skill:
                    Toast.makeText(this, "Ayam", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.navi_hobbies:
                    Toast.makeText(this, "Pepes", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.navi_link:
                    Toast.makeText(this, "Tahu", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout,new FragmentA()).commit();
                    button.setText("About Me");
                    status = true;
                }else{
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout,new FragmentB()).commit();
                    button.setText("Skill");
                    status = false;
                }
            }
        });
    }
}