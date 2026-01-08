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

public class UdayGiriCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uday_giri_caves);

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
            Uri gmmIntentUri = Uri.parse("https://g.co/kgs/o7AxAyQ");
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
                    imageNumberInput.setError("Enter a valid image number between 1 and 10");
                }
            }
        });

        // Format and set text with bold "About" and "History"
        String aboutText = "<b>About:</b><br/><br/>" +
                "*Udayagiri Caves*" +
                "Located in Vidisha district, Madhya Pradesh, India." +
                "A group of rock-cut caves renowned for their historical significance, ancient inscriptions, and exquisite Gupta-era sculptures, dating back to the early 5th century CE.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated about 10 kilometers from Sanchi, near Vidisha, Madhya Pradesh." +
                "   - Comprises 20 rock-cut caves carved into a sandstone hill, primarily dedicated to Hindu deities, with a few Jain relics.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Famous for the colossal sculpture of Lord Vishnu in his Varaha (boar) avatar rescuing Earth, symbolizing the triumph of good over evil." +
                "   - Notable caves include Cave 5 with its striking Varaha panel, Cave 6 with an impressive Shiva Lingam, and intricate reliefs showcasing Gupta-era artistry." +
                "   - Features ancient inscriptions, including the oldest known Sanskrit inscription by the Gupta ruler Chandragupta II.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal time to visit is between October and March when the weather is cooler and more pleasant." +
                "   - Early morning visits are recommended to explore the caves comfortably and enjoy the serene surroundings.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - A must-visit for history buffs, archaeology enthusiasts, and art lovers interested in ancient Indian culture." +
                "   - Guided tours available to provide deeper insights into the historical and religious significance of the caves." +
                "   - Visitors can also explore nearby attractions like the Sanchi Stupa and Vidisha's ancient ruins.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The caves face threats from natural weathering and human interference." +
                "   - Preservation efforts are ongoing to restore damaged sculptures and protect the caves from further deterioration.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Raja Bhoj Airport, Bhopal (approximately 60 km away)." +
                "   - Nearest railway station: Vidisha Railway Station (around 9 km away)." +
                "   - Well-connected by road from major cities like Bhopal and Sanchi.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}