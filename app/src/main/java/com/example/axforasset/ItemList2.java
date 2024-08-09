package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        String category = intent.getStringExtra(EXTRA_CATEGORY);

        if (category != null) {
            itemCategoryTv.setText(category);
            // Mengatur adapter berdasarkan kategori
            if (category.equals("Hair")) {
                adapter2 = new ItemAdapter2(itemData2.getHairItems(), this);
            } else if (category.equals("Top")) {
                adapter2 = new ItemAdapter2(itemData2.getTopItems(), this);
            }else if (category.equals("Bottom")) {
                adapter2 = new ItemAdapter2(itemData2.getBottomItems(), this);
            }else if (category.equals("Bag")) {
                adapter2 = new ItemAdapter2(itemData2.getBagItems(), this);
            }else if (category.equals("Footwear")) {
                adapter2 = new ItemAdapter2(itemData2.getFootwearItems(), this);
            }
            // Set adapter ke RecyclerView
            recyclerView.setAdapter(adapter2);
        }

    }
}