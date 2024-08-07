package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView itemNameTextView = findViewById(R.id.item_name);

        // Get the item name from the intent
        String itemName = getIntent().getStringExtra("ITEM_NAME");
        if (itemName != null) {
            itemNameTextView.setText(itemName);
        }
    }
}
