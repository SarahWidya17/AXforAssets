package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView UserName, emailText, greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UserName = findViewById(R.id.nameText);
        emailText = findViewById(R.id.email_Text);
        greetingText = findViewById(R.id.greetingMsg);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("USERNAME");
        if (nama != null) {
            UserName.setText(nama);
            greetingText.setText("Hi, " + nama + "!");
            UserName.setText(nama + " Heimer");
            emailText.setText(nama + "@gmail.com");
        }


    }


}