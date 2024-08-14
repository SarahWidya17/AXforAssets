package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ItemList2 extends AppCompatActivity {
    public static final String EXTRA_CATEGORY = "category";
    private RecyclerView recyclerView;
    private ItemAdapter2 adapter2;
    private ItemData2 itemData2 = new ItemData2();
    private TextView itemCategoryTv;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list2);

        //back button
        TextView itemCategory = findViewById(R.id.itemCategory);
        itemCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        itemCategoryTv = findViewById(R.id.itemCategory);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        String category = intent.getStringExtra(EXTRA_CATEGORY);

        if (category != null) {
            itemCategoryTv.setText(category);
            // Mengatur adapter berdasarkan kategori
            if (category.equals("Hair")) {
                adapter2 = new ItemAdapter2(itemData2.getHairItems(), this, username);
            } else if (category.equals("Top")) {
                adapter2 = new ItemAdapter2(itemData2.getTopItems(), this, username);
            }else if (category.equals("Bottom")) {
                adapter2 = new ItemAdapter2(itemData2.getBottomItems(), this, username);
            }else if (category.equals("Bag")) {
                adapter2 = new ItemAdapter2(itemData2.getBagItems(), this, username);
            }else if (category.equals("Footwear")) {
                adapter2 = new ItemAdapter2(itemData2.getFootwearItems(), this, username);
            }
            // Set adapter ke RecyclerView
            recyclerView.setAdapter(adapter2);
        }

        ImageView menuButton = findViewById(R.id.menu_button);
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
                Intent intent2 = new Intent(ItemList2.this, HomePage.class);
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
                Intent intent2 = new Intent(ItemList2.this, Profile.class);
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
                Intent intent = new Intent(ItemList2.this, Login.class);
                startActivity(intent);
                finish();
                popupWindow.dismiss();
            }
        });

        // Show the popup menu
        popupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.END, 0, 0);
    }
}