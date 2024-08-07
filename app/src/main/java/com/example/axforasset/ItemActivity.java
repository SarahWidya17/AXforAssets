package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

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
            Intent intent = new Intent(ItemActivity.this, DetailActivity.class);
            intent.putExtra("ITEM_NAME", item.getName());
            startActivity(intent);
        });
        recyclerView.setAdapter(itemsAdapter);

        menuButton.setOnClickListener(v -> showPopupMenu(v));
    }

    private void showPopupMenu(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.menu_lightbox, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                true);

        popupView.findViewById(R.id.menu_items).setOnClickListener(v -> {
            // Handle Items click
            popupWindow.dismiss();
        });
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
