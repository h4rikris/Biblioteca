package com.tw.pathashala.models;

import java.util.ArrayList;

public class Search {
    public ArrayList<RentableItem> search(ArrayList<RentableItem> rentableItemDetails, String searchString) {
        ArrayList<RentableItem> rentableItems = new ArrayList<RentableItem>();
        for (RentableItem rentableItem : rentableItemDetails) {
            rentableItem.addToListIfTitleMatches(rentableItems, searchString);
        }
        return rentableItems;
    }
}
