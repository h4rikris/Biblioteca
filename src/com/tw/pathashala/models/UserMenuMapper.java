package com.tw.pathashala.models;

import java.util.Map;

public class UserMenuMapper {
    private Authentication authentication;
    private Map<User, InputParser> menuMap;

    public UserMenuMapper(Authentication authentication, Map<User, InputParser> menuMap) {
        this.authentication = authentication;
        this.menuMap = menuMap;
    }

    public InputParser getMenu() {
        User user = authentication.getCurrentLoggedInUser();
        return menuMap.get(user);
    }
}
