package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class parks extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parks);
        ImageView i1,i2,i3,i4,i5;




        i1= findViewById(R.id.image1);
        i2=findViewById(R.id.image2);
        i3=findViewById(R.id.image3);
        i4=findViewById(R.id.image4);
        i5=findViewById(R.id.image5);





        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Madhav Park",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(parks.this, madhavpark.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Sanjay Gandhi Park",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(parks.this, sanjaygandhipark.class);
                startActivity(i);
            }
        });



        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Rajaji Park",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(parks.this,Rajajipark.class);
                startActivity(i);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Sundarban Park",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(parks.this, sundarbanparks.class);
                startActivity(i);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Himalayan Park",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(parks.this, himaliyanpark.class);
                startActivity(i);
            }
        });





    }

}