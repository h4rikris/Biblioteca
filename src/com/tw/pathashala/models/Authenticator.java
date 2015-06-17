package com.tw.pathashala.models;

import java.util.ArrayList;
import java.util.Map;

public class Authenticator {
    private ArrayList<User> users;
    private Map<User, InputParser> userMenuMapper;
    private User currentLoggedInUser;

    public Authenticator(ArrayList<User> users, Map<User, InputParser> userMenuMap) {
        currentLoggedInUser = null;
        this.users = users;
        this.userMenuMapper = userMenuMap;
    }

    public User authenticate(String userName, String password) {
        for (User user : users) {
            if (user.checkCredentials(userName, password)) {
                currentLoggedInUser = user;
                return user;
            }
        }
        return null;
    }

    public InputParser getMenuMapper() {
        return userMenuMapper.get(currentLoggedInUser);
    }
}
