package com.example.axforasset;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.ItemViewHolder> {
    private String username;
    private List<Item2> itemList;
    private Context context;

    public ItemAdapter2(List<Item2> itemList, Context context, String username) {
        this.itemList = itemList;
        this.context = context;
        this.username = username;
    }

    @NonNull
    @Override
    public ItemAdapter2.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list2, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter2.ItemViewHolder holder, int position) {
        Item2 item = itemList.get(position);
        holder.itemName.setText(item.getItemName());
        holder.itemDesc.setText(item.getItemDesc());
        holder.itemPhoto.setImageResource(item.getItemPhoto());

        //Lanjutan ke detail page buat ijul (NANTI IJUL UBAH2 AJA DISINI),
        // sama cek DetailActivity.java buat nampilinnya dan activity_detail.xml buat layoutnya
        holder.detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailItem.class);// Send item ID or other data
                intent.putExtra("ITEM_NAME", item.getItemName()); // Send item ID or other data
                intent.putExtra("ITEM_PHOTO", item.getItemPhoto());
                intent.putExtra("ITEM_DESC", item.getItemDesc());
                intent.putExtra("USERNAME", username);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemDesc;
        ImageView itemPhoto;
        Button detailBtn;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            itemDesc = itemView.findViewById(R.id.itemDesc);
            itemPhoto = itemView.findViewById(R.id.itemPhoto);
            detailBtn = itemView.findViewById(R.id.detailBtn);
        }
    }
}
