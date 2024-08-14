package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView UserName, emailText, greetingText;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UserName = findViewById(R.id.nameText);
        emailText = findViewById(R.id.email_Text);
        greetingText = findViewById(R.id.greetingMsg);
        logoutBtn = findViewById(R.id.logoutBtn);
        ImageView menuButton = findViewById(R.id.menu_button);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("USERNAME");
        if (nama != null) {
            UserName.setText(nama);
            greetingText.setText("Hi, " + nama + "!");
            UserName.setText(nama + " Heimer");
            emailText.setText(nama + "@gmail.com");
        }

        // Set up the click listener for the logout button
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate back to the login activity
                Intent loginIntent = new Intent(Profile.this, Login.class);
                startActivity(loginIntent);
                // Finish the current activity so it won't be accessible when the back button is pressed
                finish();
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
        View popupView = inflater.inflate(R.layout.menu_lightbox_3, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                true);

        popupView.findViewById(R.id.menu_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(Profile.this, HomePage.class);
                intent2.putExtra("USERNAME", username);
                startActivity(intent2);
//                Intent intent = new Intent(ItemActivity.this, HomePage.class);
//                startActivity(intent);
                popupWindow.dismiss();
            }
        });

        // Setting up click listeners for menu items
        popupView.findViewById(R.id.menu_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(Profile.this, ItemActivity.class);
                intent2.putExtra("USERNAME", username);
                startActivity(intent2);
//                Intent intent = new Intent(ItemActivity.this, HomePage.class);
//                startActivity(intent);
                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(Profile.this, Profile.class);
                intent2.putExtra("USERNAME", username);
                startActivity(intent2);
//                Intent intent = new Intent(ItemActivity.this, Profile.class);
//                startActivity(intent);
                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Logout click
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
                finish();
                popupWindow.dismiss();
            }
        });

        // Show the popup menu
        popupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.END, 0, 0);
    }
}
