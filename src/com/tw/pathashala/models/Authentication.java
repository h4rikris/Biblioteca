package com.tw.pathashala.models;

import java.util.ArrayList;

public class Authentication {
    private ArrayList<User> users;
    private User currentLoggedInUser;

    public Authentication(ArrayList<User> users) {
        currentLoggedInUser = null;
        this.users = users;
    }

    public Boolean authenticate(String userName, String password) {
        for (User user : users) {
            if (user.checkCredentials(userName, password)) {
                currentLoggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    public void setCurrentLoggedInUser(User currentLoggedInUser) {
        this.currentLoggedInUser = currentLoggedInUser;
    }
}
