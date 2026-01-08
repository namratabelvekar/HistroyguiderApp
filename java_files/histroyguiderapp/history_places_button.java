package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class history_places_button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_places_button);
        ImageButton i1,i2,i3,i4,i5,i6;
        i1=(ImageButton)findViewById(R.id.btnFort);
        i2=(ImageButton)findViewById(R.id.btnPalace);
        i3=(ImageButton)findViewById(R.id.btnTemple);
        i4=(ImageButton)findViewById(R.id.btnParks);

        i5=(ImageButton)findViewById(R.id.btnCaves);
        i6=(ImageButton)findViewById(R.id.btnSanctuary);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Fort",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,Fort.class);
                startActivity(i);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Palace",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,palace.class);
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,temple.class);
                startActivity(i);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Parks",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,parks.class);
                startActivity(i);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,Caves.class);
                startActivity(i);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(history_places_button.this,sanctuary.class);
                startActivity(i);
            }
        });
    }
}