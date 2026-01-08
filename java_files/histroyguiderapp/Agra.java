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

public class Agra extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agra);
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
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Agra Fort");
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
                "Agra Fort is a UNESCO World Heritage Site and one of the most important historical landmarks in India, located in Agra, Uttar Pradesh. This magnificent fort showcases the grandeur of Mughal architecture and was a key residence of Mughal emperors. Here’s some detailed information about Agra Fort:<br/><br/>" +

                "<b>1. Historical Significance:</b><br/>" +
                "Construction: Agra Fort was originally built in the 11th century as a brick fort by the Rajputs, but it was extensively rebuilt in red sandstone by Mughal Emperor Akbar between 1565 and 1573.<br/>" +
                "Architecture: The fort is a blend of Islamic and Hindu architectural styles, with grand courtyards, intricate palaces, and majestic gates. It served as a military base, palace, and administrative center for the Mughals.<br/><br/>" +

                "<b>2. Key Features:</b><br/>" +
                "Amar Singh Gate: The main entrance to the fort, originally built to confuse attackers with its sharp 90-degree turn.<br/>" +
                "Jahangir Mahal: A beautiful palace built by Akbar for his son, Jahangir. It is known for its blend of Hindu and Central Asian architectural styles.<br/>" +
                "Diwan-i-Aam (Hall of Public Audience): This is where the emperor would meet the general public and hear their grievances.<br/>" +
                "Diwan-i-Khas (Hall of Private Audience): A hall for private meetings with courtiers and dignitaries, showcasing delicate white marble work.<br/>" +
                "Khas Mahal: A stunning white marble palace that was the private residence of Emperor Shah Jahan. It offers beautiful views of the Yamuna River and the Taj Mahal.<br/>" +
                "Moti Masjid (Pearl Mosque): Built by Shah Jahan, this mosque is known for its elegant white marble structure and serene ambiance.<br/><br/>" +

                "<b>3. Cultural Importance:</b><br/>" +
                "UNESCO World Heritage Site: Agra Fort was recognized as a UNESCO World Heritage Site in 1983 due to its historical significance and remarkable architecture.<br/>" +
                "Association with Taj Mahal: Agra Fort holds cultural importance because it is closely linked with the construction of the Taj Mahal. Emperor Shah Jahan was imprisoned here by his son Aurangzeb and spent his final years looking at the Taj Mahal from the fort.<br/><br/>" +

                "<b>4. Visitor Information:</b><br/>" +
                "Location: Agra Fort is located on the banks of the Yamuna River in Agra, Uttar Pradesh, just 2.5 kilometers from the famous Taj Mahal.<br/>" +
                "Accessibility: The fort is easily accessible by road and is close to Agra’s main railway station. The nearest airport is the Agra Airport.<br/>" +
                "Opening Hours: The fort is open to visitors from sunrise to sunset. Visitors should check for any special timings during national holidays or special events.<br/>" +
                "Entry Fee: There is an entry fee for Indian citizens and foreign tourists, with additional charges for photography and guided tours.<br/><br/>" +

                "<b>5. Best Time to Visit:</b><br/>" +
                "The best time to visit Agra Fort is from October to March when the weather is cooler and more comfortable for exploring. Avoid visiting in the summer months as the heat can be intense.<br/><br/>" +

                "<b>Thank You..!</b><br/><br/>";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}