package com.tw.pathashala.models;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.NO_BOOK_DETAILS_ARE_FOUND;

public class Library {
    private Search searchAgent;
    private ArrayList<RentableItem> availableRentableItems = new ArrayList<RentableItem>();
    private ArrayList<RentableItem> checkedOutRentableItems = new ArrayList<RentableItem>();

    public Library(ArrayList<RentableItem> availableRentableItems, ArrayList<RentableItem> checkedOutRentableItems, Search searchAgent) {
        this.availableRentableItems = availableRentableItems;
        this.checkedOutRentableItems = checkedOutRentableItems;
        this.searchAgent = searchAgent;
    }

    public String availableItems() {
        return displayItems(availableRentableItems);
    }

    public Boolean checkOut(String bookName) {
        ArrayList<RentableItem> rentableItems = searchAgent.search(availableRentableItems, bookName);
        for (RentableItem book : rentableItems) {
            RentableItem checkedOutRentableItem = book.checkOut();
            availableRentableItems.remove(book);
            return checkedOutRentableItems.add(checkedOutRentableItem);
        }
        return false;
    }

    public String checkedOutItems() {
        return displayItems(checkedOutRentableItems);
    }

    private String displayItems(ArrayList<RentableItem> listOfRentableItems) {
        String booksDetails = "";
        for (RentableItem book : listOfRentableItems) {
            if (!book.isYearInFuture())
                booksDetails = booksDetails.concat(book.toString() + "\n");
        }
        if (booksDetails.equals("")) {
            return NO_BOOK_DETAILS_ARE_FOUND;
        }
        return booksDetails;
    }

    public Boolean returnItem(String bookName) {
        ArrayList<RentableItem> rentableItems = searchAgent.search(checkedOutRentableItems, bookName);
        for (RentableItem book : rentableItems) {
            RentableItem returnedRentableItem = book.returnItem();
            checkedOutRentableItems.remove(book);
            return availableRentableItems.add(returnedRentableItem);
        }
        return false;
    }
}
