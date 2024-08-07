package com.example.axforasset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.ItemViewHolder> {
    private List<Item2> itemList;
    private Context context;

    public ItemAdapter2(List<Item2> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemDesc;
        ImageView itemPhoto;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            itemDesc = itemView.findViewById(R.id.itemDesc);
            itemPhoto = itemView.findViewById(R.id.itemPhoto);
        }
    }
}
