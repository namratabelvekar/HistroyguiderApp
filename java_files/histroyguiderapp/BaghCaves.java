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

public class BaghCaves extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagh_caves);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=bagh caves");
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
                "*Bagh Caves*" +
                "Located in Dhar district, Madhya Pradesh, India." +
                "A set of rock-cut caves known for their exquisite ancient murals and Buddhist architectural style, dating back to the 5th to 7th century CE.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated on the banks of the Baghani River, around 97 kilometers from Dhar, Madhya Pradesh." +
                "   - Consists of nine rock-cut caves, primarily used as viharas (monastic cells) by Buddhist monks.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Known for their beautiful paintings, depicting scenes from the Jataka tales and other Buddhist themes." +
                "   - The murals, painted using vegetable dyes, reflect the influence of the Ajanta Caves' style but with unique regional adaptations." +
                "   - Cave 4 (also known as Rang Mahal) is particularly famous for its well-preserved paintings and intricate carvings.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The best time to visit is between October and March when the weather is pleasant." +
                "   - Early morning visits are recommended to explore the caves comfortably before the heat intensifies.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Ideal for history buffs, art enthusiasts, and those interested in ancient Buddhist culture." +
                "   - Guided tours can provide insights into the significance of the murals and the caves' history." +
                "   - Visitors can also explore nearby historical sites and enjoy the natural beauty of the Baghani River area.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The paintings are slowly deteriorating due to moisture, erosion, and lack of preservation measures." +
                "   - Efforts are underway to restore and protect the murals from further damage.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Devi Ahilya Bai Holkar Airport, Indore (approximately 160 km away)." +
                "   - Nearest railway station: Mhow Railway Station (around 140 km away)." +
                "   - Well-connected by road from cities like Indore, Ujjain, and Dhar.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}