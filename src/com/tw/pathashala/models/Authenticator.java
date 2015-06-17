package com.tw.pathashala.models;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> users;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }


    public User authenticate(String userName, String password) {
        for (User user : users) {
            if (user.checkCredentials(userName, password)) {
                return user;
            }
        }
        return null;
    }
}
