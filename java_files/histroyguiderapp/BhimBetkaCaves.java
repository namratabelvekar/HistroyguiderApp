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

public class BhimBetkaCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhim_betka_caves);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Bhimbetka caves");
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
                "*Bhimbetka Caves*" +
                "Located in Raisen district, Madhya Pradesh, India." +
                "A UNESCO World Heritage site known for its ancient rock shelters and prehistoric cave paintings, showcasing evidence of human life dating back over 30,000 years.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated about 45 kilometers south of Bhopal, Madhya Pradesh." +
                "   - Comprising over 750 rock shelters spread across the Vindhya Mountain range, with around 500 caves containing rock art.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Known for vivid paintings depicting scenes of hunting, dancing, rituals, and daily life of prehistoric humans." +
                "   - The artwork spans various periods, from the Paleolithic and Mesolithic to the early historic era." +
                "   - The paintings are created using natural pigments, showcasing the evolution of human expression and creativity over millennia.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The best time to visit is between October and March when the weather is cool and pleasant." +
                "   - Early morning visits are ideal to enjoy the serene surroundings and explore the caves comfortably.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - A must-visit for history enthusiasts, archaeologists, and nature lovers." +
                "   - Guided tours are available to help visitors understand the significance of the paintings and their historical context." +
                "   - The site also offers scenic walking trails amidst dense forests, enhancing the experience.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The rock art faces threats from weathering, vandalism, and the impact of tourism." +
                "   - Conservation efforts are focused on protecting the paintings and raising awareness among visitors.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Raja Bhoj Airport, Bhopal (approximately 55 km away)." +
                "   - Nearest railway station: Bhopal Junction (around 45 km away)." +
                "   - Well-connected by road from Bhopal and other major cities in Madhya Pradesh.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}