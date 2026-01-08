package com.example.histroyguiderapp;

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
import androidx.appcompat.app.AppCompatActivity;

import com.example.histroyguiderapp.R;

public class Somnathtemple extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somnathtemple);

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
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Somnath Temple");
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

        // Set formatted text with bold headings
        String aboutText = "<b>About:</b><br/><br/>" +
                "The Somnath Temple, located in Gujarat, India, is one of the most sacred pilgrimage sites for Hindus. It is famous for its rich history and spiritual significance.<br/><br/>" +
                "<b>Location:</b><br/><br/>" +
                "Situated on the western coast of Gujarat, the Somnath Temple overlooks the Arabian Sea.<br/><br/>" +
                "<b>Architecture:</b><br/><br/>" +
                "The temple is designed in the Chalukya style of architecture with intricate carvings and sculptures.<br/><br/>" +
                "<b>Strategic Importance:</b><br/><br/>" +
                "Historically, it has been a symbol of resilience against invasions.<br/><br/>" +
                "<b>Tourism & Tracking:</b><br/><br/>" +
                "It attracts millions of devotees and tourists every year.<br/><br/>" +
                "<b>History:</b><br/><br/>" +
                "The temple has been destroyed and rebuilt several times. The current structure was reconstructed in 1951.";

        // Set the formatted text in the TextView
        TextView textView = findViewById(R.id.t1);
        if (textView != null) {
            textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
        }
    }
}
