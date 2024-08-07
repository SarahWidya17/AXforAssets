package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ItemList2 extends AppCompatActivity {
    //nyoba dlu pake data Top
    private RecyclerView recyclerViewTop;
    private ItemAdapter2 topAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list2);

        recyclerViewTop = findViewById(R.id.recyclerView);

        ItemData2 itemData2 = new ItemData2();

        topAdapter = new ItemAdapter2(itemData2.getTopProducts(), this);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerViewTop.setLayoutManager(layoutManager);
        recyclerViewTop.setAdapter(topAdapter);
    }
}