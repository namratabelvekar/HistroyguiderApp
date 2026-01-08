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

public class Bhartpur extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhartpur);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Bhartpur Sanctuary");
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
                "*Bharatpur Bird Sanctuary (Keoladeo National Park)*<br/><br/>" +
                "Located in the town of Bharatpur, Rajasthan, India." +
                " Known for its incredible avian biodiversity, Keoladeo National Park is a UNESCO World Heritage Site and one of the world's most significant bird sanctuaries.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Situated 55 km west of Agra and about 180 km from Delhi, making it easily accessible for tourists." +
                "   - The park covers an area of approximately 29 square kilometers.<br/><br/>" +

                "<b>Historical Background:</b><br/><br/>" +
                "   - Originally created as a duck hunting reserve by the Maharajas of Bharatpur in the 19th century." +
                "   - Declared a national park in 1982 and designated as a UNESCO World Heritage Site in 1985 for its ecological importance.<br/><br/>" +

                "<b>Biodiversity and Wildlife:</b><br/><br/>" +
                "   - The park is home to over 370 species of birds, especially during winter migration season." +
                "   - Famous for migratory birds such as Siberian Cranes, Pelicans, and Flamingos." +
                "   - Other wildlife includes mammals like sambar deer, nilgai (blue bull), jackals, and reptiles such as monitor lizards.<br/><br/>" +

                "<b>Keoladeo Wetlands:</b><br/><br/>" +
                "   - The park’s core ecosystem consists of wetlands fed by rainwater and the Gambhir River." +
                "   - Seasonal pools and marshes make it an ideal habitat for resident and migratory birds.<br/><br/>" +

                "<b>Tourism and Activities:</b><br/><br/>" +
                "   - Popular for birdwatching, especially during the migratory bird season (October to March)." +
                "   - Visitors can explore the park through guided tours, bicycle rides, and walking trails." +
                "   - The Keoladeo Temple inside the park is an added attraction for visitors.<br/><br/>" +

                "<b>Best Time to Visit:</b><br/><br/>" +
                "   - The ideal time to visit is from October to March, when migratory birds are in abundance." +
                "   - The monsoon season (July to September) brings lush greenery and attracts local bird species.<br/><br/>" +

                "<b>Conservation Efforts:</b><br/><br/>" +
                "   - Conservation challenges include water scarcity, invasive species, and human encroachment." +
                "   - Continuous efforts by the government and wildlife organizations focus on preserving the park's ecosystem.<br/><br/>" +

                "<b>UNESCO World Heritage Status:</b><br/><br/>" +
                "   - Keoladeo National Park was designated as a UNESCO World Heritage Site in 1985 for its ecological significance and efforts in bird conservation." +
                "   - Recognized for its role in sustaining large populations of migratory birds.<br/><br/>" +

                "<b>Access and Accommodation:</b><br/><br/>" +
                "   - Bharatpur is well-connected by road, rail, and air." +
                "   - Accommodations include guesthouses, eco-friendly resorts, and hotels near the park, providing a comfortable stay for visitors.";
        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}