package com.tw.pathashala.models;

import java.util.ArrayList;
import java.util.Map;

public class Authentication {
    private ArrayList<User> users;
    private Map<User, InputParser> userMenuMapper;
    private User currentLoggedInUser;

    public Authentication(ArrayList<User> users, Map<User, InputParser> userMenuMap) {
        currentLoggedInUser = null;
        this.users = users;
        this.userMenuMapper = userMenuMap;
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

    public InputParser getMenuMapper() {
        return userMenuMapper.get(currentLoggedInUser);
    }
}
