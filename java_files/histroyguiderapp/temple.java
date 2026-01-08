package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class temple extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple);
        ImageView i1,i2,i3,i4,i5;




        i1= findViewById(R.id.image1);
        i2=findViewById(R.id.image2);
        i3=findViewById(R.id.image3);
        i4=findViewById(R.id.image4);
        i5=findViewById(R.id.image5);





        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Somnath Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(temple.this, Somnathtemple.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Kedarnath Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(temple.this, kedarnathtemple.class);
                startActivity(i);
            }
        });



        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Sun Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(temple.this,suntemple.class);
                startActivity(i);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Meenakshi Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(temple.this, meenakshitemple.class);
                startActivity(i);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Jagannath Temple",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(temple.this, jagannathtemple.class);
                startActivity(i);
            }
        });






    }

}