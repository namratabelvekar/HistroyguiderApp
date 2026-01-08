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

public class Gir extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gir);

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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Gir Sanctuary");
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
                "*Gir National Park and Wildlife Sanctuary*<br/><br/>" +
                "Location: Spanning the Junagadh, Gir Somnath, and Amreli districts of Gujarat, India." +
                " Gir Sanctuary is renowned as the only natural habitat of the *Asiatic lions*, making it one of the most significant wildlife conservation areas in India.<br/><br/>" +

                "<b>Key Highlights:</b><br/><br/>" +

                "<b>Location:</b><br/><br/>" +
                "   - Covers an area of 1,412 sq. km, including the core Gir National Park and the surrounding sanctuary." +
                "   - Situated approximately 55 km from Junagadh and 160 km from Rajkot, making it easily accessible for tourists.<br/><br/>" +

                "<b>Flora:</b><br/><br/>" +
                "   - Gir features a deciduous forest with prominent trees like teak, acacia, and banyan." +
                "   - The landscape includes patches of grasslands, scrub forests, and perennial rivers, providing diverse habitats.<br/><br/>" +

                "<b>Fauna:</b><br/><br/>" +
                "   - Home to the majestic *Asiatic lions*, as well as other large mammals like leopards, sambar deer, wild boars, and four-horned antelopes." +
                "   - The Kamleshwar Dam area is known for its thriving crocodile population.<br/><br/>" +

                "<b>Birdlife:</b><br/><br/>" +
                "   - Over 300 species of birds can be found here, including eagles, vultures, and owls." +
                "   - The park is a paradise for birdwatchers, with diverse avian species throughout the year.<br/><br/>" +

                "<b>Conservation:</b><br/><br/>" +
                "   - Conservation efforts have successfully increased the Asiatic lion population from around 20 in the early 1900s to over 674 as of 2020." +
                "   - The park focuses on protecting the entire ecosystem, ensuring the survival of not only lions but also other flora and fauna.<br/><br/>" +

                "<b>Tourism:</b><br/><br/>" +
                "   - The park offers jeep safaris, allowing tourists to experience close encounters with lions and other wildlife." +
                "   - Open from mid-October to mid-June, with the best time to visit between November and February for optimal wildlife sightings.<br/><br/>" +

                "<b>Conservation and Local Communities:</b><br/><br/>" +
                "   - Efforts include reducing human-wildlife conflict, especially with the *Maldhari* tribe, who have traditionally lived within the Gir region." +
                "   - Community engagement and sustainable tourism play a crucial role in conservation efforts.<br/><br/>" +

                "<b>Access and Accommodation:</b><br/><br/>" +
                "   - Well-connected to major cities like Junagadh and Rajkot via road and rail." +
                "   - A range of accommodations, including lodges, guesthouses, and eco-resorts, are available near the park, providing a comfortable stay for visitors.";
        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(R.id.t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}