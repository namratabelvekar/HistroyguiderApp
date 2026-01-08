package com.example.histroyguiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class FalaknumaPalace extends AppCompatActivity {
    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falaknuma_palace);

        viewFlipper = findViewById(R.id.viewFlipper);



        // Set up flipping for images
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        // Find buttons by ID
        ImageButton contactButton = findViewById(R.id.button);
        ImageButton locationButton = findViewById(R.id.button2);

        // Set onClickListener for Contact button
        contactButton.setOnClickListener(v -> {
            // Dial the contact number for Falaknuma Palace
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:9970104256")); // Replace with actual number
            startActivity(dialIntent);
        });

        // Set onClickListener for Location button
        locationButton.setOnClickListener(v -> {
            // Open Google Maps with the location of Falaknuma Palace
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Falaknuma Palace, Hyderabad");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

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
                "*Falaknuma Palace*" +
                "Located in Hyderabad, Telangana, India." +
                "A stunning palace known for its opulent design, luxurious interiors, and historical significance as the former residence of the Nizams of Hyderabad.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated on a hilltop in Hyderabad, providing panoramic views of the city." +
                "   - Built in 1894 by Nawab Vikar-ul-Umra, the Prime Minister of Hyderabad, and later owned by the Nizam of Hyderabad.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - The palace is designed in a blend of Italian and Tudor architectural styles, resembling a scorpion from above." +
                "   - Lavish interiors include Venetian chandeliers, grand marble staircases, and an exquisite collection of art and furniture." +
                "   - The library houses a rare collection of manuscripts and books, modeled after the library at Windsor Castle.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the best time to visit due to the pleasant weather." +
                "   - The evening hours are ideal for experiencing the palace’s grandeur under beautiful lighting.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Now operated as a luxury heritage hotel by the Taj Group, offering royal hospitality experiences." +
                "   - Take guided tours of the palace to explore its opulent rooms, grand dining hall, and historical artifacts." +
                "   - Enjoy a royal dining experience at the palace’s restaurants, known for their exquisite Hyderabadi cuisine.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - The palace underwent extensive restoration in the early 2000s to convert it into a luxury hotel while preserving its historical charm." +
                "   - Continuous efforts are needed to maintain its grandeur due to aging and the impact of weather on its structures.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Rajiv Gandhi International Airport, Hyderabad (20 km away)." +
                "   - Nearest railway station: Hyderabad Deccan Railway Station (5 km away)." +
                "   - Well-connected by road with easy access to taxis and local transport.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }

}