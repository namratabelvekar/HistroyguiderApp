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

public class BadamiCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badami_caves);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=badami caves");
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
                "*Badami Caves*" +
                "Located in Bagalkot district, Karnataka, India." +
                "A group of ancient rock-cut temples renowned for their architectural brilliance and intricate carvings, reflecting the Chalukyan style of the 6th to 8th century CE.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated in the town of Badami, approximately 105 kilometers from Hubli, Karnataka." +
                "   - Comprises four major caves carved into sandstone cliffs overlooking the Agastya Lake.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The caves are dedicated to Hindu, Jain, and Buddhist deities, showcasing religious diversity." +
                "   - Famous for its magnificent sculptures of Lord Vishnu, Lord Shiva, and Jain Tirthankaras, including the striking depiction of Nataraja with 18 arms in Cave 1." +
                "   - Known for its detailed frescoes, ornate pillars, and stunning views of the surrounding landscape and Agastya Lake.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal time to visit is between October and March when the weather is cooler and pleasant." +
                "   - Early morning or late afternoon visits are recommended to enjoy the caves in soft natural light and avoid midday heat.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - A popular site for history enthusiasts, art lovers, and photographers." +
                "   - Visitors can explore the nearby Badami Fort, Bhoothnath Temple, and the scenic Agastya Lake." +
                "   - Guided tours are available to provide deeper insights into the caves' history and architectural significance.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The site faces threats from weathering, human activities, and structural deterioration." +
                "   - Ongoing conservation efforts aim to preserve the sculptures and protect the caves from further damage.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Hubli Airport (approximately 106 km away)." +
                "   - Nearest railway station: Badami Railway Station (around 5 km away)." +
                "   - Well-connected by road from major cities like Hubli, Belgaum, and Bangalore.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}