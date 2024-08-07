package com.example.axforasset;

import java.util.ArrayList;
import java.util.List;

public class ItemData {
    private List<Item> hairItems;
    private List<Item> topItems;
    private List<Item> bottomItems;
    private List<Item> bagItems;
    private List<Item> footwearItems;

    public ItemData(){
        hairItems = new ArrayList<>();
        topItems = new ArrayList<>();
        bottomItems = new ArrayList<>();
        bagItems = new ArrayList<>();
        footwearItems = new ArrayList<>();

        //Hair Items
        hairItems.add(new Item("Long Black Hair", "Make your Barbie shiny", R.drawable.hair_black));
        hairItems.add(new Item("High Blonde Ponytail", "Make your Barbie cutier", R.drawable.hair_highblondeponytail));
        hairItems.add(new Item("Curly Brown Hair", "Make your Barbie stylist", R.drawable.hair_curly));
        hairItems.add(new Item("Long Blonde Hair", "Make your Barbie elegant", R.drawable.hair_longblonde));
        hairItems.add(new Item("Modern Brown Hair", "Make your Barbie more Gen-z", R.drawable.hair_black));

        // Top Items
        topItems.add(new Item("OneSet Cute Top", "Ya lucu pokoknya", R.drawable.top_cuteoneset));
        topItems.add(new Item("Bobby's Man Suit", "Jas buat Bobby si macho", R.drawable.top_bobbysuit));
        topItems.add(new Item("Pink Crop Top", "Stylist dan Modern Top", R.drawable.top_pinkcrop));
        topItems.add(new Item("Green Line OneSet", "Renda hijau sangat kyut", R.drawable.top_greenoneset));
        topItems.add(new Item("Colorful Top", "Warna warni buat Bobby", R.drawable.top_colorful));

        // Bottom Items
        bottomItems.add(new Item("Black Trousers", "Buat Bobby intinya", R.drawable.bottom_1));
        bottomItems.add(new Item("Pinky Skirt", "Feminime and Girly", R.drawable.bottom_2));
        bottomItems.add(new Item("Pinky Shorts", "Stylist and Modern Outfit", R.drawable.bottom_3));
        bottomItems.add(new Item("Big Trousers", "Comfy and Cute", R.drawable.bottom_4));
        bottomItems.add(new Item("Mermaid Skirt", "Very very cute lah", R.drawable.bottom_5));

        // Bag Items
        bagItems.add(new Item("Big Pinky Bag", "For long holiday and vacation", R.drawable.bag_1));
        bagItems.add(new Item("Mini Pink Bag", "Limited Edition", R.drawable.bag_2));
        bagItems.add(new Item("Modern Pink Bag", "Stylist and Modern", R.drawable.bag_3));
        bagItems.add(new Item("Yellow Sling Bag", "Comfortable and Cute", R.drawable.bag_4));
        bagItems.add(new Item("Aqua Picnic Bag", "For picnic", R.drawable.bag_5));

        //Footwear Items
        footwearItems.add(new Item("Purple Heels", "Comfortable and make you feel young", R.drawable.footwear_1));
        footwearItems.add(new Item("Tosca Heels", "Elegant", R.drawable.footwear_2));
        footwearItems.add(new Item("Aqua High Wedges", "Stylist and Modern", R.drawable.footwear_3));
        footwearItems.add(new Item("Boots", "For special ocassion", R.drawable.footwear_4));
        footwearItems.add(new Item("Pinky Heels", "For daily use", R.drawable.footwear_5));

    }

    public List<Item> getHairItems() {
        return hairItems;
    }

    public List<Item> getTopProducts() {
        return topItems;
    }

    public List<Item> getBottomProducts() {
        return bottomItems;
    }

    public List<Item> getBagItems() {
        return bagItems;
    }

    public List<Item> getFootwearItems() {
        return footwearItems;
    }
}
