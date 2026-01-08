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

import androidx.appcompat.app.AppCompatActivity;

public class ElephantaCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elephanta_caves);

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
            // Open Google Maps with the location of elephanta Caves Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Elephanta caves");
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

        // Format and set text with bold "About" and "History"
        String aboutText = "<b>About:</b><br/><br/>" +
                "*Elephanta Caves*" +
                "Located on Elephanta Island, near Mumbai, Maharashtra, India." +
                "A UNESCO World Heritage site, renowned for its impressive rock-cut sculptures and ancient Hindu temples, dating back to the 5th to 8th century CE.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated on Elephanta Island, around 10 kilometers east of the Gateway of India, Mumbai." +
                "   - The site consists of seven caves, with the main cave dedicated to Lord Shiva, showcasing exquisite rock-cut architecture.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The most iconic sculpture is the three-headed Trimurti, symbolizing Lord Shiva as the creator, preserver, and destroyer." +
                "   - The main cave (Cave 1) features grand pillars, intricate carvings, and beautifully sculpted panels depicting scenes from Hindu mythology." +
                "   - Known for its blend of artistry and spirituality, reflecting the rich cultural heritage of ancient India.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal time to visit is between November and February when the weather is pleasant." +
                "   - Visiting in the early morning is recommended to avoid crowds and enjoy a peaceful exploration of the caves.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for history enthusiasts, photographers, and art lovers." +
                "   - A ferry ride from the Gateway of India to Elephanta Island offers scenic views of Mumbai's coastline." +
                "   - Guided tours available to understand the historical and cultural significance of the sculptures and temples.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The caves face threats from natural erosion, pollution, and the impact of tourism." +
                "   - Conservation efforts are focused on preserving the rock-cut sculptures and ensuring the site’s sustainability.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Chhatrapati Shivaji Maharaj International Airport, Mumbai (approximately 25 km from Gateway of India)." +
                "   - Nearest railway station: Chhatrapati Shivaji Maharaj Terminus (around 2 km from Gateway of India)." +
                "   - Accessible by ferry from the Gateway of India, with a journey time of about one hour.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}