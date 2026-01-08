package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class sanctuary extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanctuary);
        ImageView i1,i2,i3,i4,i5,i6;




        i1= findViewById(R.id.image1);
        i2=findViewById(R.id.image2);
        i3=findViewById(R.id.image3);
        i4=findViewById(R.id.image4);
        i5=findViewById(R.id.image5);
        i6=findViewById(R.id.image6);




        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Gir Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this,Gir.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Govind Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this, Govind.class);
                startActivity(i);
            }
        });



        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Bharatpur Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this,Bhartpur.class);
                startActivity(i);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Kutch Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this, Kutch.class);
                startActivity(i);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Tadoba Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this, Tadoba.class);
                startActivity(i);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Dajipur Sanctuary",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(sanctuary.this,dajipur.class);
                startActivity(i);
            }
        });




    }

}
