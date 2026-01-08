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

public class MysorePalace extends AppCompatActivity {

    private ViewFlipper viewFlipper;// Declare the ViewFlipper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysore_palace);

        // Initialize ViewFlipper
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
            // Open Google Maps with the location of Mysore Palace
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Mysore Palace");
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


        // Format and set text with bold "About" and "History"
        String aboutText = "<b>About:</b><br/><br/>" +
                "*Mysore Palace*" +
                "Located in the city of Mysuru, Karnataka, India." +
                "A grand royal residence known for its Indo-Saracenic architecture, rich history, and cultural significance.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in the heart of Mysuru, Karnataka." +
                "   - Originally built in the 14th century, the current structure was completed in 1912 under the Wodeyar dynasty.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The palace showcases a blend of Hindu, Muslim, Rajput, and Gothic architectural styles." +
                "   - Features intricately decorated halls, stained glass windows, and ornate ceilings." +
                "   - The Durbar Hall, Kalyana Mantapa (marriage pavilion), and Ambavilasa (private hall) are highlights.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - September to March is the ideal time for a visit, with pleasant weather." +
                "   - The palace is magnificently lit up with 100,000 bulbs every Sunday evening and during the Dussehra festival.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for guided tours showcasing the palace’s history and artifacts." +
                "   - Witness the grandeur of the Dussehra celebrations held annually in October, featuring a royal procession and cultural events." +
                "   - The Sound and Light show held in the evenings narrates the palace's rich history.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Preservation efforts are ongoing to protect the palace from the effects of aging and increasing tourism." +
                "   - Maintenance challenges due to large crowds during festivals and special events.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Mysuru Airport (14 km away) or Kempegowda International Airport, Bengaluru (around 170 km away)." +
                "   - Nearest railway station: Mysuru Junction (2 km away)." +
                "   - Well-connected by road from Bengaluru, with buses and taxis readily available.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }


}