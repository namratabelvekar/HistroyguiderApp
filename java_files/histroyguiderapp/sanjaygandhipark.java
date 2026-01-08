package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class sanjaygandhipark extends AppCompatActivity {
private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanjaygandhipark);
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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Sanjay Gandhi Park");
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
                "*Sanjay Gandhi National Park*" +
                "Located in Borivali, Mumbai, Maharashtra, India." +
                "A popular and ecologically significant national park known for its lush greenery, rich wildlife, and historical significance within a bustling urban area.<br/><br/>" +

                "<b>Key Highlights</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in Borivali, Mumbai, Maharashtra." +
                "   - Covers an area of around 104 square kilometers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Famous for the ancient *Kanheri Caves*, carved by Buddhists over 2,000 years ago." +
                "   - Offers panoramic views of Mumbai city from its higher trails." +
                "   - Features a toy train ride called *Vanrani*, popular among tourists.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the best time to visit." +
                "   - Monsoon season (June to September) enhances the park's lush greenery.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for jungle safaris, trekking, and cycling trails." +
                "   - Boating at the park's artificial lake is a favorite activity." +
                "   - Nature walks and birdwatching tours are available for visitors.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Faces challenges due to urban encroachment and pollution." +
                "   - Leopard-human conflicts occur due to proximity to residential areas.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Chhatrapati Shivaji Maharaj International Airport, Mumbai (20 km away)." +
                "   - Nearest railway station: Borivali (adjacent to the park entrance)." +
                "   - Well-connected by road from all parts of Mumbai and nearby regions.";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
