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

public class Kutch extends AppCompatActivity
{
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kutch);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Kutch Sanctuary");
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
                "*Kutch Desert Wildlife Sanctuary*<br/><br/>" +
                "Location: Situated in the Great Rann of Kutch, Gujarat, India. It is one of the largest wildlife sanctuaries in India, " +
                "famous for its unique salt marshes and desert landscape.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Located in the Great Rann of Kutch, Gujarat.<br/>" +
                "   - Encompasses an area of approximately 7,505 square kilometers.<br/><br/>" +

                "<b>Flora:</b><br/><br/>" +
                "   - The sanctuary primarily consists of saline desert and scrubland.<br/>" +
                "   - During the monsoon season, certain areas transform into wetlands, supporting diverse flora.<br/><br/>" +

                "<b>Fauna:</b><br/><br/>" +
                "   - Known for its population of the Indian wild ass.<br/>" +
                "   - Other wildlife includes flamingos, pelicans, cranes, chinkara, blackbuck, and desert foxes.<br/>" +
                "   - It is a major breeding ground for the Greater and Lesser Flamingos, earning the name 'Flamingo City'.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The salt flats of the Rann of Kutch create a striking white desert landscape, offering surreal beauty.<br/>" +
                "   - 'Flamingo City' is one of the largest flamingo breeding colonies in the world.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The best time to visit is between October and March.<br/>" +
                "   - Winter is ideal for birdwatching and viewing migratory birds.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Famous for birdwatching, especially during the winter migratory season.<br/>" +
                "   - The renowned 'Rann Utsav' cultural festival is held annually, showcasing local culture, arts, and crafts.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The sanctuary faces challenges like habitat degradation due to human encroachment and overgrazing.<br/>" +
                "   - Climate change impacts water availability, which affects bird migration patterns.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Bhuj (100 km away).<br/>" +
                "   - Nearest railway station: Bhuj.<br/>" +
                "   - Well-connected by road from Bhuj and other parts of Gujarat.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}