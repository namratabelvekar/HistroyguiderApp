package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class JaipurCityPalace extends AppCompatActivity {
    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaipur_city_palace);

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
            // Open Google Maps with the location of Jaipur City Palace
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jaipur City Palace");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

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
                if (imageNumber >= 1 && imageNumber <= 6) {
                    // Display the image based on the entered number
                    viewFlipper.setDisplayedChild(imageNumber - 1);

                    // Create a Handler to show the image for 5 seconds
                    // new Handler().postDelayed(() -> {
                    // After 5 seconds, start flipping again
                    //viewFlipper.startFlipping();
                    // }, 5000); // 5000 milliseconds = 5 seconds
                } else {
                    // Handle invalid input (e.g., out of range)
                    imageNumberInput.setError("Enter a valid image number between 1 and 6");
                }
            }
        });



        String aboutText = "<b>About:</b><br/><br/>" +
                "*Jaipur City Palace*" +
                "Located in the heart of Jaipur, Rajasthan, India." +
                "A grand palace complex that reflects a beautiful blend of Rajasthani and Mughal architectural styles, serving as a royal residence and a symbol of Jaipur's heritage.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in the Pink City of Jaipur, Rajasthan." +
                "   - Constructed by Maharaja Sawai Jai Singh II in the early 18th century (1727-1734) after he moved his capital from Amer to Jaipur.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The palace includes magnificent structures like the Chandra Mahal, Mubarak Mahal, and Diwan-i-Khas (Hall of Private Audience)." +
                "   - The Peacock Gate, Lotus Gate, and Rose Gate are ornately designed entrances representing different seasons." +
                "   - The Chandra Mahal houses a museum with royal artifacts, while the upper floors still serve as a residence for the royal family.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the best time to visit due to the pleasant weather." +
                "   - Early morning visits are recommended to avoid the crowds and experience the palace's serenity.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Explore the City Palace Museum, showcasing textiles, weaponry, and manuscripts from the royal collection." +
                "   - Attend cultural events and exhibitions held within the palace premises throughout the year." +
                "   - Don’t miss the panoramic views of Jaipur from the top floors of Chandra Mahal.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Preservation efforts are ongoing to protect the palace’s delicate artwork, murals, and historic structures." +
                "   - Managing the increasing footfall of tourists is essential to prevent damage to the palace's heritage areas.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Jaipur International Airport (approximately 12 km away)." +
                "   - Nearest railway station: Jaipur Junction (4 km away)." +
                "   - Easily accessible by road, with well-connected routes from major cities like Delhi, Agra, and Udaipur.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }


}