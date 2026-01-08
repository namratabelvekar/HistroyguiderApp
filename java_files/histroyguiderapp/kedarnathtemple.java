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

public class kedarnathtemple extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedarnathtemple);
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
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Kedarnath Temple");
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
                                imageNumberInput.setError("Enter a valid image number between 1 and 5");
                            }
                        }
                    } catch (NumberFormatException e) {
                        imageNumberInput.setError("Invalid number");
                    }
                }
            });
        }

        // Set formatted text with bold headings about Meenakshi Temple
        // Set formatted text with bold headings about Kedarnath Temple
        String aboutText = "<b>About:</b><br/><br/>" +
                "The Kedarnath Temple, located in Uttarakhand, India, is one of the most sacred temples dedicated to Lord Shiva. It is one of the twelve Jyotirlingas and holds immense religious significance for Hindus. The temple is surrounded by the majestic Himalayan ranges and is part of the Char Dham pilgrimage circuit.<br/><br/>" +
                "<b>Location:</b><br/><br/>" +
                "The temple is situated near the Mandakini River in the Garhwal region of Uttarakhand, at an altitude of about 3,583 meters (11,755 feet) above sea level.<br/><br/>" +
                "<b>Architecture:</b><br/><br/>" +
                "The Kedarnath Temple is built in a traditional North Indian architectural style, featuring a stone structure made from large, heavy blocks. The temple’s design is simple yet robust, with a tall, pointed spire and intricately carved mandap (pillared hall). It is believed to have been constructed using interlocking stones to withstand the harsh weather conditions.<br/><br/>" +
                "<b>Strategic Importance:</b><br/><br/>" +
                "The temple is strategically located at the head of the Mandakini Valley, surrounded by snow-capped peaks, symbolizing the divine presence of Lord Shiva amidst nature’s grandeur. The temple's location makes it both spiritually and geographically significant.<br/><br/>" +
                "<b>Tourism & Tracking:</b><br/><br/>" +
                "The Kedarnath Temple attracts thousands of devotees and trekkers each year, particularly during the Char Dham Yatra season. Due to its high-altitude location, it is accessible only by trekking or helicopter services, especially after the devastating 2013 floods. The journey to the temple is both challenging and spiritually fulfilling.<br/><br/>" +
                "<b>History:</b><br/><br/>" +
                "The temple is believed to have been originally built by the Pandavas during the Mahabharata era and later restored by Adi Shankaracharya in the 8th century. Despite the temple enduring multiple natural calamities, including the 2013 floods, it has remained a symbol of unwavering faith and resilience.";

        // Set the formatted text in the TextView using HtmlCompat for better compatibility
        TextView textView = findViewById(R.id.t1);
        if (textView != null) {
            Spanned formattedText = HtmlCompat.fromHtml(aboutText, HtmlCompat.FROM_HTML_MODE_LEGACY);
            textView.setText(formattedText);
        }
    }
}