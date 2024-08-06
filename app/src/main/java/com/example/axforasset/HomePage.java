package com.example.axforasset;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomePage extends AppCompatActivity {
    
    private TextView welcomeText, termsText;
    private Button tabTerms, tabConditions;
    private ViewFlipper carousel;
    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        welcomeText = findViewById(R.id.welcome_text);
        termsText = findViewById(R.id.terms_text);
        tabTerms = findViewById(R.id.tab_terms);
        tabConditions = findViewById(R.id.tab_conditions);
        menuButton = findViewById(R.id.menu_button);

        carousel = findViewById(R.id.carousel);
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
        for (int image : images) {
            ImageView imageObj = new ImageView(this);
            imageObj.setBackgroundResource(image);
            carousel.addView(imageObj);
            carousel.setFlipInterval(3000);
            carousel.setAutoStart(true);
            carousel.setInAnimation(this, android.R.anim.slide_in_left);
            carousel.setOutAnimation(this, android.R.anim.slide_out_right);
        }

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        if (username != null) {
            welcomeText.setText("Welcome, " + username);
        }

        tabTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("asd"); // Replace with your terms text
            }
        });

        tabConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("..."); // Replace with your conditions text
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.menu_lightbox, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                true);

        // Setting up click listeners for menu items
        popupView.findViewById(R.id.menu_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Items click
                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Profile click
                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Logout click
                Intent intent = new Intent(HomePage.this, Login.class);
                startActivity(intent);
                finish();
                popupWindow.dismiss();
            }
        });

        // Show the popup menu
        popupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.END, 0, 0);
    }
}
