package com.tw.pathashala.models;

import java.util.ArrayList;
import java.util.Map;

public class UserHistory {
    Authentication authentication;
    Map<User, ArrayList<RentableItem>> userCheckOutHistory;

    public UserHistory(Authentication authentication, Map<User, ArrayList<RentableItem>> userCheckOutHistory) {
        this.authentication = authentication;
        this.userCheckOutHistory = userCheckOutHistory;
    }

    public void addItem(RentableItem item) {
        User currentLoggedInUser = authentication.getCurrentLoggedInUser();
        userCheckOutHistory.get(currentLoggedInUser).add(item);
    }
}
