package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ItemList2 extends AppCompatActivity {
    //nyoba dlu pake data Top
    private RecyclerView recyclerViewTop;
    private ItemAdapter topAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list2);

        recyclerViewTop = findViewById(R.id.recyclerView);

        ItemData itemData = new ItemData();

        topAdapter = new ItemAdapter(itemData.getTopProducts(), this);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerViewTop.setLayoutManager(layoutManager);
        recyclerViewTop.setAdapter(topAdapter);
    }
}