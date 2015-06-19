package com.tw.pathashala.models;

import java.util.Map;

public class MenuMapper {
    private Authentication authentication;
    private Map<Integer, InputParser> menuMap;

    public MenuMapper(Authentication authentication, Map<Integer, InputParser> menuMap) {
        this.authentication = authentication;
        this.menuMap = menuMap;
    }

    public InputParser getMenu() {
        User user = authentication.getCurrentLoggedInUser();
        Integer role = user.getRole();
        return menuMap.get(role);
    }
}
