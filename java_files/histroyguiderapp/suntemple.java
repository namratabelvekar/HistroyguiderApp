package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class suntemple extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @SuppressLint({"SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suntemple);

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
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Sun Temple Konark");
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

        // Set formatted text with bold headings about Sun Temple
        String aboutText = "<b>About:</b><br/><br/>" +
                "The Sun Temple of Konark, located in Odisha, India, is one of the most famous and grand temples dedicated to the Sun God. It is renowned for its architectural brilliance and historical significance.<br/><br/>" +
                "<b>Location:</b><br/><br/>" +
                "The Sun Temple is situated near the coast of the Bay of Bengal in Konark, Odisha.<br/><br/>" +
                "<b>Architecture:</b><br/><br/>" +
                "The temple is designed in the shape of a colossal chariot with intricately carved stone wheels, pillars, and walls. It exemplifies the Kalinga style of architecture.<br/><br/>" +
                "<b>Strategic Importance:</b><br/><br/>" +
                "The temple was strategically built to capture the first rays of the rising sun, symbolizing the Sun God's chariot journeying across the sky.<br/><br/>" +
                "<b>Tourism & Tracking:</b><br/><br/>" +
                "The temple attracts numerous visitors, scholars, and tourists every year, making it a UNESCO World Heritage Site.<br/><br/>" +
                "<b>History:</b><br/><br/>" +
                "Built in the 13th century by King Narasimhadeva I, the temple has faced the test of time and stands as a testament to India's rich heritage.";

        // Set the formatted text in the TextView using HtmlCompat for better compatibility
        TextView textView = findViewById(R.id.t1);
        if (textView != null) {
            Spanned formattedText = HtmlCompat.fromHtml(aboutText, HtmlCompat.FROM_HTML_MODE_LEGACY);
            textView.setText(formattedText);
        }
    }
}


