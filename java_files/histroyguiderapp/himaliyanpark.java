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

public class himaliyanpark extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himaliyanpark);
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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q= Great Himalayan Park");
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
                "*Madhav National Park*" +
                "Located in Shivpuri, Madhya Pradesh, India." +
                "A historic and ecologically rich national park known for its mixed deciduous forest and diverse wildlife.<br/><br/>" +

                "<b>Key Highlights</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Located in Shivpuri district, Madhya Pradesh." +
                "   - Covers an area of around 354 square kilometers.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The park features two prominent lakes: Sakhya Sagar and Madhav Sagar." +
                "   - The George Castle, built by the Scindia dynasty, offers panoramic views of the park.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the ideal time for visiting." +
                "   - Winter is best for spotting wildlife and migratory birds.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for jungle safaris, birdwatching, and nature trails." +
                "   - Boating in Sakhya Sagar lake provides opportunities to view crocodiles and birds up close." +
                "   - The annual Shivpuri Fair attracts visitors with cultural events.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Threatened by deforestation, poaching, and habitat encroachment." +
                "   - Human-wildlife conflicts due to grazing in the park area.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Gwalior (120 km away)." +
                "   - Nearest railway station: Shivpuri." +
                "   - Well-connected by road from Gwalior, Jhansi, and other parts of Madhya Pradesh.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
