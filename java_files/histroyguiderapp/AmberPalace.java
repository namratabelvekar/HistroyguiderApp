package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class AmberPalace extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amber_palace); // Ensure this matches your XML layout for Amber Palace

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Amber Palace");
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
                "*Amber Palace*" +
                "Located in Amer, Rajasthan, India." +
                "A magnificent fort renowned for its artistic Hindu architecture and rich cultural heritage.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in the town of Amer, around 11 kilometers from Jaipur, Rajasthan." +
                "   - Built by Raja Man Singh I in 1592, expanded by subsequent rulers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The palace boasts intricate mirror work, ornate carvings, and beautiful frescoes." +
                "   - Includes stunning courtyards, palaces, and the famous Sheesh Mahal (Mirror Palace)." +
                "   - Surrounded by scenic Maota Lake, offering breathtaking views.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the ideal time to explore the palace." +
                "   - Early morning visits are recommended to avoid crowds and enjoy cooler temperatures.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for elephant rides up the hill to the main entrance." +
                "   - Light and sound show held in the evening, depicting the history of the fort." +
                "   - Guided tours available to explore its rich architectural and historical significance.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Impacted by increasing tourism, leading to preservation challenges." +
                "   - Efforts are being made to restore damaged structures and maintain its heritage.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Jaipur International Airport (approximately 23 km away)." +
                "   - Nearest railway station: Jaipur Junction (around 13 km away)." +
                "   - Well-connected by road from Jaipur and other parts of Rajasthan.";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
