package com.example.histroyguiderapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class meenakshitemple extends AppCompatActivity
{
    private ViewFlipper viewFlipper;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meenakshitemple);

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
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Meenakshi Temple");
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
        String aboutText = "<b>About:</b><br/><br/>" +
                "The Meenakshi Temple, located in Madurai, Tamil Nadu, India, is one of the most iconic temples in the country. It is dedicated to Goddess Meenakshi (a form of Parvati) and her consort, Lord Sundareswarar (a form of Shiva). The temple is a significant symbol of Tamil culture and heritage.<br/><br/>" +
                "<b>Location:</b><br/><br/>" +
                "The Meenakshi Temple is situated in the heart of the city of Madurai, in the southern state of Tamil Nadu, India.<br/><br/>" +
                "<b>Architecture:</b><br/><br/>" +
                "This temple is renowned for its stunning Dravidian architecture, featuring towering gopurams (gateway towers) covered with intricate carvings, colorful sculptures, and stunningly detailed art. It has a sprawling complex with 14 gopurams, the tallest being about 170 feet high.<br/><br/>" +
                "<b>Strategic Importance:</b><br/><br/>" +
                "The temple has been a cultural and religious center for centuries, symbolizing the power of Tamil dynasties. It was strategically built to serve as a focal point of worship, commerce, and social gatherings in the ancient city of Madurai.<br/><br/>" +
                "<b>Tourism & Tracking:</b><br/><br/>" +
                "The temple attracts millions of pilgrims, tourists, and art enthusiasts each year. It is known for its grand festivals, especially the Meenakshi Thirukalyanam (divine marriage) during the Chithirai Festival, which draws huge crowds.<br/><br/>" +
                "<b>History:</b><br/><br/>" +
                "The temple's origins date back to the 6th century, but the current structure was significantly expanded during the reign of the Nayak dynasty in the 16th century, particularly under King Tirumala Nayak. The temple has withstood centuries of invasions, renovations, and remains a symbol of Tamil pride.";

        // Set the formatted text in the TextView using HtmlCompat for better compatibility
        TextView textView = findViewById(R.id.t1);
        if (textView != null) {
            Spanned formattedText = HtmlCompat.fromHtml(aboutText, HtmlCompat.FROM_HTML_MODE_LEGACY);
            textView.setText(formattedText);
        }
    }
}