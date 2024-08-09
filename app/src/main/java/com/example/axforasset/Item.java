package com.example.axforasset;

public class Item {
    private String name;
    private int imageResourceId;

    public Item(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
