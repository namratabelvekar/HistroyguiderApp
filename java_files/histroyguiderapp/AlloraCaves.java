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

public class AlloraCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allora_caves);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=ellora caves");
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
                "*Ellora Caves*" +
                "Located in Aurangabad, Maharashtra, India." +
                "A UNESCO World Heritage site renowned for its stunning rock-cut architecture and religious significance, showcasing Buddhist, Hindu, and Jain monuments from the 6th to 10th century CE.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated about 30 kilometers from Aurangabad city, Maharashtra." +
                "   - Comprising 34 caves, including monasteries, temples, and prayer halls carved into the Charanandri hills.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The most famous cave is the Kailasa Temple (Cave 16), a massive monolithic structure dedicated to Lord Shiva." +
                "   - Known for its intricate sculptures, elaborate carvings, and impressive architectural precision." +
                "   - Represents a confluence of three major religions: Buddhism, Hinduism, and Jainism, showcasing India's ancient diversity and craftsmanship.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal time to visit is between October and March when the weather is cooler." +
                "   - Visiting in the early morning is recommended to avoid crowds and fully appreciate the carvings in natural light.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - A popular site for history enthusiasts, art lovers, and architecture students." +
                "   - Guided tours are available to explore the detailed history and significance of each cave." +
                "   - The annual Ellora Ajanta Festival celebrates the region's cultural heritage through music and dance performances.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Faces challenges due to weathering, pollution, and visitor foot traffic." +
                "   - Conservation efforts include restoring damaged sculptures and protecting the site from environmental damage.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Aurangabad Airport (approximately 36 km away)." +
                "   - Nearest railway station: Aurangabad Railway Station (around 30 km away)." +
                "   - Well-connected by road from cities like Pune, Mumbai, and Nashik.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}