package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import android.os.Bundle;

public class  Fort extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fort);


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

                        Toast.makeText(getApplicationContext(),"You clicked:Rajgad",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this,Rajgad.class);
                        startActivity(i);
                    }
                });

                i2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"You clicked:Red Fort",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this, Red_fort.class);
                        startActivity(i);
                    }
                });



                i3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"You clicked:Agra Fort",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this, Agra.class);
                        startActivity(i);
                    }
                });


                i4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"You clicked:Amber Fort",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this, Amber.class);
                        startActivity(i);
                    }
                });


                i5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"You clicked: Mehrangarh Fort",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this, Mehrangarh.class);
                        startActivity(i);
                    }
                });

                i6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"You clicked:Chittorgarth Fort",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Fort.this, Chittorgarth.class);
                        startActivity(i);
                    }
                });




            }

        }

    
