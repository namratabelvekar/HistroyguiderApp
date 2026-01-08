package com.example.histroyguiderapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Rajgad extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajgad);

        viewFlipper = findViewById(R.id.viewFlipper);

        // Set up flipping for images
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        // Find buttons by ID
        ImageButton contactButton = findViewById(R.id.button);
        ImageButton locationButton = findViewById(R.id.button2);

        // Set onClickListener for Contact button
        contactButton.setOnClickListener(v -> {
            // Dial the contact number
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:9970104256"));
            startActivity(dialIntent);
        });

        // Set onClickListener for Location button
        locationButton.setOnClickListener(v -> {
            // Open Google Maps with the location of Rajgad Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Rajgad Fort");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        // Find EditText and Button for showing the image
        EditText imageNumberInput = findViewById(R.id.imageNumberInput);
        Button displayImageButton = findViewById(R.id.displayImageButton);

        // Set OnClickListener to display the image based on input
        displayImageButton.setOnClickListener(v -> {
            // Get the entered image number
            String imageNumberString = imageNumberInput.getText().toString();
            if (!imageNumberString.isEmpty()) {
                int imageNumber = Integer.parseInt(imageNumberString);

                // Stop the ViewFlipper from auto-flipping
                viewFlipper.stopFlipping();

                // Check if the image number is within the valid range
                if (imageNumber >= 1 && imageNumber <= 10) {
                    // Display the image based on the entered number
                    viewFlipper.setDisplayedChild(imageNumber - 1);

                    // Create a Handler to show the image for 5 seconds
                   // new Handler().postDelayed(() -> {
                        // After 5 seconds, start flipping again
                        //viewFlipper.startFlipping();
                   // }, 5000); // 5000 milliseconds = 5 seconds
                } else {
                    // Handle invalid input (e.g., out of range)
                    imageNumberInput.setError("Enter a valid image number between 1 and 10");
                }
            }
        });

        // Format and set text with bold "About" and "History"
        String aboutText = "<b>About:</b><br/><br/>" +
                "Rajgad Fort is one of the most historically significant and majestic forts in Maharashtra, India. It is renowned for its rich history, intricate architecture, and strategic importance during the Maratha Empire.<br/><br/>" +
                "<b>1. Location:</b><br/><br/>" +
                "Rajgad Fort is located near Pune, Maharashtra, around 60 kilometers southwest of the city. It is perched at an altitude of about 1,376 meters (4,514 feet) above sea level, offering stunning views of the surrounding Sahyadri range.<br/><br/>" +
                "<b>2. Historical Significance:</b><br/><br/>" +
                "Rajgad Fort served as the capital of the Maratha Empire for nearly 25 years during the reign of Chhatrapati Shivaji Maharaj before he shifted his base to Raigad Fort. It was the site where many crucial decisions were made regarding the expansion of the empire, and it was a key military base for Shivaji's campaigns. The fort witnessed significant historical events, including the birth of Shivaji’s son, Rajaram, and the death of his queen, Saibai.<br/><br/>" +
                "<b>3. Architecture:</b><br/><br/>" +
                "Rajgad Fort is divided into several parts based on the various structures and features on the fort:<br/><br/>" +
                "<b>Padmavati Machi:</b> This is the main residential area and housed the Padmavati Temple, a lake, and several other structures. It served as the quarters for Shivaji and his troops.<br/>" +
                "<b>Sanjivani Machi:</b> A three-layered fortification that provided strong defense from the western side. It has extensive walls and bastions, offering a panoramic view of the surroundings.<br/>" +
                "<b>Suvela Machi:</b> Known for its narrow pass and watchtowers, it served as an important lookout point.<br/>" +
                "<b>Balekilla (Citadel):</b> The highest point of the fort, from where one can enjoy breathtaking views. The Balekilla is where the king’s palace and administrative headquarters were situated.<br/><br/>" +
                "<b>4. Strategic Importance:</b><br/><br/>" +
                "Rajgad’s location and its complex fortification made it a highly defensible structure. Its architecture allowed the Marathas to effectively monitor enemy movements and defend the empire against invaders. The fort was nearly impregnable due to its steep slopes and fortified walls.<br/><br/>" +
                "<b>5. Trekking and Tourism:</b><br/><br/>" +
                "Rajgad is one of the most popular trekking destinations in Maharashtra, especially among history enthusiasts and nature lovers. The trek is moderately challenging and typically takes around 3-4 hours to ascend from the base village, Gunjavane. Visitors can explore various sections of the fort, including temples, water tanks, fort walls, and the citadel.<br/><br/>" +
                "<b>6. Best Time to Visit:</b><br/><br/>" +
                "<b>Monsoon (June to September):</b> The fort is covered in lush greenery during the rainy season, making it a picturesque and popular time for treks. However, the trails can become slippery.<br/>" +
                "<b>Winter (October to February):</b> The weather is cool and pleasant, making it an ideal time to explore the fort.<br/><br/>" +
                "<b> Thank You..!</b><br/><br/>";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
