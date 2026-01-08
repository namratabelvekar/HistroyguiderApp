package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class palace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palace);
        ImageView i1,i2,i3,i4,i5,i6;




        i1= findViewById(R.id.image1);
        i2=findViewById(R.id.image2);
        i3=findViewById(R.id.image3);
        i4=findViewById(R.id.image4);
        i5=findViewById(R.id.image5);





        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked: Mysore Palace", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(palace.this, MysorePalace.class); // Correct the Intent
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Udaipur city Palace",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(palace.this, UdaipurCityPalace.class); // Adjust to your Udaipur City Palace Activity class
                startActivity(intent);
            }
        });



        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Amber Palace",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(palace.this, AmberPalace.class); // Adjust to your Amber Palace Activity class
                startActivity(intent);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked:Jaipur city palace",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(palace.this, JaipurCityPalace.class); // Adjust to your Jaipur City Palace Activity class
                startActivity(intent);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked: Falaknuma Palace ",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(palace.this, FalaknumaPalace.class); // Adjust to your Falaknuma Palace Activity class
                startActivity(intent);
            }
        });






    }

}
