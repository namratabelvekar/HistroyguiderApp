package com.example.histroyguiderapp;

import static com.example.histroyguiderapp.R.id.*;

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

public class Red_fort extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_fort);

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
            // Open Google Maps with the location of the Red Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Red Fort");
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
                "Red Fort (Lal Qila) is a historic fort located in the city of Delhi, India. It is an iconic symbol of India's rich history and culture. Here’s some detailed information about the Red Fort:<br/><br/>" +

                "<b>1. Historical Significance:</b><br/>" +
                "Construction: The Red Fort was commissioned by the Mughal Emperor Shah Jahan in 1638 and completed in 1648. It was built as the palace for his new capital, Shahjahanabad, which is now part of Old Delhi.<br/>" +
                "Architecture: The fort is constructed primarily of red sandstone, which gives it its name. It combines Persian, Timurid, and Indian architectural styles, showcasing intricate carvings, beautiful gardens, and grand structures.<br/><br/>" +

                "<b>2. Key Features:</b><br/>" +
                "Main Gate: The primary entrance to the fort is the Lahori Gate, which faces the city of Lahore (now in Pakistan).<br/>" +
                "Mumtaz Mahal: This was the palace of Shah Jahan's wife, Mumtaz Mahal. It now houses a museum displaying artifacts from the Mughal era.<br/>" +
                "Diwan-i-Aam (Hall of Public Audience): This is where the emperor would address the public and listen to their grievances.<br/>" +
                "Diwan-i-Khas (Hall of Private Audience): This hall was used for private meetings with courtiers and dignitaries.<br/>" +
                "The Pearl Mosque (Moti Masjid): Built in white marble, this mosque is located within the fort and is a beautiful example of Mughal architecture.<br/>" +
                "Gardens: The fort features beautiful gardens, which were designed in the Persian style.<br/><br/>" +

                "<b>3. Cultural Importance:</b><br/>" +
                "UNESCO World Heritage Site: The Red Fort was designated a UNESCO World Heritage Site in 2007 for its historical significance and architectural beauty.<br/>" +
                "Independence Day Celebrations: The fort is an important symbol of India’s independence. Every year on August 15, the Prime Minister of India hoists the national flag from the fort’s ramparts to commemorate Independence Day.<br/><br/>" +

                "<b>4. Visitor Information:</b><br/>" +
                "Location: The Red Fort is located in the heart of Delhi and is easily accessible by public transport, including the Delhi Metro.<br/>" +
                "Opening Hours: The fort is open to visitors from sunrise to sunset. It is advisable to check for any special events or timings, especially around national holidays.<br/>" +
                "Entry Fee: There is an entry fee for Indian citizens and a different fee for foreign tourists. There are also charges for photography.<br/><br/>" +

                "<b>5. Best Time to Visit:</b><br/>" +
                "The best time to visit the Red Fort is during the winter months (October to March) when the weather is cooler and more pleasant.<br/><br/>" +

                "<b>Thank You..!</b><br/><br/>";

        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}
