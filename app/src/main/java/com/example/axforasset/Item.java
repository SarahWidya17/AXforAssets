package com.example.axforasset;

public class Item {
    private String itemName;
    private String itemDesc;
    private int itemPhoto;

    public Item(String itemName, String itemDesc, int itemPhoto) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPhoto = itemPhoto;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public int getItemPhoto() {
        return itemPhoto;
    }
}
