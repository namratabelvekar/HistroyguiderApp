package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class jagannathtemple extends AppCompatActivity {
    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jagannathtemple);
        // Initialize the ViewFlipper
        viewFlipper = findViewById(R.id.viewFlipper);

            viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);


        // Find buttons by ID
        ImageButton contactButton = findViewById(R.id.button);
        ImageButton locationButton = findViewById(R.id.button2);

        // Set onClickListener for Contact button
        if (contactButton != null) {
            contactButton.setOnClickListener(v -> {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:9970104256"));
                startActivity(dialIntent);
            });
        }

        // Set onClickListener for Location button
        if (locationButton != null) {
            locationButton.setOnClickListener(v -> {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jagannath Temple");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            });
        }

        // Find EditText and Button for showing the image
        EditText imageNumberInput = findViewById(R.id.imageNumberInput);
        Button displayImageButton = findViewById(R.id.displayImageButton);

        // Set OnClickListener to display the image based on input
        if (displayImageButton != null && imageNumberInput != null) {
            displayImageButton.setOnClickListener(v -> {
                String imageNumberString = imageNumberInput.getText().toString();
                if (!imageNumberString.isEmpty()) {
                    try {
                        int imageNumber = Integer.parseInt(imageNumberString);

                        // Stop the ViewFlipper from auto-flipping
                        if (viewFlipper != null) {
                            viewFlipper.stopFlipping();

                            // Check if the image number is within the valid range
                            if (imageNumber >= 1 && imageNumber <= 6) {
                                viewFlipper.setDisplayedChild(imageNumber - 1);
                            } else {
                                imageNumberInput.setError("Enter a valid image number between 1 and 6");
                            }
                        }
                    } catch (NumberFormatException e) {
                        imageNumberInput.setError("Invalid number");
                    }
                }
            });
        }

        // Set formatted text with bold headings about Meenakshi Temple
        // Set formatted text with bold headings about Jagannath Temple
        String aboutText = "<b>About:</b><br/><br/>" +
                "The Jagannath Temple, located in Puri, Odisha, India, is one of the most revered temples dedicated to Lord Jagannath, an incarnation of Lord Vishnu. It is a significant pilgrimage site, especially for followers of the Vaishnavism tradition, and forms part of the Char Dham pilgrimage circuit in India.<br/><br/>" +
                "<b>Location:</b><br/><br/>" +
                "The temple is situated in the coastal town of Puri in Odisha, along the eastern coast of India, near the Bay of Bengal.<br/><br/>" +
                "<b>Architecture:</b><br/><br/>" +
                "The Jagannath Temple is an example of Kalinga architecture, featuring a towering main spire (Shikhara) that rises to about 214 feet. The temple complex is surrounded by a massive fortified wall and includes multiple smaller shrines, with intricate carvings and traditional Oriya architectural elements.<br/><br/>" +
                "<b>Strategic Importance:</b><br/><br/>" +
                "The temple has been a focal point for religious and cultural life in Odisha for centuries. It is strategically built to align with the coastal landscape, symbolizing its importance as a maritime and cultural center in ancient times.<br/><br/>" +
                "<b>Tourism & Tracking:</b><br/><br/>" +
                "The temple attracts millions of devotees and tourists, especially during the annual Rath Yatra (Chariot Festival), where the deities are taken out in grand procession. The temple is a major draw for pilgrims seeking spiritual solace and divine blessings.<br/><br/>" +
                "<b>History:</b><br/><br/>" +
                "Built in the 12th century by King Anantavarman Chodaganga Deva, the temple has a long and storied history, surviving invasions, renovations, and natural disasters. It stands as a testament to Odisha’s enduring religious devotion and rich cultural heritage.";

        // Set the formatted text in the TextView using HtmlCompat for better compatibility
        TextView textView = findViewById(R.id.t1);
        if (textView != null) {
            Spanned formattedText = HtmlCompat.fromHtml(aboutText, HtmlCompat.FROM_HTML_MODE_LEGACY);
            textView.setText(formattedText);
        }
    }
}