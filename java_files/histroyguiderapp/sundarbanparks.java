package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class sundarbanparks extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundarbanparks);
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
            // Open Google Maps with the location of Allora Caves Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Sundarban  Park");
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
                "*Sundarban National Park*" +
                "Located in the Sundarbans delta, West Bengal, India." +
                "A UNESCO World Heritage Site, known for its vast mangrove forests, unique biodiversity, and the iconic Royal Bengal Tigers.<br/><br/>" +

                "<b>Key Highlights</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in the Sundarbans delta region of West Bengal." +
                "   - Covers an area of around 1,330 square kilometers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Known for being one of the largest mangrove ecosystems in the world." +
                "   - The park is home to the Royal Bengal Tiger, which has adapted to swim in the saline waters." +
                "   - Features unique tidal waterways, mudflats, and small islands.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the ideal time to visit, with cooler and more comfortable weather." +
                "   - Winter is also the best season for wildlife spotting, especially tigers and migratory birds.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for boat safaris through the mangrove channels to spot wildlife." +
                "   - Birdwatching, especially for species like kingfishers, herons, and egrets." +
                "   - Visiting watchtowers like Sudhanyakhali and Dobanki for better chances of spotting tigers.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Threatened by rising sea levels, climate change, and habitat loss." +
                "   - Poaching and human-wildlife conflicts due to the proximity of local communities." +
                "   - Frequent cyclones that impact the delicate ecosystem.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Netaji Subhas Chandra Bose International Airport, Kolkata (120 km away)." +
                "   - Nearest railway station: Canning (48 km away)." +
                "   - Well-connected by road to Kolkata, followed by a boat ride to reach the park.";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}