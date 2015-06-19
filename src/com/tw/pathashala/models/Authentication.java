package com.tw.pathashala.models;

import java.util.ArrayList;

public class Authentication {
    private ArrayList<User> users;
    private User currentLoggedInUser;
    private User nullUser;

    public Authentication(ArrayList<User> users, User nullUser) {
        this.nullUser = nullUser;
        currentLoggedInUser = nullUser;
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

    public void logout() {
        this.currentLoggedInUser = nullUser;
    }
}
