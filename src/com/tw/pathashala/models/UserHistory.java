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
        User currentLoggedInUser = getCurrentLoggedInUser();
        userCheckOutHistory.get(currentLoggedInUser).add(item);
    }

    public void removeItem(RentableItem item) {
        User currentLoggedInUser = getCurrentLoggedInUser();
        userCheckOutHistory.get(currentLoggedInUser).remove(item);
    }

    private User getCurrentLoggedInUser() {
        return authentication.getCurrentLoggedInUser();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (User user : userCheckOutHistory.keySet()) {
            output.append(String.format("| %-97s|\n",user.toString().concat(":")));
            for(RentableItem item : userCheckOutHistory.get(user)) {
                output.append(item.toString());
            }
        }
        return output.toString();
    }
}
