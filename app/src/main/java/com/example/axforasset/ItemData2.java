package com.example.axforasset;

import java.util.ArrayList;
import java.util.List;

public class ItemData2 {
    private List<Item2> hairItems;
    private List<Item2> topItems;
    private List<Item2> bottomItems;
    private List<Item2> bagItems;
    private List<Item2> footwearItems;

    public ItemData2(){
        hairItems = new ArrayList<>();
        topItems = new ArrayList<>();
        bottomItems = new ArrayList<>();
        bagItems = new ArrayList<>();
        footwearItems = new ArrayList<>();

        //Hair Items
        hairItems.add(new Item2("Long Black Hair", "Make your Barbie shiny", R.drawable.hair_black));
        hairItems.add(new Item2("High Blonde Ponytail", "Make your Barbie cutier", R.drawable.hair_highblondeponytail));
        hairItems.add(new Item2("Curly Brown Hair", "Make your Barbie stylist", R.drawable.hair_curly));
        hairItems.add(new Item2("Long Blonde Hair", "Make your Barbie elegant", R.drawable.hair_longblonde));
        hairItems.add(new Item2("Modern Brown Hair", "Make your Barbie more Gen-z", R.drawable.hair_modernbrown));

        // Top Items
        topItems.add(new Item2("OneSet Cute Top", "Ya lucu pokoknya", R.drawable.top_cuteoneset));
        topItems.add(new Item2("Bobby's Man Suit", "Jas buat Bobby si macho", R.drawable.top_bobbysuit));
        topItems.add(new Item2("Pink Crop Top", "Stylist dan Modern Top", R.drawable.top_pinkcrop));
        topItems.add(new Item2("Green Line OneSet", "Renda hijau sangat kyut", R.drawable.top_greenoneset));
        topItems.add(new Item2("Colorful Top", "Warna warni buat Bobby", R.drawable.top_colorful));

        // Bottom Items
        bottomItems.add(new Item2("Black Trousers", "Buat Bobby intinya", R.drawable.bottom_1));
        bottomItems.add(new Item2("Pinky Skirt", "Feminime and Girly", R.drawable.bottom_2));
        bottomItems.add(new Item2("Pinky Shorts", "Stylist and Modern Outfit", R.drawable.bottom_3));
        bottomItems.add(new Item2("Big Trousers", "Comfy and Cute", R.drawable.bottom_4));
        bottomItems.add(new Item2("Mermaid Skirt", "Very very cute lah", R.drawable.bottom_5));

        // Bag Items
        bagItems.add(new Item2("Big Pinky Bag", "For vacation", R.drawable.bag_1));
        bagItems.add(new Item2("Mini Pink Bag", "Limited Edition", R.drawable.bag_2));
        bagItems.add(new Item2("Modern Pink Bag", "Stylist and Modern", R.drawable.bag_3));
        bagItems.add(new Item2("Yellow Sling Bag", "Comfortable and Cute", R.drawable.bag_4));
        bagItems.add(new Item2("Aqua Picnic Bag", "For picnic", R.drawable.bag_5));

        //Footwear Items
        footwearItems.add(new Item2("Purple Heels", "Comfortable and girlish", R.drawable.footwear_1));
        footwearItems.add(new Item2("Tosca Heels", "Elegant", R.drawable.footwear_2));
        footwearItems.add(new Item2("Aqua High Wedges", "Stylist and Modern", R.drawable.footwear_3));
        footwearItems.add(new Item2("Boots", "For special ocassion", R.drawable.footwear_4));
        footwearItems.add(new Item2("Pinky Heels", "For daily use", R.drawable.footwear_5));

    }

    public List<Item2> getHairItems() {
        return hairItems;
    }

    public List<Item2> getTopItems() {
        return topItems;
    }

    public List<Item2> getBottomItems() {
        return bottomItems;
    }

    public List<Item2> getBagItems() {
        return bagItems;
    }

    public List<Item2> getFootwearItems() {
        return footwearItems;
    }
}
