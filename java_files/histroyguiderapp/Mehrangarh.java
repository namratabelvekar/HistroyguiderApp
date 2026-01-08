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

public class Mehrangarh extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehrangarh);
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
            // Open Google Maps with the location of the Fort
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Mehrangarh Fort");
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
                "Mehrangarh Fort is one of the largest and most magnificent forts in India, located in Jodhpur, Rajasthan. The fort stands as a symbol of Rajasthan's grandeur, history, and architectural brilliance. Here’s some detailed information about Mehrangarh Fort:<br/><br/>" +

                "<b>1. Historical Significance:</b><br/>" +
                "Construction: Mehrangarh Fort was built in 1459 by Rao Jodha, the founder of Jodhpur. The fort has been expanded and fortified by subsequent rulers, making it a massive architectural structure.<br/>" +
                "Architecture: The fort is known for its intricate carvings, massive walls, and impressive courtyards. The fort’s architecture reflects the rich history of the Rathore dynasty and combines Rajput and Mughal styles.<br/><br/>" +

                "<b>2. Key Features:</b><br/>" +
                "Seven Gates: The fort has seven gates (Pols), each constructed to commemorate different victories of the rulers, including the famous Jai Pol (Victory Gate) built to celebrate victory over the Mughals.<br/>" +
                "Moti Mahal (Pearl Palace): This is one of the most luxurious and grand palaces within the fort. It served as a throne room and is famous for its intricate ceilings and delicate glasswork.<br/>" +
                "Phool Mahal (Palace of Flowers): Built as a private audience hall, Phool Mahal is adorned with gold and beautifully decorated with paintings.<br/>" +
                "Sheesh Mahal (Mirror Palace): A small but striking room in the fort, featuring mirror work and colored glass inlays on the walls.<br/>" +
                "Chamunda Mataji Temple: This temple is dedicated to the goddess Chamunda, the family deity of the rulers of Jodhpur.<br/>" +
                "Museum: Mehrangarh Fort houses a museum that showcases artifacts from Rajasthan’s royal history, including palanquins, costumes, arms, and paintings.<br/><br/>" +

                "<b>3. Cultural Importance:</b><br/>" +
                "Cultural Hub: Mehrangarh Fort is not just a historical monument but also a cultural hub. It hosts several events and festivals, including the famous Rajasthan International Folk Festival (RIFF) and the World Sacred Spirit Festival.<br/>" +
                "Bollywood and Hollywood Filming Location: The fort has been featured in several films, including Hollywood’s 'The Dark Knight Rises' and Bollywood’s 'Hum Saath Saath Hain.'<br/><br/>" +

                "<b>4. Visitor Information:</b><br/>" +
                "Location: Mehrangarh Fort is located in Jodhpur, Rajasthan, perched on a hill about 400 feet above the city, offering stunning views of the 'Blue City' of Jodhpur.<br/>" +
                "Accessibility: The fort is easily accessible by road and rail. The nearest airport is Jodhpur Airport, located around 6 kilometers from the fort.<br/>" +
                "Opening Hours: The fort is open to visitors from 9:00 AM to 5:00 PM. Visitors are advised to check timings around special events or festivals.<br/>" +
                "Entry Fee: There is an entry fee for Indian citizens and foreign tourists, with additional charges for cameras and guided tours.<br/><br/>" +

                "<b>5. Best Time to Visit:</b><br/>" +
                "The best time to visit Mehrangarh Fort is during the winter months (October to March), when the weather is pleasant for exploring the fort and enjoying the views.<br/><br/>" +

                "<b>Thank You..!</b><br/><br/>";


        // Set the text using Html.fromHtml() to make "About" and "History" bold
        TextView textView = findViewById(t1);
        textView.setText(Html.fromHtml(aboutText, Html.FROM_HTML_MODE_LEGACY));
    }
}