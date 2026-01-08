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

public class UdaipurCityPalace extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udaipur_city_palace);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        // Initialize buttons and inputs
        ImageButton contactButton = findViewById(R.id.button);
        ImageButton locationButton = findViewById(R.id.button2);
        EditText imageNumberInput = findViewById(R.id.imageNumberInput);
        Button displayImageButton = findViewById(R.id.displayImageButton);

        // Set up contact button click
        contactButton.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9970104256"));
            startActivity(dialIntent);
        });

        // Set up location button click
        locationButton.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Udaipur City Palace");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

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

        // Set about and history text with HTML formatting
        String aboutText = "<b>About:</b><br/><br/>" +
                "*Udaipur City Palace*" +
                "Located in the city of Udaipur, Rajasthan, India." +
                "An iconic palace complex renowned for its splendid architecture, rich history, and picturesque views over Lake Pichola.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated on the eastern banks of Lake Pichola in Udaipur, Rajasthan." +
                "   - Construction began in 1559 under Maharana Udai Singh II and continued by his successors over 400 years.<br/><br/>" +

                "<b>Unique Features:</b><br/><br/>" +
                "   - A blend of Rajasthani and Mughal architectural styles with intricately designed balconies, towers, and cupolas." +
                "   - Key attractions include the Sheesh Mahal (Palace of Mirrors), Moti Mahal (Palace of Pearls), and Mor Chowk (Peacock Courtyard)." +
                "   - Offers panoramic views of the city, Lake Pichola, and the surrounding Aravalli Hills.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - October to March is the ideal time to explore, with pleasant weather." +
                "   - Visiting in the early morning or late afternoon is recommended to avoid crowds and enjoy stunning sunset views over the lake.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Explore the City Palace Museum, which houses artifacts, royal costumes, and historic paintings." +
                "   - Boat rides on Lake Pichola offer spectacular views of the palace and the iconic Lake Palace." +
                "   - Attend the Mewar Light and Sound Show held in the evening, depicting the history of the Mewar dynasty.<br/><br/>" +

                "<b>Conservation Issues:</b><br/><br/>" +
                "   - Challenges include maintaining the centuries-old structure amidst growing tourism." +
                "   - Efforts are being made to preserve the palace’s artwork and architectural integrity.<br/><br/>" +

                "<b>How to Reach:</b><br/><br/>" +
                "   - Nearest airport: Maharana Pratap Airport, Udaipur (22 km away)." +
                "   - Nearest railway station: Udaipur City Railway Station (3 km away)." +
                "   - Well-connected by road from major cities like Jaipur, Jodhpur, and Ahmedabad.";

        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }


}