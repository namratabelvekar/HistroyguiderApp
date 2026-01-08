package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Caves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caves);
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

                Toast.makeText(getApplicationContext(),"You clicked:Allora Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this,AlloraCaves.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Bagh Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this, BaghCaves.class);
                startActivity(i);
            }
        });



        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Bhim Betka Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this, BhimBetkaCaves.class);
                startActivity(i);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Badami Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this, BadamiCaves.class);
                startActivity(i);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Elephanta Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this, ElephantaCaves.class);
                startActivity(i);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Uday Giri Caves",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Caves.this,UdayGiriCaves.class);
                startActivity(i);
            }
        });




    }

}


