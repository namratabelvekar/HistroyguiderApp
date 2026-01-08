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

public class Tadoba extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tadoba);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Tadoba Sanctuary");
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
                "*Tadoba Andhari Tiger Reserve*<br/><br/>" +
                "Location: Situated in Chandrapur district of Maharashtra, India. It is one of the largest and oldest national parks in Maharashtra, " +
                "famous for its rich biodiversity.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Located in Chandrapur district, Maharashtra, India.<br/>" +
                "   - Encompasses an area of approximately 625 square kilometers.<br/>" +
                "   - Established as a Tiger Reserve in 1995, originally a wildlife sanctuary in 1955.<br/><br/>" +

                "<b>Flora:</b><br/><br/>" +
                "   - The reserve is primarily covered with dry deciduous forests, mixed forests, and grasslands.<br/>" +
                "   - Dominant tree species include Teak, Sal, Mahua, and Bamboo.<br/><br/>" +

                "<b>Fauna:</b><br/><br/>" +
                "   - Home to a significant population of Bengal tigers.<br/>" +
                "   - Other notable species include leopards, Indian wild dogs (dhole), sloth bears, nilgai, and wild boars.<br/>" +
                "   - Over 200 bird species, including the Crested Serpent Eagle and Indian Pitta, can be spotted.<br/>" +
                "   - The park is also home to a variety of reptiles, such as Indian Pythons and Russell's Vipers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Tadoba Lake is a prominent water body that attracts a diverse range of wildlife.<br/>" +
                "   - The combination of forests, grasslands, and wetlands creates a rich ecosystem supporting abundant biodiversity.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to June is the best time for wildlife sightings.<br/>" +
                "   - The park remains closed during the monsoon season (July to September).<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Nagpur (approximately 140 km away).<br/>" +
                "   - Nearest railway station: Chandrapur, well-connected to major cities.<br/>" +
                "   - The park is accessible by road from Chandrapur and Nagpur.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular activities include jeep safaris and guided nature walks for wildlife enthusiasts.<br/>" +
                "   - Birdwatching and photography are also popular among visitors.<br/><br/>" +

                "<b>Conservation Efforts:</b><br/><br/>" +
                "   - Part of Project Tiger, dedicated to protecting Bengal tigers and their habitat.<br/>" +
                "   - The focus is on habitat protection, tiger population monitoring, and promoting eco-tourism.<br/><br/>" +

                "<b>Cultural Significance:</b><br/><br/>" +
                "   - The area is home to indigenous communities who practice local cultural traditions related to wildlife conservation.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}