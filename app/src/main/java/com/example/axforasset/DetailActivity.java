package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //ini nyari id yang ada di detail.xml biar bisa ditampilin
        TextView itemNameTextView = findViewById(R.id.item_name);
        ImageView itemPhotoiv = findViewById(R.id.item_photo);

        // Get the item from the intent
        String itemName = getIntent().getStringExtra("ITEM_NAME");
        if (itemName != null) {
            itemNameTextView.setText(itemName);
            itemNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        int itemPhoto = getIntent().getIntExtra("ITEM_PHOTO", -1);
        itemPhotoiv.setImageResource(itemPhoto);
    }
}
