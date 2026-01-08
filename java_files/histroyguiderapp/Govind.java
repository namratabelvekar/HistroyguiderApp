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

public class Govind extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govind);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Govind Sanctuary");
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
                "*Govind Pashu Vihar National Park and Wildlife Sanctuary*<br/><br/>" +
                "Location: Situated in the Uttarkashi district of Uttarakhand, India. " +
                "It is renowned for its stunning landscapes and rich biodiversity, particularly for being a sanctuary for the endangered snow leopard.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Located in the Garhwal Himalayas, with altitudes ranging from 1,300 meters to 6,323 meters." +
                "   - Close to the Har Ki Doon Valley, a popular destination for trekking enthusiasts.<br/><br/>" +

                "<b>Establishment and Area:</b><br/><br/>" +
                "   - Originally established as a wildlife sanctuary in 1955 and later declared a national park in 1990." +
                "   - Encompasses an area of approximately 958 square kilometers.<br/><br/>" +

                "<b>Flora:</b><br/><br/>" +
                "   - The park showcases a diverse range of vegetation, from temperate forests to alpine meadows." +
                "   - Notable flora includes oak, pine, deodar forests, as well as numerous medicinal plants.<br/><br/>" +

                "<b>Fauna:</b><br/><br/>" +
                "   - Hosts endangered species like snow leopards and Himalayan black bears." +
                "   - Other wildlife includes musk deer, blue sheep (bharal), and Himalayan tahr." +
                "   - The park is home to over 150 bird species, such as the Himalayan monal and golden eagles.<br/><br/>" +

                "<b>Conservation Efforts:</b><br/><br/>" +
                "   - Govind Sanctuary plays a vital role in snow leopard conservation as part of India's Project Snow Leopard." +
                "   - Integrated into the larger Nanda Devi Biosphere Reserve, which is a UNESCO World Heritage Site.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Famous for trekking (like Har Ki Doon and Ruinsara Tal treks), birdwatching, and wildlife photography." +
                "   - Offers breathtaking views of the Swargarohini Peaks.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal seasons are from April to June and September to November, providing clear skies and abundant wildlife." +
                "   - Winters are not recommended due to heavy snowfall and harsh weather conditions.<br/><br/>" +

                "<b>Nearby Attractions:</b><br/><br/>" +
                "   - Close proximity to Gangotri National Park and the Char Dham pilgrimage routes, including Yamunotri and Gangotri.<br/><br/>" +

                "<b>Access and Accommodation:</b><br/><br/>" +
                "   - Nearest airport: Jolly Grant Airport, Dehradun (200 km away)." +
                "   - Nearest railway station: Dehradun (approximately 180 km away)." +
                "   - Various accommodations are available in Uttarkashi, ranging from guesthouses to eco-friendly lodges.";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}