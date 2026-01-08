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

public class dajipur extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dajipur);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Dajipur Sanctuary");
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
                "*Dajipur Wildlife Sanctuary (Bison Sanctuary)*<br/><br/>" +
                "Located on the borders of Kolhapur and Sindhudurg districts in the Western Ghats, Maharashtra, India." +
                " The sanctuary is renowned for its rich biodiversity, scenic landscapes, and the Indian bison (gaur). It offers a perfect retreat for nature lovers and wildlife enthusiasts.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated about 120 km from Kolhapur and approximately 490 km from Mumbai." +
                "   - Part of the Western Ghats, a UNESCO World Heritage site, known for its ecological significance.<br/><br/>" +

                "<b>Flora:</b><br/><br/>" +
                "   - The sanctuary features evergreen, semi-evergreen, and deciduous forests." +
                "   - Common trees include teak, bamboo, ain, hirda, and kinjal, contributing to the dense vegetation.<br/><br/>" +

                "<b>Fauna:</b><br/><br/>" +
                "   - Known for the Indian bison (gaur), often seen in herds grazing in the open meadows." +
                "   - Other wildlife includes leopards, wild boars, sambar deer, barking deer, and sloth bears." +
                "   - The sanctuary is also home to various bird species like peacocks, hornbills, and eagles, making it a popular bird-watching destination.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular activities include wildlife safaris, bird watching, and trekking through the scenic trails." +
                "   - The nearby Radhanagari Dam adds to the sanctuary’s scenic charm, attracting tourists for its serene environment.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The best time to visit is from October to March when the weather is cool and pleasant." +
                "   - The monsoon season transforms the sanctuary into a lush green paradise, but heavy rains may make travel challenging.<br/><br/>" +

                "<b>Conservation Efforts:</b><br/><br/>" +
                "   - The sanctuary is part of the larger Radhanagari Wildlife Sanctuary, with ongoing efforts to protect endangered species like the Indian bison." +
                "   - Focus on preserving the biodiversity of the Western Ghats region.<br/><br/>" +

                "<b>Access and Accommodation:</b><br/><br/>" +
                "   - Accessible by road from Kolhapur, with regular buses and taxis available." +
                "   - Basic accommodations include lodges and forest guest houses in the vicinity for visitors looking to stay overnight.";
        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}