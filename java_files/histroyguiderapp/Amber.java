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

public class Amber extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amber);
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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q= Amber Fort");
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
                "Amber Fort, also known as Amer Fort, is a majestic fort located in Amer, Rajasthan, about 11 kilometers from Jaipur. It is famous for its artistic Hindu architecture and stunning hilltop views. Here’s some detailed information about Amber Fort:<br/><br/>" +

                "<b>1. Historical Significance:</b><br/>" +
                "Construction: Amber Fort was originally built by Raja Man Singh I in 1592 and later expanded by Sawai Jai Singh. The fort served as the residence of the Rajput rulers of Jaipur before they moved to the City Palace in Jaipur.<br/>" +
                "Architecture: The fort is a beautiful blend of Hindu and Mughal architectural styles, with large ramparts, series of gates, and cobbled paths leading to its majestic courtyards and palaces.<br/><br/>" +

                "<b>2. Key Features:</b><br/>" +
                "Sheesh Mahal (Mirror Palace): This is one of the most famous parts of Amber Fort. The walls and ceilings are inlaid with mirrors, which reflect light to illuminate the entire room.<br/>" +
                "Diwan-i-Aam (Hall of Public Audience): A large hall where the king would hear the petitions and grievances of his subjects.<br/>" +
                "Diwan-i-Khas (Hall of Private Audience): A more intimate hall for meetings with dignitaries and special guests.<br/>" +
                "Sukh Niwas (Hall of Pleasure): The walls of this hall are designed with ivory and sandalwood. It had a unique cooling system, with water flowing through channels to cool the room during hot weather.<br/>" +
                "Ganesh Pol: A beautiful gateway adorned with intricate frescoes, this gate leads to the private palaces inside the fort.<br/>" +
                "Jaleb Chowk: This is the main courtyard where the royal family’s soldiers would assemble before marching in processions.<br/><br/>" +

                "<b>3. Cultural Importance:</b><br/>" +
                "UNESCO World Heritage Site: Amber Fort, along with five other forts in Rajasthan, was designated a UNESCO World Heritage Site as part of the 'Hill Forts of Rajasthan' in 2013.<br/>" +
                "Cultural Hub: Amber Fort is known for its light and sound show, which tells the history of the fort and the Jaipur dynasty. It also hosts annual events, such as the Jaipur Literature Festival.<br/><br/>" +

                "<b>4. Visitor Information:</b><br/>" +
                "Location: Amber Fort is located in Amer, around 11 kilometers from Jaipur, Rajasthan, on a hill overlooking Maota Lake.<br/>" +
                "Accessibility: The fort is easily accessible by road from Jaipur. Elephants or jeeps can be used to ascend the fort from the base.<br/>" +
                "Opening Hours: The fort is open from 8:00 AM to 5:30 PM for visitors. There is also a special light and sound show held in the evening.<br/>" +
                "Entry Fee: There is an entry fee for Indian citizens and foreign tourists, with additional charges for elephant rides, camera use, and the light and sound show.<br/><br/>" +

                "<b>5. Best Time to Visit:</b><br/>" +
                "The best time to visit Amber Fort is from October to March, during the cooler months. Summers in Rajasthan can be very hot, making it less ideal for sightseeing.<br/><br/>" +

                "<b>Thank You..!</b><br/><br/>";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}