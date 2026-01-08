package com.example.histroyguiderapp;

import static com.example.histroyguiderapp.R.id.button;
import static com.example.histroyguiderapp.R.id.button2;
import static com.example.histroyguiderapp.R.id.t1;

import androidx.appcompat.app.AppCompatActivity;

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

public class Chittorgarth extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittorgarth);
        viewFlipper = findViewById(R.id.viewFlipper);

        // Set up flipping for images
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        // Find buttons by ID
        ImageButton contactButton = findViewById(button);
        ImageButton locationButton = findViewById(button2);

        // Set onClickListener for Contact button
        contactButton.setOnClickListener(v -> {
            // Dial the contact number
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:9970104256"));
            startActivity(dialIntent);
        });

        // Set onClickListener for Location button
        locationButton.setOnClickListener(v -> {
            // Open Google Maps with the location of the  Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Chittorgarth Fort");
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
                if (imageNumber >= 1 && imageNumber <= 10) {
                    // Display the image based on the entered number
                    viewFlipper.setDisplayedChild(imageNumber - 1);

                    // Create a Handler to show the image for 5 seconds
                    // new Handler().postDelayed(() -> {
                    // After 5 seconds, start flipping again
                    //viewFlipper.startFlipping();
                    // }, 5000); // 5000 milliseconds = 5 seconds
                } else {
                    // Handle invalid input (e.g., out of range)
                    imageNumberInput.setError("Enter a valid image number between 1 and 10");
                }
            }
        });


        // Format and set text with bold "About" and "History"
        String aboutText = "<b>About:</b><br/><br/>" +
                "Chittorgarh Fort is one of the largest forts in India, located in the city of Chittorgarh in the state of Rajasthan. It is a symbol of Rajput valor, pride, and history. Here’s some detailed information about the Chittorgarh Fort:<br/><br/>" +

                "<b>1. Historical Significance:</b><br/>" +
                "Construction: The Chittorgarh Fort was built in the 7th century by the Maurya dynasty, and it served as the capital of Mewar. It has witnessed numerous battles, especially against the Mughal invaders.<br/>" +
                "Architecture: Spread over 700 acres, the fort encompasses several palaces, temples, towers, and reservoirs. The architecture reflects a combination of Rajput style with stunning craftsmanship.<br/><br/>" +

                "<b>2. Key Features:</b><br/>" +
                "Victory Tower (Vijay Stambh): This towering structure was built by Rana Kumbha to commemorate his victory over Mahmud Khilji. It stands tall as a symbol of Rajput pride.<br/>" +
                "Kirti Stambh: Also known as the Tower of Fame, this Jain monument is dedicated to the first Jain Tirthankara, Rishabha.<br/>" +
                "Rani Padmini's Palace: This palace is associated with the legendary Rajput queen, Rani Padmini, known for her beauty and valor. It overlooks a lotus pool where she was said to have met the ruler Alauddin Khilji in a reflection.<br/>" +
                "Gaumukh Reservoir: A large tank within the fort that has water flowing from a rock shaped like a cow’s mouth, providing the fort with a natural water supply.<br/>" +
                "Temples: The fort houses several Hindu and Jain temples, with the Meera Temple being particularly famous for its association with the poet-saint Meera Bai.<br/><br/>" +

                "<b>3. Cultural Importance:</b><br/>" +
                "UNESCO World Heritage Site: The Chittorgarh Fort was designated a UNESCO World Heritage Site as part of the group 'Hill Forts of Rajasthan' in 2013.<br/>" +
                "Symbol of Rajput Bravery: The fort is known for its history of epic battles and acts of heroism, including three major sieges where Rajput warriors fought to the death, and the women performed Jauhar to avoid capture.<br/><br/>" +

                "<b>4. Visitor Information:</b><br/>" +
                "Location: The Chittorgarh Fort is located on a hill near the Berach River, in Chittorgarh, Rajasthan. The fort sits around 590 feet (180 meters) above the surrounding plains.<br/>" +
                "Accessibility: The fort is accessible by road and rail. The nearest airport is Maharana Pratap Airport in Udaipur, which is about 90 kilometers from Chittorgarh.<br/>" +
                "Opening Hours: The fort is open to visitors from sunrise to sunset, with certain sections like the Victory Tower having specific visiting hours.<br/>" +
                "Entry Fee: There is an entry fee for Indian citizens and a different fee for foreign tourists. Charges apply for cameras and photography.<br/><br/>" +

                "<b>5. Best Time to Visit:</b><br/>" +
                "The best time to visit Chittorgarh Fort is during the cooler months from October to March. Avoid visiting in the peak summer season, as temperatures can be quite high.<br/><br/>" +

                "<b>Thank You..!</b><br/><br/>";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}