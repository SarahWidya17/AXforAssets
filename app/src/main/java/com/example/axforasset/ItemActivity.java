package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemsAdapter itemsAdapter;
    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main);

        recyclerView = findViewById(R.id.recycler_view_studios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuButton = findViewById(R.id.menu_button);

        itemsAdapter = new ItemsAdapter(getItems(), item -> {
            Intent intent = new Intent(ItemActivity.this, ItemList2.class);
            intent.putExtra(ItemList2.EXTRA_CATEGORY, item.getName());
            startActivity(intent);
        });
        recyclerView.setAdapter(itemsAdapter);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.menu_lightbox_2, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                true);

        // Setting up click listeners for menu items
        popupView.findViewById(R.id.menu_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(ItemActivity.this, HomePage.class);
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
                Intent intent2 = new Intent(ItemActivity.this, Profile.class);
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
                Intent intent = new Intent(ItemActivity.this, Login.class);
                startActivity(intent);
                finish();
                popupWindow.dismiss();
            }
        });

        // Show the popup menu
        popupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.END, 0, 0);
    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Hair", R.drawable.hair));
        items.add(new Item("Top", R.drawable.top));
        items.add(new Item("Bottom", R.drawable.bottom));
        items.add(new Item("Bag", R.drawable.bag));
        items.add(new Item("Footwear", R.drawable.footwear));

        return items;
    }
}
