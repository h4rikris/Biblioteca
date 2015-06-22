package com.tw.pathashala.models;

import com.tw.pathashala.constants.Constants;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.NO_ITEMS_DETAILS_ARE_FOUND;

public class Library {
    private Search searchAgent;
    private ArrayList<RentableItem> availableRentableItems = new ArrayList<RentableItem>();
    private ArrayList<RentableItem> checkedOutRentableItems = new ArrayList<RentableItem>();
    private UserHistory userHistory;

    public Library(ArrayList<RentableItem> availableRentableItems, ArrayList<RentableItem> checkedOutRentableItems, Search searchAgent, UserHistory userHistory) {
        this.availableRentableItems = availableRentableItems;
        this.checkedOutRentableItems = checkedOutRentableItems;
        this.searchAgent = searchAgent;
        this.userHistory = userHistory;
    }

    public String availableItems() {
        return displayItems(availableRentableItems);
    }

    public String checkOut(String bookName) {
        ArrayList<RentableItem> rentableItems = searchAgent.search(availableRentableItems, bookName);
        for (RentableItem book : rentableItems) {
            RentableItem checkedOutRentableItem = book.checkOut();
            availableRentableItems.remove(book);
            checkedOutRentableItems.add(checkedOutRentableItem);
            userHistory.addItem(checkedOutRentableItem);
            return book.getSuccessMessage();
        }
        if (availableRentableItems.size() >= 1) {
            return availableRentableItems.get(0).getFailMessage();
        } else {
            return Constants.NO_ITEMS_DETAILS_ARE_FOUND;
        }
    }

    public String checkedOutItems() {
        return displayItems(userHistory.getItemList());
    }

    private String displayItems(ArrayList<RentableItem> listOfRentableItems) {
        String booksDetails = "";
        for (RentableItem book : listOfRentableItems) {
            if (!book.isYearInFuture())
                booksDetails = booksDetails.concat(book.toString() + "\n");
        }
        if (booksDetails.equals("")) {
            return NO_ITEMS_DETAILS_ARE_FOUND;
        }
        return booksDetails;
    }

    public String returnItem(String bookName) {
        ArrayList<RentableItem> rentableItems = searchAgent.search(userHistory.getItemList(), bookName);
        for (RentableItem book : rentableItems) {
            RentableItem returnedRentableItem = book.returnItem();
            checkedOutRentableItems.remove(book);
            userHistory.removeItem(book);
            availableRentableItems.add(returnedRentableItem);
            return book.getSuccessMessage();
        }
        if (checkedOutRentableItems.size() >= 1) {
            return checkedOutRentableItems.get(0).getFailMessage();
        }
        return Constants.NO_ITEMS_DETAILS_ARE_FOUND;
    }

}
