package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Rajajipark extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajajipark);
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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Rajaji Park");
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
                "Rajaji National Park" +
                "Located in the foothills of the Himalayas, Uttarakhand, India." +
                "Known for its rich biodiversity, including a large population of elephants and diverse landscapes, combining dense forests, grasslands, and rivers.<br/><br/>" +

                "<b>Key Highlights</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Spread across the districts of Haridwar, Dehradun, and Pauri Garhwal in Uttarakhand." +
                "   - Covers an area of around 820 square kilometers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - Part of the Shivalik Elephant Reserve, known for its significant elephant population." +
                "   - The park is also home to the Ganges River, which flows through it, creating scenic riverine landscapes." +
                "   - Merges with Corbett Tiger Reserve, forming a crucial wildlife corridor.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - November to March is the ideal time to visit." +
                "   - Winter months are best for wildlife sightings and pleasant weather.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for jungle safaris and elephant rides to explore the park's diverse flora and fauna." +
                "   - Birdwatching, with over 300 bird species, including the great hornbill and pied kingfisher." +
                "   - Trekking and nature trails, especially in the Chilla and Motichur ranges.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Human-wildlife conflicts, particularly with elephants raiding nearby crops." +
                "   - Threats from encroachment, illegal grazing, and poaching." +
                "   - Habitat fragmentation due to infrastructure development in surrounding areas.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Jolly Grant Airport, Dehradun (35 km away)." +
                "   - Nearest railway station: Haridwar (24 km away)." +
                "   - Well-connected by road from Dehradun, Rishikesh, and Haridwar.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
